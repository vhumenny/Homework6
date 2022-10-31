package lesson7.homework10.stdoutLogger;

import lesson7.homework10.LoggerConfiguration;
import lesson7.homework10.LoggerConfigurationLoader;
import lesson7.homework10.LoggingLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class StdoutLoggerConfigurationLoader extends LoggerConfigurationLoader {
    private LoggingLevel level;
    private MessageFormat format;

    @Override
    public LoggerConfiguration load() {
        Properties property = new Properties();

        try (BufferedReader reader = new BufferedReader(new FileReader("logging.properties"))) {
            property.load(reader);
            if (property.getProperty("LEVEL").equals(LoggingLevel.DEBUG.toString())) {
                level = LoggingLevel.DEBUG;
            } else {
                level = LoggingLevel.INFO;
            }
            format = new MessageFormat(property.getProperty("FORMAT"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new StdoutLoggerConfiguration(level, format);
    }
}
