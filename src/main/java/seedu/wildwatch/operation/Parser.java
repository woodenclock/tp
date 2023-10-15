package seedu.wildwatch.operation;

import java.util.Scanner;

import seedu.wildwatch.command.HelpCommand;
import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.command.DeleteCommand;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.exception.UnknownInputException;


public class Parser {
    public static void manualInputHandler() {
        while (true) {
            String inputBuffer = Ui.inputRetriever(); //Retrieves input of user

            if (inputBuffer.contains("bye")) {  //Program exit
                break;
            } else if (inputBuffer.equals("help")) {
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
        ShutDown.shutDown();
    }

    public static void entryManager(String inputBuffer, boolean isFromFile) throws UnknownInputException {
        Scanner bufferScanner = new Scanner(inputBuffer);   //Scanner for the buffer
        String firstWord = bufferScanner.next();            //Stores first word in the input
        boolean hasInteger = bufferScanner.hasNextInt();    //Indicates that some integer was input
        int numberInput = -1;                               //Stores the number input
        if (hasInteger) {
            numberInput = bufferScanner.nextInt();
        }

        //Functionalities
        if (firstWord.equals("add")) {
            AddCommand.addEntry(inputBuffer, isFromFile);
        } else if (firstWord.equals("delete") && hasInteger && !bufferScanner.hasNext()) {
            DeleteCommand.deleteEntry(numberInput);
        } else if (inputBuffer.equals("list")) {
            ListCommand.listEntry(isFromFile);
        }
        throw new UnknownInputException();
    }
}
