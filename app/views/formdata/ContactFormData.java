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
  public long id = -1;
  /** Telephone type. */
  public String telephoneType = "";
  
  private static final int PHONE_LENGTH = 12;
  
  /**
   * Default no-arg constructor.
   */
  public ContactFormData() {
    
  }
  
  /**
   * Constructs a ContactFormData based on the individual information from a contact. (Used in Global.java)
   * @param firstName First name of contact
   * @param lastName Last name of contact
   * @param telephone telephone number
   * @param telephoneType type of number
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
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
    this.telephoneType = contact.getTelephoneType();
  }
  
  /**
   * Checks that all fields are entered properly.
   * @return List of errors associated with form.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "No first name was given."));
    }
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "No last name was given."));
    }
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "No phone number was given."));
    }
    if (telephone.length() != PHONE_LENGTH) {
      errors.add(new ValidationError("telephone", "Phone number did not follow the xxx-xxx-xxxx format."));
    }
    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Invalid telephone type."));
    }
    return errors.isEmpty() ? null : errors;
  }
}
