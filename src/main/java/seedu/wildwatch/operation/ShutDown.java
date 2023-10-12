package seedu.wildwatch.operation;

public class ShutDown {
    public static void shutDown() {
        //Program Ending
        Ui.printHorizontalLines();
        System.out.println("Bye. Hope to see you again soon!");
        Ui.printHorizontalLines();
    }
}
