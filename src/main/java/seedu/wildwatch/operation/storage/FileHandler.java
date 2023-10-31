//@@woodenclock
package seedu.wildwatch.operation.storage;

import seedu.wildwatch.command.ListCommand;
import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.operation.BootUp;
import seedu.wildwatch.operation.ShutDown;
import seedu.wildwatch.operation.Ui;
import seedu.wildwatch.parser.FileStringParser;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static final String FILE_PATH = "./WildWatch.txt";
    private static final DateTimeFormatter STD_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yy");
    private static File openedFile; //File to save the entries

    public static void handleFile() {
        if (checkFileExistence()) {
            Ui.fileExistMessagePrinter();
            // Loads entries from file
            loadFile();
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
     * Checks if file exists. Opens file if the file exists.
     *
     * @return true if file exists; false if not.
     */
    public static boolean checkFileExistence() {
        System.out.print(System.lineSeparator());
        Ui.checkingIfFileExistsMessagePrinter();
        assert FILE_PATH != null : "File path should not be null.";
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return false;
        } else {
            openedFile = file;      //File used to save tasks
            return true;
        }
    }

    /**
     * Loads tasks from file into the TaskList.
     */
    public static void loadFile() {
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
