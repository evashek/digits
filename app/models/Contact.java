package models;

/**
 * Constructs a Contact object that stored information from form.
 * @author Eva Shek
 *
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private long id;
  
  /**
   * Constructs a Contact object storing the name and phone number.
   * @param firstName First name
   * @param lastName Last name
   * @param telephone Phone number
   * @param id ID
   */
  public Contact(String firstName, String lastName, String telephone, long id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.id = id;
  }
  
  /**
   * Sets the first name.
   * @param firstName First name
   */
  public void setFirst(String firstName)  {
    this.firstName = firstName;
  }
  
  /**
   * Sets the last name.
   * @param lastName Last name
   */
  public void setLast(String lastName)  {
    this.lastName = lastName;
  }
  
  /**
   * Sets the phone number.
   * @param telephone Phone number
   */
  public void setPhone(String telephone)  {
    this.telephone = telephone;
  }
  
  /**
   * Retrieves the first name.
   * @return First name
   */
  public String getFirst() {
    return firstName;
  }
  
  /**
   * Retrieves the last name.
   * @return Last name
   */
  public String getLast() {
    return lastName;
  }
  
  /**
   * Retrieves the phone number.
   * @return Phone number
   */
  public String getPhone() {
    return telephone;
  }

  /**
   * Retrieves ID.
   * @return ID
   */
  public long getId() {
    return id;
  }

  /**
   * Sets ID.
   * @param id the ID
   */
  public void setId(long id) {
    this.id = id;
  }
}
