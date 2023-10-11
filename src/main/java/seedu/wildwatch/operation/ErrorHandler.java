package seedu.wildwatch.operation;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.EmptyDeleteException;
import seedu.wildwatch.exception.EmptyListException;
import seedu.wildwatch.exception.EmptyInputException;
import seedu.wildwatch.exception.UnknownInputException;
import seedu.wildwatch.exception.UnknownDateFormatException;

public class ErrorHandler {
    public static void handleError(String inputBuffer) {
        boolean validInput = false;
        try {
            errorChecker(inputBuffer);
            Parser.taskManager(inputBuffer, false);
            validInput = true;
        } catch (EmptyListException exception) {
            Ui.emptyListMessagePrinter();
            validInput = true;
        } catch (EmptyInputException exception) {
                Ui.emptyDescriptionMessagePrinter(null);
        } catch (EmptyDeleteException exception) {
            Ui.emptyDescriptionMessagePrinter("delete");
        } catch (UnknownInputException exception) {
            Ui.unknownInputMessagePrinter();
        } catch (UnknownDateFormatException | DateTimeParseException exception) {
            Ui.invalidDateTimeMessagePrinter();
        } finally {
            if (!validInput) {
                Ui.printHorizontalLines();
                Helper.printHelpMessage();
            }
        }
    }

    public static void errorChecker(String inputBuffer) throws EmptyInputException, EmptyListException,
            EmptyDeleteException, UnknownDateFormatException {

        Scanner bufferScanner = new Scanner(inputBuffer);   //Scanner for the buffer
        String firstWord;                                   //First word of input
        if (!bufferScanner.hasNext()) {                     //Checks for the case when there is no input
            throw new EmptyInputException();
        } else {
            firstWord = bufferScanner.next();
        }

        if (firstWord.equals("list") && EntryList.isArrayEmpty()) {
            throw new EmptyListException();
        }  else if (firstWord.equals("delete") && !bufferScanner.hasNext()) {
            throw new EmptyDeleteException();
        }
    }
}
