package lesson7.homework10;

import java.text.MessageFormat;

public abstract class LoggerConfiguration {

    private LoggingLevel level;
    private MessageFormat format;

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
