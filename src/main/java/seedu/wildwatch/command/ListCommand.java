package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for listing all task in EntryList
 */
public class ListCommand extends Command {
    /**
     * Lists out all task in EntryList
     *
     * @param isFromFile
     */
    public static void listOut(boolean isFromFile) {
        if (!isFromFile) {
            Ui.listMessagePrinter();
        }
        int arraySize = EntryList.getArraySize();
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + 1 + ".");
            Ui.print(i);
        }
        Ui.entryCountPrinter();
    }
}

