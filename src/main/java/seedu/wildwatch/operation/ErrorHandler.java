package seedu.wildwatch.operation;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.EmptyAddException;
import seedu.wildwatch.exception.EmptyDeleteException;
import seedu.wildwatch.exception.EmptyListException;
import seedu.wildwatch.exception.EmptyInputException;
import seedu.wildwatch.exception.UnknownInputException;
import seedu.wildwatch.exception.UnknownDateFormatException;

public class ErrorHandler {
    public static void handleError(String inputBuffer) {
        boolean validInput = false;
        try {
            checkError(inputBuffer);
            Parser.taskManager(inputBuffer, false);
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

    public static void checkError(String inputBuffer) throws EmptyInputException, EmptyAddException,
            EmptyListException, EmptyDeleteException, UnknownDateFormatException {

        Scanner bufferScanner = new Scanner(inputBuffer);   //Scanner for the buffer
        String firstWord;                                   //First word of input
        if (!bufferScanner.hasNext()) {                     //Checks for the case when there is no input
            throw new EmptyInputException();
        } else {
            firstWord = bufferScanner.next();
        }

        if (firstWord.equals("add") && !bufferScanner.hasNext()) {
            throw new EmptyAddException();
        } else if (firstWord.equals("add") && !(DateHandler.isDateValid(inputBuffer))) {
            throw new UnknownDateFormatException();
        } else if (firstWord.equals("delete") && !bufferScanner.hasNext()) {
            throw new EmptyDeleteException();
        } else if (firstWord.equals("list") && EntryList.isArrayEmpty()) {
            throw new EmptyListException();
        }
    }
}