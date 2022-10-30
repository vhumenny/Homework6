package lesson7.homework10;

import java.text.MessageFormat;

public abstract class LoggerConfigurationLoader {
    private MessageFormat format;


    public abstract LoggerConfiguration load();

}
