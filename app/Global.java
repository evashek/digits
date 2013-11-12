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
    
    String adminEmail = Play.application().configuration().getString("admin.email");
    String adminPass = Play.application().configuration().getString("admin.password");

    UserInfoDB.addUserInfo("Admin", adminEmail, adminPass);
    if (UserInfoDB.adminDefined()) {
      ContactDB.store(adminEmail, new ContactFormData(new Contact("Jane", "Smith", "012-345-6789", "Home")));
      ContactDB.store(adminEmail, new ContactFormData(new Contact("Joe", "Jones", "901-234-5678", "Mobile")));
    }
  }

}