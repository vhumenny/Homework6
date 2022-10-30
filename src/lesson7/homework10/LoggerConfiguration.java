package lesson7.homework10;

import java.text.MessageFormat;

public abstract class LoggerConfiguration {

    private LoggingLevel level;
    private MessageFormat format = new MessageFormat("[{0}] [{1}] Message: [{2}].\n");

    public LoggerConfiguration(LoggingLevel level) {
        this.level = level;
    }

    public LoggerConfiguration(LoggingLevel level, MessageFormat format) {
        this.level = level;
        this.format = format;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public MessageFormat getFormat() {
        return format;
    }

    public void setFormat(MessageFormat format) {
        this.format = format;
    }

}
