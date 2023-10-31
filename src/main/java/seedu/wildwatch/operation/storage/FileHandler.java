//@@woodenclock
package seedu.wildwatch.operation.storage;

import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.operation.BootUp;
import seedu.wildwatch.operation.ShutDown;
import seedu.wildwatch.operation.Ui;
import seedu.wildwatch.parser.FileStringParser;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class FileHandler {
    private static final String FILE_PATH = "./WildWatch.txt";
    private static final DateTimeFormatter STD_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yy");
    private static File openedFile; //File to save the entries

    public static void handleFile() {
        if (ExistenceChecker.checkFileExistence(FILE_PATH)) {
            Ui.fileExistMessagePrinter();
            openedFile = new File(FILE_PATH);
            FileLoader.loadFile(openedFile); // Loads entries from file
            assert openedFile != null : "Trying to read from a non-initialized file.";
            Ui.taskLoadedMessagePrinter();

            // Lists entries loaded from file
            ListCommand.listEntry();

        } else {  // File does not exist
            Ui.noFileMessagePrinter();
            createFile();
            assert openedFile.exists() : "File was supposed to be created but it doesn't exist.";
        }

        BootUp.bootUpTwo(); //Welcome prompt message
    }

    /**
     * Creates new file with filename specified by {@code FILE_PATH}.
     */
    public static void createFile() {
        File file = new File(FILE_PATH);
        try {
            if (file.createNewFile()) {
                openedFile = file;
                Ui.createNewFileMessagePrinter();
            } else {
                Ui.fileCreationFailMessagePrinter();
            }
        } catch (IOException exception) {
            Ui.errorMessagePrinter(exception);
        }
    }

    /**
     * Manages the storage of tasks in a file.
     * Write each task in the desired format to the file.
     */
    public static void saver(ArrayList<Entry> entries) {
        assert entries != null : "Trying to save a null list of entries.";
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            for (Entry entry : entries) {
                writer.write(toFileString(entry) + "\n");
            }
            writer.close();
        } catch (IOException exception) {
            Ui.errorMessagePrinter(exception);
        }
    }

    /**
     * Returns String that is in the format to be written to file.
     *
     * @param entry Entry of interest.
     * @return String.
     * @throws IOException when there is problem with formatting the task.
     */
    public static String toFileString(Entry entry) throws IOException {
        assert entry != null : "Trying to convert a null entry to file string.";
        String date = entry.getDate().format(STD_FORMAT);
        String species = entry.getSpecies();
        String name = entry.getName();
        String remark = entry.getRemark();

        return String.format("%s / %s / %s / %s", date, species, name, remark);
    }
}
