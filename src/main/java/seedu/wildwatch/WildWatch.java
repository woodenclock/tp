package seedu.wildwatch;

import seedu.wildwatch.operatingsystem.BootUp;
import seedu.wildwatch.operation.Parser;


public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        System.out.println(BootUp.WELCOME_MESSAGE);
        System.out.println("What would you like to do?");
        Parser.entryHandler();
    }
}
