package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.InvalidInputException;
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
    public void execute()  {
        if (numberInput <= 0 || numberInput > EntryList.getArraySize()) {
            DeleteCommandPrinter.entryNotFoundMessagePrinter();
        } else {
            confirmDelete();
        }
    }

    public void confirmDelete() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            EntryPrinter.printEntry(numberInput-1);
            DeleteCommandPrinter.entryDeletionConfirmationPrinter(i);
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                DeleteCommandPrinter.entryRemovedMessagePrinter();
                EntryList.deleteEntry(numberInput-1);
                ListCommandPrinter.entryCountPrinter();
                return;
            }
            if (confirmation.equals("no")) {
                LinePrinter.printHorizontalLines();
                DeleteCommandPrinter.entryNotDeletedMessagePrinter();
                return;
            }
        }
        LinePrinter.printHorizontalLines();
        DeleteCommandPrinter.entryNotDeletedMessagePrinter();
    }
}
