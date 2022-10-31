package lesson7.homework10.fileLogger;

import lesson7.homework10.Logger;
import lesson7.homework10.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends Logger {

    @Override
    public void debug(FileLoggerConfiguration debugConfiguration, String message) {

        if (debugConfiguration.getFile().length() >= debugConfiguration.getMaxCapacity()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
            Object[] args = {sdf.format(new Date())};

            String fileName = debugConfiguration.getFileNameFormat().format(args);
            debugConfiguration.setFile(new File(fileName));
            writer(debugConfiguration, message);
        } else writer(debugConfiguration, message);
    }

    @Override
    public void info(FileLoggerConfiguration infoConfiguration, String message) {

        if (infoConfiguration.getFile().length() >= infoConfiguration.getMaxCapacity()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
            Object[] args = {sdf.format(new Date())};

            String fileName = infoConfiguration.getFileNameFormat().format(args);
            infoConfiguration.setFile(new File(fileName));
            writer(infoConfiguration, message);
        } else writer(infoConfiguration, message);
    }

    @Override
    public void writer(FileLoggerConfiguration fileLoggerConfiguration, String message) {

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
