package controllers;

import play.mvc.Controller;
import play.mvc.Result;
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
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns newcontact, a page to add a new contact.
   * @return The NewContact page.
   */
  public static Result newcontact() {
    return ok(NewContact.render("Welcome to NewContact."));
    
  }
}
