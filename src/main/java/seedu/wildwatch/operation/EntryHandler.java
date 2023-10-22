package seedu.wildwatch.operation;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.wildwatch.command.*;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;


public class EntryHandler {
    private static final int DEFAULT_NUMBER_INPUT = -3710; //Number that can never be input in normal use of WildWatch
    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public static void handleManualInput() {
        while (true) {
            String inputBuffer = Ui.inputRetriever(); //Retrieves input of user
            LOGGER.log(Level.INFO, "Input received: {0}", inputBuffer);

            if (inputBuffer.equals("bye")) {        //Program exit
                break;
            } else if (inputBuffer.equals("help")) {  //User request "help"
                Ui.printHorizontalLines();
                Ui.helpRequestMessagePrinter();
                Ui.printHorizontalLines();
                HelpCommand.printHelpMessage();
            } else {
                Ui.printHorizontalLines();
                ErrorHandler.handleError(inputBuffer);
                Ui.printHorizontalLines();
            }
            EntryList.saveEntry();
        }
        ByeCommand.exitProgram();
    }

    public static void handleFileInput(String lineOfFile) {
        try {
            EntryHandler.handleEntry(lineOfFile, true);
        } catch (UnknownInputException | IncorrectInputException exception) {
            Ui.corruptFileMessagePrinter();
            ShutDown.shutDown();
            System.exit(0);
        }
    }

    public static void handleEntry(String inputBuffer, boolean isFromFile)
            throws UnknownInputException, IncorrectInputException {
        LOGGER.log(Level.INFO, "Managing entry for input: {0}", inputBuffer);
        Scanner bufferScanner = new Scanner(inputBuffer);     //Scanner for the buffer
        String firstWord = bufferScanner.next();              //Stores first word in the input
        assert firstWord != null && !firstWord.isEmpty() : "First word shouldn't be null or empty";

        boolean hasInputInteger = bufferScanner.hasNextInt(); //Indicates that some integer was input
        int numberInput = DEFAULT_NUMBER_INPUT;               //Stores the number input
        if (hasInputInteger) {
            numberInput = bufferScanner.nextInt();
            assert numberInput != DEFAULT_NUMBER_INPUT : "Number input wasn't parsed correctly";
        }

        //Functionalities
        if (isFromFile && firstWord.equals("add")) {
            AddCommand.addEntry(inputBuffer, isFromFile);
        } else if (firstWord.equals("add")) {
            AddCommand.addEntry(inputBuffer, false);
        } else if (firstWord.equals("delete") && hasInputInteger && !bufferScanner.hasNext()) {
            assert numberInput > 0 : "Entry number to delete should be positive";
            DeleteCommand.deleteEntry(numberInput);
        } else if (inputBuffer.equals("list")) {
            ListCommand.listEntry(isFromFile);
        } else {
            LOGGER.log(Level.WARNING, "Unknown input received: {0}. Throwing exception.", inputBuffer);
            throw new UnknownInputException(); //Unrecognizable by Parser
        }
    }
}
