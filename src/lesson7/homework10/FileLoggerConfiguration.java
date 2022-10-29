package lesson7.homework10;

import java.io.File;
import java.text.MessageFormat;

public class FileLoggerConfiguration {

    private File file = new File("log.txt");
    private LoggingLevel level;
    private final byte maxCapacity = 100;
    MessageFormat format = new MessageFormat("[{0}] [{1}] Message: [{2}].\n");

    public FileLoggerConfiguration(LoggingLevel level) {
        this.level = level;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public byte getMaxCapacity() {
        return maxCapacity;
    }

    public MessageFormat getFormat() {
        return format;
    }

    public void setFormat(MessageFormat format) {
        this.format = format;
    }
}
