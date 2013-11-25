package models;

import java.util.List;
import views.formdata.ContactFormData;

/**
 * Stores all contact information.
 * @author Eva Shek
 */
public class ContactDB {

  /**
   * Stores the information from the form.
   * @param user Current signed-in user
   * @param formData Information from form
   */
  public static void store(String user, ContactFormData formData) {
    boolean isNewContact = (formData.id == -1);
    if (isNewContact) {
      Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      // find the user from the database
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if (userInfo == null) {
        throw new RuntimeException("User '" + user + "' not found.");
      }
      // satisfy the many-to-one relationship
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      userInfo.save();
      contact.save();
    }
    else {
      // do not know which field is updated, so update all of them
      Contact contact = Contact.find().byId(formData.id);
      contact.setFirst(formData.firstName);
      contact.setLast(formData.lastName);
      contact.setPhone(formData.telephone);
      contact.setTelephoneType(formData.telephoneType);
      contact.save();
    }
  }
  
  /**
   * Indicates whether the supplied email exists in database.
   * @param user Email of user
   * @return true is exists, false otherwise
   */
  private static boolean isUser(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo != null) {
      return true;
    }
    return false;
  }

  /**
   * Retrieves a Contact object based on ID key.
   * @param user Current signed in user
   * @param id ID key
   * @return Associated Contact object
   */
  public static Contact getContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Contact with ID " + id + " not found.");
    }
    UserInfo contactUserInfo = contact.getUserInfo();
    if (!user.equals(contactUserInfo.getEmail())) {
      throw new RuntimeException("User '" + user + "' not authorized for contact.");
    }
    return contact;
  }
  
  /**
   * Retrieves list of contacts.
   * @param user Current signed in user
   * @return List
   */
  public static List<Contact> getContacts(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }
  
  /**
   * Deletes a contact by specified id.
   * @param user Current signed in user
   * @param id ID key
   */
  public static void deleteContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Contact with ID " + id + " not found.");
    }
    UserInfo contactUserInfo = contact.getUserInfo();
    if (!user.equals(contactUserInfo.getEmail())) {
      throw new RuntimeException("User '" + user + "' not authorized for contact.");
    }
    Contact.find().ref(id).delete();
  }
}
