package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Takes ContactFormData and turns the information into a Contact object.
 * @author Eva Shek
 */
public class ContactDB {
  List<Contact> contacts = new ArrayList<>();
  
  /**
   * Stores the information from the form into a Contact object.
   * @param formData Information from form
   */
  public void store(ContactFormData formData) {
    contacts.add(new Contact(formData.firstName, formData.lastName, formData.telephone));
  }
  
  /**
   * Retrieves the list of contacts.
   * @return contact list
   */
  public List<Contact> getContacts() {
    return contacts;
  }
}
