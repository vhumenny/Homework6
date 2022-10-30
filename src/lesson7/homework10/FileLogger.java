package lesson7.homework10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends Logger {

    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger();

        fileLogger.debug(fileLogger.getDebugMessage());
        fileLogger.info(fileLogger.getInfoMessage());
    }

    @Override
    public void debug(String message) {
        FileLoggerConfiguration debugConfiguration = new FileLoggerConfiguration(LoggingLevel.DEBUG);

        if (debugConfiguration.getFile().length() >= debugConfiguration.getMaxCapacity()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
            Object[] args = {sdf.format(new Date())};

            String fileName = debugConfiguration.getFileNameFormat().format(args);
            File newFile = new File(fileName);
            writer(debugConfiguration, message, newFile);

        } else writer(debugConfiguration, message, debugConfiguration.getFile());
    }

    @Override
    public void info(String message) {
        FileLoggerConfiguration infoConfiguration = new FileLoggerConfiguration(LoggingLevel.INFO);

        if (infoConfiguration.getFile().length() >= infoConfiguration.getMaxCapacity()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
            Object[] args = {sdf.format(new Date())};

            String fileName = infoConfiguration.getFileNameFormat().format(args);
            File newFile = new File(fileName);
            writer(infoConfiguration, message, newFile);
        } else writer(infoConfiguration, message, infoConfiguration.getFile());
    }

    @Override
    public void writer(FileLoggerConfiguration fileLoggerConfiguration, String message, File file) {

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
                e.printStackTrace();
            }
        } else {
            Object[] argsInfo = {new Date(), fileLoggerConfiguration.getLevel(), message};

            String stringToWriteInfo = fileLoggerConfiguration.getFormat().format(argsInfo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,
                    true))) {
                writer.write(stringToWriteInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
