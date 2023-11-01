//@@woodenclock
package seedu.wildwatch.operation.storage;

import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.operation.bootupshutdown.BootUp;
import seedu.wildwatch.operation.bootupshutdown.ShutDown;
import seedu.wildwatch.operation.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_PATH = "./WildWatch.txt";
    private static File openedFile; //File to save the entries

    public static void handleFile() {
        if (ExistenceChecker.checkFileExistence(FILE_PATH)) {
            Ui.fileExistMessagePrinter();
            openedFile = new File(FILE_PATH);
            try {
                FileLoader.loadFile(openedFile); // Loads entries from file
                assert openedFile != null : "Trying to read from a non-initialized file.";
                Ui.taskLoadedMessagePrinter();

                // Lists entries loaded from file
                ListCommand.listEntry();
            } catch (FileNotFoundException exception) {
                Ui.fileNotFoundMessagePrinter();
            } catch (InvalidInputException e) {
                Ui.corruptFileMessagePrinter();
                ShutDown.shutDown();
                System.exit(0);
            }


        } else {  // File does not exist
            Ui.noFileMessagePrinter();
            try {
                openedFile = FileCreater.createFile(FILE_PATH);
            } catch (IOException exception) {
                Ui.fileCreationFailMessagePrinter();
                ShutDown.shutDown();
                System.exit(0);
            }
            assert openedFile.exists() : "File was supposed to be created but it doesn't exist.";
        }

        BootUp.bootUpTwo(); //Welcome prompt message
    }
}
