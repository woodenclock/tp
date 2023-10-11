package seedu.wildwatch;

import seedu.wildwatch.operation.BootUp;
import seedu.wildwatch.operation.Parser;


public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        System.out.println(BootUp.WELCOME_MESSAGE_1 + BootUp.LOGO + BootUp.WELCOME_MESSAGE_2);
        Parser.manualInputHandler();
    }
}
