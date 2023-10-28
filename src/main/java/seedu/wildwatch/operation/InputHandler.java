package seedu.wildwatch.operation;

import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.command.HelpCommand;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InputHandler {
    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public static void handleManualInput() {
        while (true) {
            Ui.inputPromptPrinter();
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
}
