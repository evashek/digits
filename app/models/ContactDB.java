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

  private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long, Contact>>();

  /**
   * Stores the information from the form.
   * @param formData Information from form
   */
  public static void store(String user, ContactFormData formData) {
    if (!isUser(user)) {
      contacts.put(user, new HashMap<Long, Contact>());
    }
    long id = (formData.id == 0) ? contacts.get(user).size() + 1 : formData.id;
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, id,
        formData.telephoneType);
    contacts.get(user).put(id, contact);
  }
  
  private static boolean isUser(String user) {
    return contacts.containsKey(user);
  }

  /**
   * Retrieves a Contact object based on ID key.
   * @param id ID key
   * @return Associated Contact object
   */
  public static Contact getContact(String user, long id) {
    return (Contact) contacts.get(user).get(id);
  }
  
  /**
   * Retrieves list of contacts.
   * @return List
   */
  public static List<Contact> getContacts(String user) {
    if (!isUser(user)) {
      return null;
    }
    return new ArrayList<>(contacts.get(user).values());
  }
  
  /**
   * Deletes a contact by specified id.
   * @param id ID key
   */
  public static void deleteContact(String user, long id) {
    contacts.get(user).remove(id);
  }
}
