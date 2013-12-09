package test;

import org.junit.Test;
import play.Play;
import play.test.TestBrowser;
import play.libs.F.Callback;
import test.pages.IndexPage;
import test.pages.LoginPage;
import test.pages.NewContactPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the index page can be retrieved.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:" + PORT);
        assertThat(browser.pageSource()).contains("Digits");
      }
    });
  }
  
  /**
   * Check to see that the user can log in and log out correctly.
   */
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.setEmail(Play.application().configuration().getString("digits.admin.email"));
        loginPage.setPassword(Play.application().configuration().getString("digits.admin.pass"));
        loginPage.submit();
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.logout();
        assertThat(indexPage.isLoggedOut()).isTrue();
      }
    });
  }
  
  /**
   * Check to see that the user can add a new contact.
   */
  @Test
  public void testNewContact() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.setEmail(Play.application().configuration().getString("digits.admin.email"));
        loginPage.setPassword(Play.application().configuration().getString("digits.admin.pass"));
        loginPage.submit();
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.goToNewContact();
        
        NewContactPage newContactPage = new NewContactPage(browser.getDriver(), PORT);
        newContactPage.isAt();
        newContactPage.addContact("A", "B", "123-456-7890", "Home");
        
        browser.goTo(indexPage);
        assertThat(browser.pageSource()).contains("123-456-7890");
      }
    });
  }

}
