package controllers;

import java.util.Map;
import models.ContactDB;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.ContactFormData;
import views.formdata.LoginFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.Login;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  @Security.Authenticated(Secured.class)
  public static Result index() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    return ok(Index.render("Digits database", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
        ContactDB.getContacts(user)));
  }

  /**
   * Returns newcontact, a page to add a new contact.
   * @param id ID field
   * @return The NewContact page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    ContactFormData data;
    if (id == 0) {
      data = new ContactFormData();
    }
    else {
      data = new ContactFormData(ContactDB.getContact(user, id));
    }
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telTypes = TelephoneTypes.getTypes(data.telephoneType);
    return ok(NewContact.render("Add new contact", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
        formData, telTypes));

  }

  /**
   * Returns postcontact, takes the information from the form and adds a new contact.
   * @return The NewContact page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postContact() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    Map<String, Boolean> telTypes;
    if (formData.hasErrors()) {
      System.out.println("Errors exist.");
      telTypes = TelephoneTypes.getTypes();
      return badRequest(NewContact.render("Add new contact", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formData, telTypes));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.store(user, data);
      telTypes = TelephoneTypes.getTypes(data.telephoneType);
      return ok(NewContact.render("Add new contact", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
          formData, telTypes));
    }
  }

  /**
   * Deletes contact from repository.
   * @param id ID of contact
   * @return the Index page with updated contact table
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    ContactDB.deleteContact(user, id);
    return ok(Index.render("Digits database", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        ContactDB.getContacts(user)));
  }

  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }

  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}
