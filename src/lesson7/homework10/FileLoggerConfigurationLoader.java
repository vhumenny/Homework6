package lesson7.homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    File file;
    static LoggingLevel level;
    static byte maxCapacity;
    static MessageFormat format;
    static FileLoggerConfiguration configurationFromFile;

    public static FileLoggerConfiguration load() {
        Properties property = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader("logging.properties"))) {

            property.load(reader);
            File file = new File(property.getProperty("FILE"));
            if (property.getProperty("LEVEL").equals("DEBUG")) {
                level = LoggingLevel.DEBUG;
            } else {
                level = LoggingLevel.INFO;
            }
            maxCapacity = Byte.parseByte(property.getProperty("MAX-SIZE"));
            format = new MessageFormat(property.getProperty("FORMAT"));
            configurationFromFile = new FileLoggerConfiguration(file, level,maxCapacity,format);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return configurationFromFile;
    }
}
