import models.Contact;
import models.ContactDB;
import models.UserInfoDB;
import play.*;
import views.formdata.ContactFormData;

/**
 * Create a global object that can initialize contacts in the Digits application.
 * @author Eva Shek
 */
public class Global extends GlobalSettings {

  /**
   * Executes startup code with sample contacts.
   * @param app Application
   */
  public void onStart(Application app) {
    
    UserInfoDB.addUserInfo("John Doe", "doe@example.com", "password");
    UserInfoDB.addUserInfo("Jane Smith", "smith@example.com", "drowssap");
    
    
    ContactFormData[] johnsContacts = {new ContactFormData(new Contact("Jane", "Smith", "012-345-6789", "Home")),
        new ContactFormData(new Contact("Joe", "Jones", "901-234-5678", "Mobile"))};
    
    ContactFormData[] janesContacts = {new ContactFormData(new Contact("John", "Doe", "123-456-7890", "Work")),
        new ContactFormData(new Contact("Fizz", "Buzz", "890-123-4567", "Mobile"))};
    
    for (int i = 0; i <= 1; i++) {
      ContactDB.store("doe@example.com", johnsContacts[i]);
      ContactDB.store("smith@example.com", janesContacts[i]);
    }
    
  }

}