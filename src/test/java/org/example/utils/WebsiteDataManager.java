package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebsiteDataManager {
    private final Properties properties = new Properties();

    public WebsiteDataManager(String website, String env) {
        String filePath = String.format("websites/config-%s-%s.properties", website, env);
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IllegalArgumentException("Configuration file not found: " + filePath);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + filePath, e);
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
