//@@woodenclock
package seedu.wildwatch.command;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Handles the "find" command to search for tasks that contain a specific keyword.
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private String input;

    public FindCommand(String input) {
        this.input = input;
    }

    /**
     * Searches for tasks that contain the specified keyword and prints them.
     */
    public void execute() throws InvalidInputException {
        boolean hasMatch = false;
        ArrayList<Entry> entries = EntryList.getArray();
        ArrayList<Integer> matchingEntries = new ArrayList<>();

        LocalDate inputDate = null;
        try {
            inputDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yy"));
        } catch (DateTimeParseException exception) {
            // matchingWord is not a date
        }

        for (Entry entry: entries) {
            boolean isInputADate = (inputDate != null && entry.getDate().equals(inputDate));

            if (entry.getSpecies().contains(input)
                    || entry.getSpecies().toLowerCase().contains(input)
                    || entry.getName().contains(input)
                    || entry.getName().toLowerCase().contains(input)
                    || entry.getRemark().contains(input)
                    || entry.getRemark().toLowerCase().contains(input)
                    || isInputADate) {
                hasMatch = true;
                matchingEntries.add(entries.indexOf(entry));
            }
        }
        Ui.findEntryMessagePrinter(hasMatch, matchingEntries);
    }
}
