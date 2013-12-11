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
public class NewContactPage extends FluentPage {
  private String url;
  
  /**
   * Create the NewContactPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Add new contact");
  }
  
  /**
   * Fill in the contact form and submit.
   * @param fName First name of contact
   * @param lName Last name
   * @param telephone Phone number
   * @param type Number type
   */
  public void addContact(String fName, String lName, String telephone, String type) {
    fill("#firstName").with(fName);
    fill("#lastName").with(lName);
    fill("#telephone").with(telephone);
    find("select", withId().equalTo("telephoneType")).find("option", withText().equalTo(type)).click();
    
    submit("#newcontsubmit");
  }
}