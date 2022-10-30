package lesson7.homework10;

import lesson7.homework10.fileLogger.FileLogger;

public class Main {
    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger();

        fileLogger.debug(fileLogger.getDebugMessage());
        fileLogger.info(fileLogger.getInfoMessage());
    }
}
