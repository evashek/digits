package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Stores all contact information.
 * @author Eva Shek
 */
public class ContactDB {
  List<Contact> contacts = new ArrayList<>();

  /**
   * Stores the information from the form.
   * @param formData Information from form
   */
  public void store(ContactFormData formData) {
    contacts.add(new Contact(formData.firstName, formData.lastName, formData.telephone));
  }
  
  /**
   * Retrieves list of contacts.
   * @return List
   */
  public List<Contact> getContacts() {
    return contacts;
  }
}
