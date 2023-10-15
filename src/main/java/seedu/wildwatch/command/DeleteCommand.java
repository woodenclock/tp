package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for deleting task in EntryList
 */
public class DeleteCommand extends Command {
    /**
     * Deletes task in the EntryList
     *
     * @param numberInput
     */
    public static void deleteEntry(int numberInput) {
        Ui.entryRemovedMessagePrinter();
        EntryList.entryRemover(numberInput);
        Ui.entryCountPrinter();
    }
}
