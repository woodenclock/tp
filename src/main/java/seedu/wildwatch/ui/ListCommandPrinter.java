package seedu.wildwatch.ui;

import seedu.wildwatch.entry.EntryList;

public class ListCommandPrinter {
    /**
     * Prints out appropriate message when there is no entries to list.
     */
    public static void emptyListMessagePrinter() {
        System.out.println("OOPS!!! Nothing to list. :-(");
    }

    public static void listMessagePrinter() {
        System.out.println("Here are the entries in your list: ");
    }

    public static void entryCountPrinter() {
        System.out.println("Now you have " + (EntryList.getArraySize()) + " entries in the list.");
    }
}
