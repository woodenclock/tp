package seedu.wildwatch.ui;

import java.util.ArrayList;

public class SearchResultPrinter {
    /**
     * Prints out the entries that match the search key word.
     * If no match, prints out appropriate message that there was no match found.
     *
     * @param hasMatch
     * @param matchingTasks
     */
    public static void findEntryMessagePrinter(boolean hasMatch, ArrayList<Integer> matchingTasks) {
        if (!hasMatch) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.print((i) + ".");
                EntryPrinter.printEntry(matchingTasks.get(i));
            }
        }
    }
}
