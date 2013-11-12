package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the login form.
 */
public class RegistrationFormData {
  
  /** The name. */
  public String name = "";
  /** The email. */
  public String email = "";
  /** The password. */
  public String password = "";

  /** Required for form instantiation. */
  public RegistrationFormData() {
  }

  /**
   * Validates Form<RegistrationFormData>.
   * Checks to see that name, email, and password are sufficiently supplied.
   * @return Null if invalid form, List if good input
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    if (name == null || name == "") {
      errors.add(new ValidationError("name", "Name is required."));
    }
    if (email == null || email == "") {
      errors.add(new ValidationError("email", "Email is required."));
    }
    if (password == null || password == "") {
      errors.add(new ValidationError("password", "Password is required."));      
    }
    if (UserInfoDB.isUser(email)) {
      // email exists
      errors.add(new ValidationError("email", "Email already exists."));
    }
    return (errors.size() > 0) ? errors : null;
  }

}
