package seedu.wildwatch.ui;

public class DeleteCommandPrinter {
    public static void entryRemovedMessagePrinter() {
        LinePrinter.printHorizontalLines();
        System.out.println("The entry has been deleted.");
    }

    public static void entryDeletionConfirmationPrinter() {
        System.out.println("Are you sure you want to delete this entry? (yes/no): ");
        LinePrinter.printHorizontalLines();
    }

    public static void entryNotDeletedMessagePrinter() {
        System.out.println("The entry was not deleted.");
    }

    /**
     * Prints out appropriate message when nth entry input by the user is not found.
     */
    public static void entryNotFoundMessagePrinter() {
        LinePrinter.printHorizontalLines();
        System.out.println("OOPS!!! The entry number could not be found :-(");
    }
}
