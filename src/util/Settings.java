package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static File appConfigPath = new File("app.properties");
    private static Properties properties;

    static {
        if (properties == null)
            properties = new Properties();
        try {
            properties.load(new FileInputStream(appConfigPath.getAbsoluteFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Properties getProperties() {
        return properties;
    }

    private Settings() {}
}
