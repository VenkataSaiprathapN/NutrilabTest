package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {
        try {
            // Load the properties file
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    // Method to get a property by key
    public static String get(String key) {
        return prop.getProperty(key);
    }
}
