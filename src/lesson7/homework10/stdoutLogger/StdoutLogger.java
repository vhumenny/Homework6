package lesson7.homework10.stdoutLogger;

import lesson7.homework10.Logger;
import lesson7.homework10.LoggingLevel;
import lesson7.homework10.fileLogger.FileLoggerConfiguration;

import java.util.Date;

public class StdoutLogger extends Logger {
    @Override
    public void debug(FileLoggerConfiguration configuration, String debugMessage) {
        writer(configuration, debugMessage);
    }

    @Override
    public void info(FileLoggerConfiguration configuration, String infoMessage) {
        writer(configuration, infoMessage);
    }

    @Override
    public void writer(FileLoggerConfiguration configuration, String message) {

        if (configuration.getLevel().equals(LoggingLevel.DEBUG)) {
            Object[] argsDebug = {new Date(), configuration.getLevel(), message};
            Object[] argsInfo = {new Date(), LoggingLevel.INFO, message};

            System.out.println(configuration.getFormat().format(argsDebug));
            System.out.println(configuration.getFormat().format(argsInfo));
        } else {
            Object[] argsInfo = {new Date(), configuration.getLevel(), message};

            System.out.println(configuration.getFormat().format(argsInfo));
        }
    }
}
