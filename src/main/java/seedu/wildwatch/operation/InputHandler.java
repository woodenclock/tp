package seedu.wildwatch.operation;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.error.ErrorHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InputHandler {
    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public static void handleInput() {
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
                ErrorHandler.handleInputError(e);
            }
        }

        EntryList.saveEntry();
        ByeCommand.exitProgram();
    }
}
