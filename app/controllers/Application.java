package controllers;

import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }
  
  /**
   * Returns newcontact, a page to add a new contact.
   * @param id ID field
   * @return The NewContact page.
   */
  public static Result newContact(long id) {
    ContactFormData data;
    if (id == 0) {
      data = new ContactFormData();
    }
    else {
      data = new ContactFormData(ContactDB.getContact(id));
    }
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> types = TelephoneTypes.getTypes(data.telephoneType);
    return ok(NewContact.render(formData, types));
    
  }
  
  /**
   * Returns postcontact, takes the information from the form and adds a new contact.
   * @return The NewContact page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    Map<String, Boolean> types;
    if (formData.hasErrors()) {
      System.out.println("Errors exist.");
      types = TelephoneTypes.getTypes();
      return badRequest(NewContact.render(formData, types));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.store(data);
      types = TelephoneTypes.getTypes(data.telephoneType);
      System.out.println(data.firstName + " " + data.lastName + " " + data.telephone);
      return ok(NewContact.render(formData, types));
    }
  }
  
  /**
   * Deletes contact from repository.
   * @param id ID of contact
   * @return the Index page with updated contact table
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }
}
