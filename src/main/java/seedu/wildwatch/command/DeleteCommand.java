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
        int taskToBeDeleted = numberInput - 1;
        int arraySize = EntryList.getArraySize();
//        if (taskToBeDeleted >= arraySize || taskToBeDeleted < 1 || EntryList.isArrayEmpty()) {
//            Ui.entryNotFoundMessagePrinter();
//            return;
//        }
        Ui.entryRemovedMessagePrinter();
        EntryList.entryRemover(numberInput);
        Ui.entryCountPrinter();
    }
}
