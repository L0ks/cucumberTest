package org.example.helpers;

public class SystemPropertyHelper {
    public static boolean getBooleanProperty(String key) {
        String value = System.getProperty(key);
        return value != null && value.equalsIgnoreCase("true");
    }
}
