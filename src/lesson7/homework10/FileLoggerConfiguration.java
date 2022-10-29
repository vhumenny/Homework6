package lesson7.homework10;

import java.io.File;
import java.text.MessageFormat;

public class FileLoggerConfiguration {

    private File file = new File("log.txt");
    private LoggingLevel level;
    private byte maxCapacity = 100;
    MessageFormat format = new MessageFormat("[{0}] [{1}] Message: [{2}].\n");

    public FileLoggerConfiguration(LoggingLevel level) {
        this.level = level;
    }

    public FileLoggerConfiguration(File file, LoggingLevel level, byte maxCapacity, MessageFormat format) {
        this.file = file;
        this.level = level;
        this.maxCapacity = maxCapacity;
        this.format = format;
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

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "file=" + file +
                ", level=" + level +
                ", maxCapacity=" + maxCapacity +
                ", format=" + format +
                '}';
    }
}
