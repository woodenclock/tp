package seedu.wildwatch.operation;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import seedu.wildwatch.command.HelpCommand;
import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.command.DeleteCommand;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;


public class Parser {
    private static final int DEFAULT_NUMBER_INPUT = -3710; //Number that can never be input in normal use of WildWatch
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());

    public static void manualInputHandler() {
        while (true) {
            String inputBuffer = Ui.inputRetriever(); //Retrieves input of user
            LOGGER.log(Level.INFO, "Input received: {0}", inputBuffer);

            if (inputBuffer.equals("bye")) {        //Program exit
                LOGGER.log(Level.INFO, "Exiting program on user command.");
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
        }
        LOGGER.log(Level.INFO, "Initiating shutdown procedures.");
        ShutDown.shutDown();
    }

    public static void entryManager(String inputBuffer, boolean isFromFile)
            throws UnknownInputException, IncorrectInputException {
        LOGGER.log(Level.INFO, "Managing entry for input: {0}", inputBuffer);
        Scanner bufferScanner = new Scanner(inputBuffer);   //Scanner for the buffer
        String firstWord = bufferScanner.next();            //Stores first word in the input
        assert firstWord != null && !firstWord.isEmpty() : "First word shouldn't be null or empty";
        boolean hasInputInteger = bufferScanner.hasNextInt();    //Indicates that some integer was input
        int numberInput = DEFAULT_NUMBER_INPUT;             //Stores the number input
        if (hasInputInteger) {
            numberInput = bufferScanner.nextInt();
            assert numberInput != DEFAULT_NUMBER_INPUT : "Number input wasn't parsed correctly";
        }

        //Functionalities
        if (firstWord.equals("add")) {
            AddCommand.addEntry(inputBuffer, isFromFile);
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