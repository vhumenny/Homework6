package lesson7.homework10;

import lesson7.homework10.fileLogger.FileLoggerConfiguration;

import java.io.File;

public abstract class Logger {

    private String debugMessage = "debug method is running";
    private String infoMessage = "info method is running";

    public abstract void debug(String debugMessage);

    public abstract void info(String infoMessage);

    public abstract void writer(FileLoggerConfiguration fileLoggerConfiguration, String message, File file);

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
}
