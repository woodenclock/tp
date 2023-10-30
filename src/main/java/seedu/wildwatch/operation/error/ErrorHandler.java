package seedu.wildwatch.operation.error;

import java.util.logging.Logger;

import seedu.wildwatch.command.FindCommand;
import seedu.wildwatch.command.HelpCommand;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.operation.Ui;

public class ErrorHandler {
    private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class.getName());

    public static void handleInputError(InvalidInputException e) {
        boolean validInput = false;

        switch (e.getError()) {
        case EMPTY_FIND_INPUT:
            LOGGER.warning("Received an empty find input.");
            Ui.emptyDescriptionMessagePrinter(FindCommand.COMMAND_WORD);
            break;
        case EMPTY_LIST:
            LOGGER.info("List is empty.");
            Ui.emptyListMessagePrinter();
            validInput = true;
            break;
        case ENTRY_NOT_FOUND:
            LOGGER.warning("Queried entry not found.");
            Ui.entryNotFoundMessagePrinter();
            validInput = true;
            break;
        case INVALID_DATE:
            LOGGER.warning("Date is invalid.");
            Ui.invalidDateMessagePrinter();
            break;
        case INVALID_INPUT:
            LOGGER.warning("Command is invalid.");
            Ui.invalidInputMessagePrinter();
            break;
        case CUSTOM:
            LOGGER.warning("Command is invalid.");
            Ui.customInvalidInputMessagePrinter(e.getCustomMessage());
            break;
        default:
            Ui.invalidInputMessagePrinter();
        }

        if (!validInput) {
            Ui.printHorizontalLines();
            HelpCommand.printNeedHelpMessage();
        }
    }
}
