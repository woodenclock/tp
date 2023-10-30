//@@woodenclock
package seedu.wildwatch.operation;

public class ShutDown {
    public static void shutDown() {
        //Program Ending
        Ui.printHorizontalLines();
        System.out.println("Bye. Hope to see you again soon!");
        Ui.printHorizontalLines();
    }

    public static void shutDownWithError() {
        //Program Ending
        Ui.printHorizontalLines();
        System.out.println("Ending program due to error...");
        Ui.printHorizontalLines();
    }
}
