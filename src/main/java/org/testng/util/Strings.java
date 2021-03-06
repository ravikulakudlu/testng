package org.testng.util;

import org.testng.collections.Maps;

import java.util.Map;

public final class Strings {
  private Strings() {
    //Utility class. Defeat instantiation.
  }
  public static boolean isNullOrEmpty(String string) {
    return string == null || string.trim().isEmpty();
  }

  public static boolean isNotNullAndNotEmpty(String string) {
    return ! (isNullOrEmpty(string));
  }

  /**
   * @param string - The input String.
   * @return - Returns an empty string if the input String is <code>null</code> (or) empty, else it returns
   * back the input string.
   */
  public static String getValueOrEmpty(String string) {
    return isNotNullAndNotEmpty(string) ? string : "";
  }

  private static final Map<String, String> ESCAPE_HTML_MAP = Maps.newLinkedHashMap();

  static {
    ESCAPE_HTML_MAP.put("&", "&amp;");
    ESCAPE_HTML_MAP.put("<", "&lt;");
    ESCAPE_HTML_MAP.put(">", "&gt;");
  }

  public static String escapeHtml(String text) {
    String result = text;
    for (Map.Entry<String, String> entry : ESCAPE_HTML_MAP.entrySet()) {
      result = result.replace(entry.getKey(), entry.getValue());
    }
    return result;
  }

}
