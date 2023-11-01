//@@woodenclock
package seedu.wildwatch.error;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.command.EditCommand;
import seedu.wildwatch.command.SummaryCommand;
import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.command.DeleteCommand;
import seedu.wildwatch.command.FindCommand;
import seedu.wildwatch.command.HelpCommand;

import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.parser.AddCommandParser;
import seedu.wildwatch.parser.DeleteCommandParser;
import seedu.wildwatch.parser.FindCommandParser;

/**
 * Identifies the input command and sends it to the corresponding parser.
 */
public class ErrorChecker {
    private static final Logger LOGGER = Logger.getLogger(ErrorChecker.class.getName());

    public static Command checkError(String inputBuffer) throws InvalidInputException {

        LOGGER.log(Level.INFO, "Managing entry for input: {0}", inputBuffer);
        Scanner bufferScanner = new Scanner(inputBuffer);     //Scanner for the buffer
        if (!bufferScanner.hasNext()) {
            throw new InvalidInputException(InvalidInputErrorType.EMPTY_INPUT);
        }
        String firstWord = bufferScanner.next();              //Stores first word in the input

        //Functionalities
        switch (firstWord) {
        case AddCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Add command was input: {0}", inputBuffer);
            return new AddCommandParser().parse(inputBuffer);
        case DeleteCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Delete command was input: {0}", inputBuffer);
            return new DeleteCommandParser().parse(inputBuffer);
        case EditCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Edit command was input: {0}", inputBuffer);
            return new EditCommand(inputBuffer);
        case FindCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Find command was input: {0}", inputBuffer);
            return new FindCommandParser().parse(inputBuffer);
        case ListCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "List command was input: {0}", inputBuffer);
            return new ListCommand();
        case SummaryCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Summary command was input: {0}", inputBuffer);
            return new SummaryCommand(inputBuffer);
        case HelpCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Help command was input: {0}", inputBuffer);
            return new HelpCommand(inputBuffer);
        case ByeCommand.COMMAND_WORD:
            LOGGER.log(Level.INFO, "Exit command was input: {0}", inputBuffer);
            return new ByeCommand();
        default:
            LOGGER.log(Level.WARNING, "Unknown input received: {0}. Throwing exception.", inputBuffer);
            throw new InvalidInputException(InvalidInputErrorType.UNKNOWN_INPUT);
        }
    }
}
