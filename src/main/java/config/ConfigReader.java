package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    private static final String propsFile = "src/test/resources/config.properties";


    static {
        try (FileInputStream fis = new FileInputStream(propsFile)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("not found file " + propsFile + " to load properties", e);
        } catch (IOException e) {
            throw new RuntimeException("error in reading " + propsFile + " file", e);
        }
    }

    static public String getProp(String key) {
        return properties.getProperty(key);
    }


}