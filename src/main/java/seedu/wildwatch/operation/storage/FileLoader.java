package seedu.wildwatch.operation.storage;

import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.operation.ShutDown;
import seedu.wildwatch.operation.Ui;
import seedu.wildwatch.parser.FileStringParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
    /**
     * Loads tasks from file into the TaskList.
     */
    public static void loadFile(File openedFile) {
        try {
            Scanner fileReader = new Scanner(openedFile); // create a Scanner using the File as the source
            while (fileReader.hasNext()) {
                String lineOfFile = fileReader.nextLine();

                // Creates new entry from line in file
                new FileStringParser().parse(lineOfFile).execute();
            }
        } catch (FileNotFoundException exception) {
            Ui.fileNotFoundMessagePrinter();
        } catch (InvalidInputException e) {
            Ui.corruptFileMessagePrinter();
            ShutDown.shutDown();
            System.exit(0);
        }
    }
}
