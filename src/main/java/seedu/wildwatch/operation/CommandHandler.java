package seedu.wildwatch.operation;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.operation.error.ErrorChecker;
import seedu.wildwatch.operation.error.ErrorHandler;
import seedu.wildwatch.exception.InvalidInputException;

public class CommandHandler {
    public static boolean processCommand(String inputBuffer) {
        try {
            Command command = ErrorChecker.checkError(inputBuffer); //Checks if the input command is valid
            if (command instanceof ByeCommand) {
                return false;
            }
            executeCommand(command);
        } catch (InvalidInputException exception) {
            ErrorHandler.handleInputError(exception);
        }
        return true;
    }

    public static void executeCommand(Command command) throws InvalidInputException {
        Ui.printHorizontalLines();
        command.execute();
        Ui.printHorizontalLines();
    }
}
