package seedu.wildwatch;

import seedu.wildwatch.operation.BootUp;
import seedu.wildwatch.operation.Parser;


public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        System.out.println(BootUp.WELCOME_MESSAGE + BootUp.LOGO);
        System.out.println("What would you like to do?");
        Parser.manualEntryHandler();
    }
}
