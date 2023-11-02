package seedu.wildwatch.execute;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.error.ErrorChecker;
import seedu.wildwatch.error.ErrorHandler;
import seedu.wildwatch.exception.InvalidInputException;

public class CommandHandler {
    public static boolean processCommand(String input) {
        try {
            Command command = ErrorChecker.checkError(input); //Checks if the input command is valid
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
        command.execute();
    }
}
