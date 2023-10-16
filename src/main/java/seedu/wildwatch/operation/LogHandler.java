package seedu.wildwatch.operation;

import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LogHandler {
    static {
        try {
            // Configure a FileHandler
            FileHandler file = new FileHandler("WildWatch.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            file.setFormatter(formatter);

            // Obtain the root logger. An empty string gets the root logger
            Logger rootLogger = Logger.getLogger("");

            // Remove the default handlers (like ConsoleHandler)
            for (Handler handler : rootLogger.getHandlers()) {
                rootLogger.removeHandler(handler);
            }

            // Add the FileHandler to the root logger
            rootLogger.addHandler(file);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void configure() { // Call this empty method to ensure the static block runs
    }
}
