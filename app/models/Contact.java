package models;

/**
 * Constructs a Contact object storing informaton of each contact.
 * @author Eva Shek
 */
public class Contact {
  private String firstName = "";
  private String lastName = "";
  private String telephone = "";
  
  /**
   * Constructor for the Contact object.
   * @param firstName First name
   * @param lastName Last name
   * @param telephone Phone number
   */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
  }
  
  /**
   * Sets the first name.
   * @param firstName Name
   */
  public void setFirst(String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * Sets the last name.
   * @param lastName Name
   */
  public void setLast(String lastName) {
    this.lastName = lastName;
  }
  
  /**
   * Sets the phone number.
   * @param telephone Number
   */
  public void setPhone(String telephone) {
    this.telephone = telephone;
  }
  
  /**
   * Retrieves the first name.
   * @return First name String
   */
  public String getFirst() {
    return firstName;
  }
  
  /**
   * Retrieves the last name.
   * @return Last name String
   */
  public String getLast() {
    return lastName;
  }
  
  /**
   * Retrieves the phone number.
   * @return Number String
   */
  public String getPhone() {
    return telephone;
  }
}
