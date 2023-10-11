package seedu.wildwatch.operation;

public class ShutDown {
    public static void shutDown() {
        //ChatBot Ending
        Ui.printHorizontalLines();
        System.out.println("Bye. Hope to see you again soon!");
        Ui.printHorizontalLines();
    }
}
