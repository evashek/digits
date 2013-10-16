package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Stores all contact information.
 * @author Eva Shek
 */
public class ContactDB {

  private static Map<Long, Contact> contacts = new HashMap<>();

  /**
   * Stores the information from the form.
   * @param formData Information from form
   */
  public static void store(ContactFormData formData) {
    Contact contact;
    if (formData.id == 0) {
      long id = contacts.size() + 1;
      contact = new Contact(formData.firstName, formData.lastName, formData.telephone, id);
      contacts.put(id, contact);
    }
    else {
      contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.id);
      contacts.put(formData.id, contact);
    }
  }
  
  /**
   * Retrieves a Contact object based on ID key.
   * @param id ID key
   * @return Associated Contact object
   */
  public static Contact getContact(long id) {
    return (Contact) contacts.get(id);
  }
  
  /**
   * Retrieves list of contacts.
   * @return List
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
  
  /**
   * Deletes a contact by specified id.
   * @param id ID key
   */
  public static void deleteContact(long id) {
    contacts.remove(id);
  }
}
