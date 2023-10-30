package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.Ui;
import seedu.wildwatch.operation.error.IncorrectInputErrorType;

/**
 * Command class for listing all entries in EntryList
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    /**
     * Lists out all entry in EntryList
     */
    public static void listEntry() {
        int arraySize = EntryList.getArraySize();
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + 1 + ".");
            Ui.printEntry(i);
        }
        Ui.entryCountPrinter();
    }

    public void execute() throws IncorrectInputException {
        if (EntryList.isArrayEmpty()) {
            throw new IncorrectInputException(IncorrectInputErrorType.EMPTY_LIST);
        }

        Ui.listMessagePrinter();
        listEntry();
    }
}

