package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
@Entity
public class UserInfo extends Model {
 
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  private long id;
  private String name;
  private String email;
  private String password;
  private boolean admin = false;
  
  @OneToMany(mappedBy = "userInfo")
  private List<Contact> contacts = new ArrayList<>();
  
  /**
   * Gets the list of contacts associated with this user.
   * @return Contact list
   */
  public List<Contact> getContacts() {
    return this.contacts;
  }
  
  /**
   * Adds a contact to the list of contacts associated with user.
   * @param contact Contact to add
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
  }
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Whether the user is the admin.
   * @return the admin
   */
  public boolean isAdmin() {
    return admin;
  }

  /**
   * Set a user as admin.
   * @param admin the admin to set
   */
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}
