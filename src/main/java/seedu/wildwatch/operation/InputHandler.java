package seedu.wildwatch.operation;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.command.ByeCommand;
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

            try {
                Command command = EntryHandler.handleEntry(inputBuffer);

                if (command instanceof ByeCommand) {
                    break;
                }

                Ui.printHorizontalLines();
                command.execute();
                Ui.printHorizontalLines();

            } catch (IncorrectInputException e) {
                Ui.incorrectInputMessagePrinter(e.toString());
            } catch (UnknownInputException e) {
                Ui.unknownInputMessagePrinter();
            }
        }

        EntryList.saveEntry();
        ByeCommand.exitProgram();
    }

    public static void handleFileInput(String lineOfFile) {
        try {
            EntryHandler.handleEntry(lineOfFile);
        } catch (UnknownInputException | IncorrectInputException exception) {
            //TODO: this function is no longer useful but this has to be moved somewhere
            Ui.corruptFileMessagePrinter();
            ShutDown.shutDown();
            System.exit(0);
        }
    }
}
