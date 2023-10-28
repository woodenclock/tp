package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for deleting entry in EntryList
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    /**
     * Deletes entry in the EntryList
     *
     * @param numberInput
     */
    public static void deleteEntry(int numberInput) {
        Ui.entryRemovedMessagePrinter();
        EntryList.deleteEntry(numberInput);
        Ui.entryCountPrinter();
    }
}
