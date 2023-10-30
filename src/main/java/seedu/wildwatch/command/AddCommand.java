package seedu.wildwatch.command;

import java.util.regex.Pattern;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for adding entry to EntryList
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final Pattern ADD_ENTRY_COMMAND_FORMAT =
            Pattern.compile("add"
                    + "\\s* D/\\s*(?<date>[^/]+)"
                    + "\\s* S/\\s*(?<species>[^/]+)"
                    + "\\s* N/\\s*(?<name>[^/]+)"
                    + "\\s*(?: R/\\s*(?<remark>[^/]+)\\s*)?");

    private final Entry newEntry;

    public AddCommand(Entry entry) {
        newEntry = entry;
    }

    @Override
    public void execute() {
        EntryList.addEntry(newEntry);

        Ui.entryAddedMessagePrinter();
        Ui.printEntry(EntryList.getArraySize() - 1);
        Ui.entryCountPrinter();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        AddCommand otherAddCommand = (AddCommand) other;
        return newEntry.equals(otherAddCommand.newEntry);
    }
}

