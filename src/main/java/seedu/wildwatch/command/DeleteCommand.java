package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.ui.LinePrinter;
import seedu.wildwatch.ui.EntryPrinter;
import seedu.wildwatch.ui.ListCommandPrinter;
import seedu.wildwatch.ui.DeleteCommandPrinter;

import java.util.Scanner;

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
        if (numberInput <= 0 || numberInput > EntryList.getArraySize()) {
            DeleteCommandPrinter.entryNotFoundMessagePrinter();
        } else {
            Scanner scanner = new Scanner(System.in);
            EntryPrinter.printEntry(numberInput-1);
            DeleteCommandPrinter.entryDeletionConfirmationPrinter();
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                DeleteCommandPrinter.entryRemovedMessagePrinter();
                EntryList.deleteEntry(numberInput);
                ListCommandPrinter.entryCountPrinter();
            } else {
                LinePrinter.printHorizontalLines();
                DeleteCommandPrinter.entryNotDeletedMessagePrinter();

            }
        }
    }
}
