package lesson7.homework10.fileLogger;

import lesson7.homework10.LoggerConfigurationLoader;
import lesson7.homework10.LoggingLevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends LoggerConfigurationLoader {

    private LoggingLevel level;
    private File file;
    private MessageFormat format;
    byte maxCapacity;

    @Override
    public FileLoggerConfiguration load() {
        Properties property = new Properties();

        try (BufferedReader reader = new BufferedReader(new FileReader("logging.properties"))) {
            property.load(reader);
            if (property.getProperty("LEVEL").equals(LoggingLevel.DEBUG.toString())) {
                level = LoggingLevel.DEBUG;
            } else {
                level = LoggingLevel.INFO;
            }
            format = new MessageFormat(property.getProperty("FORMAT"));
            file = new File(property.getProperty("FILE"));
            maxCapacity = Byte.parseByte(property.getProperty("MAX-SIZE"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FileLoggerConfiguration(level, format, file, maxCapacity);
    }
}
