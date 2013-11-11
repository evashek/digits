package models;

import java.util.HashMap;
import java.util.Map;

public class UserInfoDB {
  
  private static Map<String, UserInfo> users = new HashMap<>();
  
  public static void addUserInfo(String name, String email, String password) {
    users.put(email, new UserInfo(name, email, password));
  }
  
  public static boolean isUser(String email) {
    return users.containsKey(email);
  }

  public static UserInfo getUser(String email) {
    String temp = "";
    if (email != null) {
      temp = email;
    }
    return users.get(temp);
  }
  
  public static boolean isValid(String email, String password) {
    if ((email != null) && (password != null) && isUser(email) && (getUser(email).getPassword().equals(password))) {
      return true;
    }
    return false;
  }
  
}
