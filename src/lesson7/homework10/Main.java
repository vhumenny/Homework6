package lesson7.homework10;

import lesson7.homework10.fileLogger.FileLogger;
import lesson7.homework10.fileLogger.FileLoggerConfiguration;
import lesson7.homework10.fileLogger.FileLoggerConfigurationLoader;
import lesson7.homework10.stdoutLogger.StdoutLogger;

public class Main {
    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger();
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        StdoutLogger stdoutLogger = new StdoutLogger();

        FileLoggerConfiguration configuration = loader.load();

        stdoutLogger.debug(configuration, stdoutLogger.getDebugMessage());
        stdoutLogger.info(configuration, stdoutLogger.getInfoMessage());

        fileLogger.debug(configuration, fileLogger.getDebugMessage());
        fileLogger.info(configuration, fileLogger.getInfoMessage());
    }
}
