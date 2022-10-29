package lesson7.homework10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {
    public static void main(String[] args) throws FileMaxSizeReachedException, IOException {
        String debugMessage = "debug method is running";
        String infoMessage = "info method is running";

        debug(debugMessage);
        info(infoMessage);
        System.out.println(FileLoggerConfigurationLoader.load());

    }

    public static void debug(String message) throws FileMaxSizeReachedException {
        FileLoggerConfiguration debugConfiguration = new FileLoggerConfiguration(LoggingLevel.DEBUG);

        if (debugConfiguration.getFile().length() >= debugConfiguration.getMaxCapacity()) {
            File file =  new File("Log_"+new Date()+".txt");
            writerInFile(debugConfiguration, message,file);

        } else writerInFile(debugConfiguration, message,debugConfiguration.getFile());
    }

    public static void info(String message) throws FileMaxSizeReachedException {
        FileLoggerConfiguration infoConfiguration = new FileLoggerConfiguration(LoggingLevel.INFO);

        if (infoConfiguration.getFile().length() >= infoConfiguration.getMaxCapacity()) {
            File file =  new File("Log_"+new Date()+".txt");
            writerInFile(infoConfiguration, message,file);
        }
        writerInFile(infoConfiguration, message, infoConfiguration.getFile());
    }

    public static void writerInFile(FileLoggerConfiguration fileLoggerConfiguration, String message, File file) {

        if (fileLoggerConfiguration.getLevel().equals(LoggingLevel.DEBUG)) {
            Object[] argsDebug = {new Date(), fileLoggerConfiguration.getLevel(), message};
            Object[] argsInfo = {new Date(), LoggingLevel.INFO, message};

            String stringToWriteDebug = fileLoggerConfiguration.getFormat().format(argsDebug);
            String stringToWriteInfo = fileLoggerConfiguration.getFormat().format(argsInfo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,
                    true))) {
                writer.write(stringToWriteDebug);
                writer.write(stringToWriteInfo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Object[] argsInfo = {new Date(), fileLoggerConfiguration.getLevel(), message};
            String stringToWriteInfo = fileLoggerConfiguration.getFormat().format(argsInfo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,
                    true))) {
                writer.write(stringToWriteInfo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
