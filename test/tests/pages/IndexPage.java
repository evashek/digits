package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits database");
  }
  
  /**
   * Click the login link.
   */
  public void goToLogin() {
    find("#login").click();
  }
  
  /**
   * Click the logout link.
   */
  public void logout() {
    find("#logout").click();
  }
  
  /**
   * Click the New Contact link.
   */
  public void goToNewContact() {
    find("#newcont").click();
  }
  
  /**
   * Check if logged in.
   * @return true if user can see New Contact link, false otherwise
   */
  public boolean isLoggedIn() {
    return !find("#newcont").isEmpty();
  }
  
  /**
   * Check if logged out.
   * @return true if user cannot see New Contact link, false otherwise
   */
  public boolean isLoggedOut() {
    return find("#newcont").isEmpty();
  }
  
}