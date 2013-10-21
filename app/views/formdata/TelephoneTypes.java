package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * The telephone type object.
 * @author Eva Shek
 */
public class TelephoneTypes {
  // All valid telephone types.
  private static String[] types = {"Home", "Work", "Mobile"};
  
  /**
   * A list of all telephone types with default value of false.
   * @return Types
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> mapType = new HashMap<>();
    for (String type : types) {
      mapType.put(type, false);
    }
    return mapType;
  }
  
  /**
   * A list of all telephone types with the specified telephone type set to true.
   * @param type Type of telephone
   * @return Types with type set to true
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> mapType = TelephoneTypes.getTypes();
    mapType.put(type, true);
    return mapType;
  }
  
  /**
   * Verifies if telephone type is valid.
   * @param type Type of telephone
   * @return true if valid telephone type, false otherwise
   */
  public static boolean isType(String type) {
    return TelephoneTypes.getTypes().containsKey(type);
  }
}
