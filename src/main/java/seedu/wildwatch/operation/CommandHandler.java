package seedu.wildwatch.operation;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.operation.error.ErrorHandler;
import seedu.wildwatch.exception.InvalidInputException;

public class CommandHandler {
    public static boolean processCommand(String inputBuffer) {
        try {
            Command command = EntryHandler.handleEntry(inputBuffer);
            if (command instanceof ByeCommand) {
                return true;
            }

            executeCommand(command);

        } catch (InvalidInputException exception) {
            ErrorHandler.handleInputError(exception);
        }

        return false;
    }

    public static void executeCommand(Command command) throws InvalidInputException {
        Ui.printHorizontalLines();
        command.execute();
        Ui.printHorizontalLines();
    }
}
