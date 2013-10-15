package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * Provides backing class for NewContact page form.
 * @author Eva Shek
 */
public class ContactFormData {
  /** First name field value. */
  public String firstName = "";
  /** Last name field value. */
  public String lastName = "";
  /** Phone number field value. */
  public String telephone = "";
  /** ID field value. */
  public long id = 0;
  
  private static final int PHONE_LENGTH = 12;
  
  /**
   * Default no-arg constructor.
   */
  public ContactFormData() {
    
  }
  
  /**
   * Constructs a ContactFormData based on the information from a contact.
   * @param contact Contact info
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirst();
    this.lastName = contact.getLast();
    this.telephone = contact.getPhone();
    this.id = contact.getId();
  }
  
  /**
   * Checks that all fields are entered properly.
   * @return List of errors associated with form.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Phone number is required."));
    }
    if (telephone.length() != PHONE_LENGTH) {
      errors.add(new ValidationError("telephone", "Phone number needs to follow xxx-xxx-xxxx."));
    }
    return errors.isEmpty() ? null : errors;
  }
}
