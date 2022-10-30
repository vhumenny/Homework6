package lesson7.homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends LoggerConfigurationLoader {

    private LoggingLevel level;

    @Override
    public FileLoggerConfiguration load() {
        Properties property = new Properties();

        FileLoggerConfiguration configuration;

        try (BufferedReader reader = new BufferedReader(new FileReader("logging.properties"))) {

            property.load(reader);
            if (property.getProperty("LEVEL").equals("DEBUG")) {
                level = LoggingLevel.DEBUG;
            } else {
                level = LoggingLevel.INFO;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration = new FileLoggerConfiguration(level, new MessageFormat(property.getProperty("FORMAT")),
                new File(property.getProperty("FILE")), Byte.parseByte(property.getProperty("MAX-SIZE")));

        return configuration;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }
}
