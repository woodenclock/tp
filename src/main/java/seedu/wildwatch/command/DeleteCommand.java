package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for deleting entry in EntryList
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    private final int numberInput;

    public DeleteCommand(int numberInput) {
        this.numberInput = numberInput;
    }

    /**
     * Deletes entry in the EntryList
     */
    public void execute() {
        if (numberInput < 0 || numberInput > EntryList.getArraySize()) {
            Ui.entryNotFoundMessagePrinter();
        } else {
            Ui.entryRemovedMessagePrinter();
            EntryList.deleteEntry(numberInput);
            Ui.entryCountPrinter();
        }
    }
}
