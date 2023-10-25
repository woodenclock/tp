package seedu.wildwatch.command;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Handles the "find" command to search for tasks that contain a specific keyword.
 */
public class FindCommand {
    /**
     * Searches for tasks that contain the specified keyword and prints them.
     *
     * @param inputBuffer The full find command entered by the user.
     */
    public static void findEntry(String inputBuffer) {
        boolean hasMatch = false;
        String matchingWord = inputBuffer.substring(inputBuffer.indexOf("find") + 5).trim();
        ArrayList<Entry> entries = EntryList.getArray();
        ArrayList<Integer> matchingEntries = new ArrayList<>();

        LocalDate matchingDate = null;
        try {
            matchingDate = LocalDate.parse(matchingWord);
        } catch (DateTimeParseException exception) {
            // matchingWord is not a date
        }

        for (Entry entry: entries) {
            boolean matchesDate = (entry.getDate().equals(matchingDate));

            if (entry.getSpecies().toLowerCase().contains(matchingWord)
                    || entry.getName().toLowerCase().contains(matchingWord)
                    || entry.getRemark().toLowerCase().contains(matchingWord)
                    || matchesDate) {
                hasMatch = true;
                matchingEntries.add(entries.indexOf(entry));
            }
        }
        Ui.findTaskMessagePrinter(hasMatch, matchingEntries);
    }
}
