//@@woodenclock
package seedu.wildwatch.input;

import java.util.logging.Level;
import java.util.logging.Logger;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.command.ByeCommand;
import seedu.wildwatch.ui.Ui;

public class InputHandler {
    private static final Logger LOGGER = Logger.getLogger(InputHandler.class.getName());

    /**
     * Runs the WildWatch by looping through the I/O process.
     * If "bye" is received,
     */
    public static void handleInput() {
        boolean loopFlag = true;
        while (loopFlag) {
            Ui.inputPromptPrinter();
            String inputBuffer = Ui.inputRetriever(); //Retrieves input of user
            LOGGER.log(Level.INFO, "Input received: {0}", inputBuffer);
            loopFlag = CommandHandler.processCommand(inputBuffer);
            EntryList.saveEntry();
        }
        ByeCommand.exitProgram();
    }
}
