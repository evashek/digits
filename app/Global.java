import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
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
    
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPass = Play.application().configuration().getString("digits.admin.pass");
    
    UserInfoDB.defineAdmin("Admin", adminEmail, adminPass);
    
    if (UserInfoDB.adminDefined() && UserInfoDB.getUser(adminEmail).getContacts().isEmpty()) {
      ContactDB.store(adminEmail, new ContactFormData("Jane", "Smith", "012-345-6789", "Home"));
      ContactDB.store(adminEmail, new ContactFormData("Joe", "Jones", "901-234-5678", "Mobile"));
      ContactDB.store(adminEmail, new ContactFormData("John", "Doe", "123-456-7890", "Work"));
      ContactDB.store(adminEmail, new ContactFormData("Fizz", "Buzz", "890-123-4567", "Mobile"));
    }
  }

}