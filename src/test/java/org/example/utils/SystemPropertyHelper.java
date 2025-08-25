package org.example.utils;

public class SystemPropertyHelper {
    public static boolean getBooleanProperty(String key) {
        String value = System.getProperty(key);
        return value != null && value.equalsIgnoreCase("true");
    }

    public static String getEnvironment() {
        if(System.getProperty("env") == null) System.setProperty("env", "dev");
        return System.getProperty("env").toLowerCase();
    }
}
