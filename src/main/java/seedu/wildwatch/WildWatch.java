package seedu.wildwatch;

import seedu.wildwatch.operation.BootUp;
import seedu.wildwatch.operation.LogHandler;
import seedu.wildwatch.operation.Parser;
import seedu.wildwatch.operation.Ui;


public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        LogHandler.configure(); //Configure Log
        Ui.printHorizontalLines();
        System.out.print(BootUp.WELCOME_MESSAGE_1);
        Ui.printHorizontalLines();
        System.out.print(BootUp.LOGO);
        Ui.printHorizontalLines();
        System.out.print(BootUp.WELCOME_MESSAGE_2);
        Ui.printHorizontalLines();
        Parser.manualInputHandler(); //Parser takes on
    }
}
