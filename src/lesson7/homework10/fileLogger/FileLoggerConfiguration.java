package lesson7.homework10.fileLogger;

import lesson7.homework10.LoggerConfiguration;
import lesson7.homework10.LoggingLevel;

import java.io.File;
import java.text.MessageFormat;

public class FileLoggerConfiguration extends LoggerConfiguration {

    private File file = new File("log.txt");
    private byte maxCapacity = 100;

    private MessageFormat fileNameFormat = new MessageFormat("Log_{0}.txt");

    public FileLoggerConfiguration(LoggingLevel level) {
        super(level);
    }

    public FileLoggerConfiguration(LoggingLevel level, MessageFormat format, File file, byte maxCapacity) {
        super(level, format);
        this.file = file;
        this.maxCapacity = maxCapacity;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public byte getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(byte maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public MessageFormat getFileNameFormat() {
        return fileNameFormat;
    }

    public void setFileNameFormat(MessageFormat fileNameFormat) {
        this.fileNameFormat = fileNameFormat;
    }
}
