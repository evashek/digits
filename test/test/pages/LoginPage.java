package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in login page.
 * @author Eva Shek
 */
public class LoginPage extends FluentPage {
  private String url;
  
  /**
   * Create the LoginPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Login");
  }
  
  /**
   * Email entered.
   * @param email The email to check
   */
  public void setEmail(String email) {
    fill("#email").with(email);
  }
  
  /**
   * Password entered.
   * @param password The password to check
   */
  public void setPassword(String password) {
    fill("#password").with(password);
  }
  
  /**
   * Submitting of login credentials.
   */
  public void submit() {
    submit("#submit");
  }

}