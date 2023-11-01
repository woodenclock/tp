//@@woodenclock
package seedu.wildwatch.operation;

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
import seedu.wildwatch.operation.error.InvalidInputErrorType;
import seedu.wildwatch.parser.AddCommandParser;
import seedu.wildwatch.parser.DeleteCommandParser;


public class EntryHandler {
    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public static Command handleEntry(String inputBuffer) throws InvalidInputException {

        LOGGER.log(Level.INFO, "Managing entry for input: {0}", inputBuffer);
        Scanner bufferScanner = new Scanner(inputBuffer);     //Scanner for the buffer
        String firstWord = bufferScanner.next();              //Stores first word in the input

        if (firstWord == null || firstWord.isEmpty()) {
            throw new InvalidInputException(InvalidInputErrorType.EMPTY_INPUT);
        }

        //Functionalities
        switch (firstWord) {
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(inputBuffer);
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(inputBuffer);
        case EditCommand.COMMAND_WORD:
            return new EditCommand(inputBuffer);
        case FindCommand.COMMAND_WORD:
            return new FindCommand(inputBuffer);
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        case SummaryCommand.COMMAND_WORD:
            return new SummaryCommand(inputBuffer);
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand(inputBuffer);
        case ByeCommand.COMMAND_WORD:
            return new ByeCommand();
        default:
            LOGGER.log(Level.WARNING, "Unknown input received: {0}. Throwing exception.", inputBuffer);
            throw new InvalidInputException(InvalidInputErrorType.UNKNOWN_INPUT);
        }
    }
}
