package seedu.wildwatch.operation;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.EmptyAddException;
import seedu.wildwatch.exception.EmptyDeleteException;
import seedu.wildwatch.exception.EmptyListException;
import seedu.wildwatch.exception.EmptyInputException;
import seedu.wildwatch.exception.EntryNotFoundException;
import seedu.wildwatch.exception.UnknownInputException;
import seedu.wildwatch.exception.UnknownDateFormatException;

public class ErrorHandler {
    private static final int DEFAULT_NUMBER_INPUT = -100;
    public static void handleError(String inputBuffer) {
        boolean validInput = false;
        try {
            checkError(inputBuffer);
            Parser.entryManager(inputBuffer, false);
            validInput = true;
        } catch (EmptyInputException exception) {
            Ui.emptyDescriptionMessagePrinter(null);
        } catch (EmptyAddException exception){
            Ui.emptyDescriptionMessagePrinter("add");
        } catch (EmptyDeleteException exception) {
            Ui.emptyDescriptionMessagePrinter("delete");
        } catch (EmptyListException exception) {
            Ui.emptyListMessagePrinter();
            validInput = true;
        } catch (EntryNotFoundException exception) {
            Ui.entryNotFoundMessagePrinter();
            validInput = true;
        } catch (UnknownInputException exception) {
            Ui.unknownInputMessagePrinter();
        } catch (UnknownDateFormatException | DateTimeParseException exception) {
            Ui.invalidDateMessagePrinter();
        } finally {
            if (!validInput) {
                Ui.printHorizontalLines();
                Helper.printHelpMessage();
            }
        }
    }

    public static void checkError(String inputBuffer) throws EmptyInputException, EmptyAddException,
            EmptyListException, EmptyDeleteException, EntryNotFoundException, UnknownDateFormatException {

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

        if (firstWord.equals("add") && !bufferScanner.hasNext()) {
            throw new EmptyAddException();
        } else if (firstWord.equals("add") && !(DateHandler.isDateValid(inputBuffer))) {
            throw new UnknownDateFormatException();
        } else if (firstWord.equals("delete") && numberInput == DEFAULT_NUMBER_INPUT) {
            throw new EmptyDeleteException();
        } else if (firstWord.equals("delete") && (numberInput < 1 || numberInput > EntryList.getArraySize())) {
            throw new EntryNotFoundException();
        } else if (firstWord.equals("list") && EntryList.isArrayEmpty()) {
            throw new EmptyListException();
        }
    }
}
