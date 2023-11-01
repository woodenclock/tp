//@@woodenclock
package seedu.wildwatch.miscellaneous;

import seedu.wildwatch.ui.LinePrinter;

public class ShutDown {
    public static void shutDown() {
        //Program Ending
        LinePrinter.printHorizontalLines();
        System.out.println("Bye. Hope to see you again soon!");
        LinePrinter.printHorizontalLines();
    }

    public static void shutDownWithError() {
        //Program Ending
        LinePrinter.printHorizontalLines();
        System.out.println("Ending program due to error...");
        LinePrinter.printHorizontalLines();
    }
}
