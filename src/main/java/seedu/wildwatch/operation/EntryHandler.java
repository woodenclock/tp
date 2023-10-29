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

import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;


public class EntryHandler {
    private static final int DEFAULT_NUMBER_INPUT = -3710; //Number that can never be input in normal use of WildWatch
    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public static Command handleEntry(String inputBuffer)
            throws UnknownInputException, IncorrectInputException {
        LOGGER.log(Level.INFO, "Managing entry for input: {0}", inputBuffer);
        Scanner bufferScanner = new Scanner(inputBuffer);     //Scanner for the buffer
        String firstWord = bufferScanner.next();              //Stores first word in the input

        assert firstWord != null && !firstWord.isEmpty() : "First word shouldn't be null or empty";

        //TODO: weird place to put this
        boolean hasInputInteger = bufferScanner.hasNextInt(); //Indicates that some integer was input
        int numberInput = DEFAULT_NUMBER_INPUT;               //Stores the number input
        if (hasInputInteger) {
            numberInput = bufferScanner.nextInt();
            assert numberInput != DEFAULT_NUMBER_INPUT : "Number input wasn't parsed correctly";
        }

        //Functionalities
        if (firstWord.equals(AddCommand.COMMAND_WORD)) {
            return new AddCommand(inputBuffer);
        } else if (firstWord.equals(DeleteCommand.COMMAND_WORD) && hasInputInteger && !bufferScanner.hasNext()) {
            assert numberInput > 0 : "Entry number to delete should be positive";
            return new DeleteCommand(numberInput);
        } else if (firstWord.equals(FindCommand.COMMAND_WORD)) {
            return new FindCommand(inputBuffer);
        } else if (inputBuffer.equals(ListCommand.COMMAND_WORD)) {
            return new ListCommand();
        } else if (firstWord.equals(SummaryCommand.COMMAND_WORD)) {
            return new SummaryCommand(inputBuffer);
        } else if (firstWord.equals(HelpCommand.COMMAND_WORD)) {
            return new HelpCommand();
        } else if (firstWord.equals(ByeCommand.COMMAND_WORD)) {
            return new ByeCommand();
        } else if (firstWord.equals(EditCommand.COMMAND_WORD)) {
            return new EditCommand(inputBuffer);
        } else {
            LOGGER.log(Level.WARNING, "Unknown input received: {0}. Throwing exception.", inputBuffer);
            throw new UnknownInputException(); //Unrecognizable by Parser
        }
    }
}
