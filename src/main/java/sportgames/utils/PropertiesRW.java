package sportgames.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesRW {
    public static String loadProperty(String path, String key)  {

        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream  = new FileInputStream(path);
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveProperty(String path, String key, String value) {

        Properties properties = new Properties();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            properties.setProperty(key, value);
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
