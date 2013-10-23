package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows user to specify three telephone number types.
 * @author Eva Shek
 */
public class TelephoneTypes {
  private static String[] types = {"Home", "Work", "Mobile"};
  
  /**
   * A map of telephone types.
   * @return mapTypes Type map
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> mapTypes = new HashMap<>();
    for (String type : types) {
      mapTypes.put(type, false);
    }
    return mapTypes;
  }

  /**
   * A map of telephone types with specified type set to true.
   * @param type Type of telephone
   * @return mapTypes Type map 
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> mapTypes = TelephoneTypes.getTypes();
    if (isType(type)) {
      mapTypes.put(type, true);
    }
    return mapTypes;
  }
  
  /**
   * Verifies whether type is valid.
   * @param type Type of telephone
   * @return true is type is valid, false otherwise
   */
  public static boolean isType(String type) {
    return TelephoneTypes.getTypes().containsKey(type);
  }

}
