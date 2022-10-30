package lesson7.homework10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {
    public static void main(String[] args) throws FileMaxSizeReachedException {
        String debugMessage = "debug method is running";
        String infoMessage = "info method is running";

        debug(debugMessage);
        info(infoMessage);
    }

    public static void debug(String message) throws FileMaxSizeReachedException {
        FileLoggerConfiguration debugConfiguration = new FileLoggerConfiguration(LoggingLevel.DEBUG);

        if (debugConfiguration.getFile().length() >= debugConfiguration.getMaxCapacity()) {
            throw new FileMaxSizeReachedException("Max file size is = " + debugConfiguration.getMaxCapacity() +
                    " You have reached the file size =" + debugConfiguration.getFile().length() + " Path to file = "
                    + debugConfiguration.getFile().getAbsolutePath());
        }
        writerInFile(debugConfiguration, message);
    }

    public static void info(String message) throws FileMaxSizeReachedException {
        FileLoggerConfiguration infoConfiguration = new FileLoggerConfiguration(LoggingLevel.INFO);

        if (infoConfiguration.getFile().length() >= infoConfiguration.getMaxCapacity()) {
            throw new FileMaxSizeReachedException("Max file size is = " + infoConfiguration.getMaxCapacity() +
                    " You have reached the file size =" + infoConfiguration.getFile().length() + " Path to file = "
                    + infoConfiguration.getFile().getAbsolutePath());
        }
        writerInFile(infoConfiguration, message);
    }

    public static void writerInFile(FileLoggerConfiguration fileLoggerConfiguration, String message) {

        if (fileLoggerConfiguration.getLevel().equals(LoggingLevel.DEBUG)) {
            Object[] argsDebug = {new Date(), fileLoggerConfiguration.getLevel(), message};
            Object[] argsInfo = {new Date(), LoggingLevel.INFO, message};

            String stringToWriteDebug = fileLoggerConfiguration.getFormat().format(argsDebug);
            String stringToWriteInfo = fileLoggerConfiguration.getFormat().format(argsInfo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLoggerConfiguration.getFile(),
                    true))) {
                writer.write(stringToWriteDebug);
                writer.write(stringToWriteInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Object[] argsInfo = {new Date(), fileLoggerConfiguration.getLevel(), message};
            String stringToWriteInfo = fileLoggerConfiguration.getFormat().format(argsInfo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLoggerConfiguration.getFile(),
                    true))) {
                writer.write(stringToWriteInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
