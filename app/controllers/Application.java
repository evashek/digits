package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {
  
  private static ContactDB list = new ContactDB();

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(list.getContacts()));
  }
  
  /**
   * Returns newcontact, a page to add a new contact.
   * @return The NewContact page.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
    
  }
  
  /**
   * Returns postcontact, takes the information from the form and adds a new contact.
   * @return The NewContact page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors exist.");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      list.store(data);
      System.out.println(data.firstName + " " + data.lastName + " " + data.telephone);
      return ok(NewContact.render(formData));
    }
  }
}
