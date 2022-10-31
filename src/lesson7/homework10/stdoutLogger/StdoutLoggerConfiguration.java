package lesson7.homework10.stdoutLogger;

import lesson7.homework10.LoggerConfiguration;
import lesson7.homework10.LoggingLevel;

import java.text.MessageFormat;

public class StdoutLoggerConfiguration extends LoggerConfiguration {

    public StdoutLoggerConfiguration(LoggingLevel level, MessageFormat format) {
        super(level, format);
    }
}
