package seedu.wildwatch.command;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        LocalDate inputDate = null;
        try {
            inputDate = LocalDate.parse(matchingWord, DateTimeFormatter.ofPattern("dd-MM-yy"));
        } catch (DateTimeParseException exception) {
            // matchingWord is not a date
        }

        for (Entry entry: entries) {
            boolean isInputADate = (inputDate != null && entry.getDate().equals(inputDate));
            if (inputDate != null) {
                System.out.println("Entry Date: " + entry.getDate());
                System.out.println("Input Date: " + inputDate);
            }


            if (entry.getSpecies().contains(matchingWord)
                    || entry.getSpecies().toLowerCase().contains(matchingWord)
                    || entry.getName().contains(matchingWord)
                    || entry.getName().toLowerCase().contains(matchingWord)
                    || entry.getRemark().contains(matchingWord)
                    || entry.getRemark().toLowerCase().contains(matchingWord)
                    || isInputADate) {
                hasMatch = true;
                matchingEntries.add(entries.indexOf(entry));
            }
        }
        Ui.findTaskMessagePrinter(hasMatch, matchingEntries);
    }
}
