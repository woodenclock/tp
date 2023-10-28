package seedu.wildwatch.operation;

import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;

import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.command.DeleteCommand;
import seedu.wildwatch.command.FindCommand;
import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.command.HelpCommand;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.EmptyAddException;
import seedu.wildwatch.exception.EmptyDeleteException;
import seedu.wildwatch.exception.EmptyListException;
import seedu.wildwatch.exception.EmptyInputException;
import seedu.wildwatch.exception.EmptyFindException;
import seedu.wildwatch.exception.EntryNotFoundException;
import seedu.wildwatch.exception.UnknownInputException;
import seedu.wildwatch.exception.UnknownDateFormatException;
import seedu.wildwatch.exception.IncorrectInputException;

public class ErrorHandler {
    private static final int DEFAULT_NUMBER_INPUT = -3710; //Number never input during normal use of WildWatch
    private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class.getName());
    
    public static void handleError(String inputBuffer) {
        boolean validInput = false;
        try {
            checkError(inputBuffer);
            EntryHandler.handleEntry(inputBuffer, false);
            validInput = true;
        } catch (EmptyInputException exception) {
            LOGGER.warning("Received an empty input.");
            Ui.emptyDescriptionMessagePrinter(null);
        } catch (EmptyAddException exception){
            LOGGER.warning("Received an empty add input.");
            Ui.emptyDescriptionMessagePrinter(AddCommand.COMMAND_WORD);
        } catch (EmptyDeleteException exception) {
            LOGGER.warning("Received an empty delete input.");
            Ui.emptyDescriptionMessagePrinter(DeleteCommand.COMMAND_WORD);
        } catch (EmptyFindException exception) {
            LOGGER.warning("Received an empty find input.");
            Ui.emptyDescriptionMessagePrinter(FindCommand.COMMAND_WORD);
        } catch (EmptyListException exception) {
            LOGGER.info("List is empty.");
            Ui.emptyListMessagePrinter();
            validInput = true;
        } catch (EntryNotFoundException exception) {
            LOGGER.warning("Queried entry not found.");
            Ui.entryNotFoundMessagePrinter();
            validInput = true;
        } catch (UnknownInputException exception) {
            LOGGER.warning("Unknown input received.");
            Ui.unknownInputMessagePrinter();
        } catch (UnknownDateFormatException | DateTimeParseException exception) {
            LOGGER.warning("Date is invalid.");
            Ui.invalidDateMessagePrinter();
        } catch (IncorrectInputException exception) {
            LOGGER.warning("Command is invalid.");
            Ui.incorrectInputMessagePrinter();
        } finally {
            if (!validInput) {
                Ui.printHorizontalLines();
                HelpCommand.printNeedHelpMessage();
            }
        }
    }

    public static void checkError(String inputBuffer) throws EmptyInputException, EmptyAddException,
            EmptyListException, EmptyDeleteException, EntryNotFoundException, UnknownDateFormatException,
            EmptyFindException {
        assert inputBuffer != null : "Input buffer should not be null.";
        Scanner bufferScanner = new Scanner(inputBuffer);   //Scanner for the buffer
        String firstWord;                                   //First word of input
        int numberInput = DEFAULT_NUMBER_INPUT;
        if (!bufferScanner.hasNext()) {                     //Checks for the case when there is no input
            throw new EmptyInputException();
        } else {
            firstWord = bufferScanner.next();
        }
        if (bufferScanner.hasNextInt()) {
            numberInput = bufferScanner.nextInt();
        }

        if (firstWord.equals(AddCommand.COMMAND_WORD) && !bufferScanner.hasNext()) {
            throw new EmptyAddException();
        } else if (firstWord.equals(AddCommand.COMMAND_WORD) && !(DateHandler.isDateValid(inputBuffer))) {
            throw new UnknownDateFormatException();
        } else if (firstWord.equals(DeleteCommand.COMMAND_WORD) && numberInput == DEFAULT_NUMBER_INPUT) {
            throw new EmptyDeleteException();
        } else if (firstWord.equals(DeleteCommand.COMMAND_WORD) &&
                (numberInput < 1 || numberInput > EntryList.getArraySize())) {
            throw new EntryNotFoundException();
        } else if (firstWord.equals(FindCommand.COMMAND_WORD) &&
                !bufferScanner.hasNext() && !bufferScanner.hasNextInt()) {
            throw new EmptyFindException();
        } else if (firstWord.equals(ListCommand.COMMAND_WORD) && EntryList.isArrayEmpty()) {
            throw new EmptyListException();
        }
    }
}
