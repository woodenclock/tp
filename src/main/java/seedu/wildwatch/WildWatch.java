package seedu.wildwatch;

import seedu.wildwatch.operation.*;


public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        LogHandler.configure(); //Configure Log
        BootUp.bootUpOne();
        FileHandler.handleFile(); //FileHandler takes on
        InputHandler.handleManualInput();
    }
}
