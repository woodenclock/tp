//@@lctxct
package seedu.wildwatch.command;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.error.FilenameChecker;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.storage.EntryToStringConverter;
import seedu.wildwatch.storage.FileCreater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Command class for exporting all current entries as a CSV file.
 */
public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";

    public static final Pattern EXPORT_COMMAND_FORMAT =
            Pattern.compile("export(?:\\s+(?<filename>\\S+))?\\s*");

    public static final String DEFAULT_FILENAME = "WildWatch.csv";

    private static final String[] ALL_COLUMNS = new String[] { "date", "species", "name", "remark" };

    private String filename;

    /**
     * Constructs a new {@code ExportCommand}.
     *
     * @param file Name of file to set on {@code filename}.
     */
    public ExportCommand(String file) {
        filename = file;
    }

    /**
     * Constructs a new {@code ExportCommand}, with filename set
     * to {@code DEFAULT_FILENAME}.
     */
    public ExportCommand() {
        this(DEFAULT_FILENAME);
    }

    @Override
    public void execute() throws InvalidInputException {

        if (EntryList.isArrayEmpty()) {
            throw new InvalidInputException("No entries to write to csv.");
        }

        boolean canReplaceFile = false;
        File file = new File(filename);
        do {
            canReplaceFile = canReplaceFile(filename);
            if (!canReplaceFile) {
                filename = getNewFilename();
                file = new File(filename);
            }
        } while (file.exists() && !canReplaceFile);

        if (!file.exists()) {
            createFile();
        }

        ArrayList<Entry> entries = EntryList.getArray();

        ArrayList<String> columnsToInclude = getColumnsToInclude();
        if (columnsToInclude.isEmpty()) {
            throw new InvalidInputException("You need to select at least one column to include in the csv.");
        }

        String header = "id";
        for (String column : columnsToInclude) {
            header = String.join(",", header, column);
        }

        try {
            FileWriter writer = new FileWriter(filename);

            writer.write(header + "\n");
            for (int i = 0; i < EntryList.getArraySize(); i++) {
                writer.write(EntryToStringConverter.toCsvString(entries.get(i), i+1, columnsToInclude));
            }
            writer.close();
        } catch (IOException e) {
            throw new InvalidInputException("Error writing to file.");
        }

        System.out.printf("Export to CSV completed successfully."
                + " Your data has been successfully saved to %s.\n", filename);
    }

    private String getNewFilename() throws InvalidInputException {
        String newFilename;
        Scanner scanner = new Scanner(System.in);

        String specifyNewFilenamePrompt = "Would you like to specify a new filename? (Y/N)";
        if (!(doesUserApprove(scanner, specifyNewFilenamePrompt))) {
            throw new InvalidInputException("Exiting export command...");
        }

        boolean isValidFilename = false;
        do {
            System.out.println("What would you like to name your new file?");
            System.out.println("Input a new filename, or q/ to quit: ");

            newFilename = scanner.nextLine().trim();

            if (newFilename.equals("q/")) {
                throw new InvalidInputException("Exiting export command...");
            }

            isValidFilename = FilenameChecker.isValidCsvFilenameChecker(newFilename);
            if (!isValidFilename) {
                System.out.print("Filename is invalid! ");
            }
        } while (!isValidFilename);

        return newFilename;
    }

    /**
     * Confirms with user if file can be replaced. Returns true if user
     * accepts, and false otherwise.
     *
     * @return True if user allows file to be replaced, else false.
     */
    private boolean canReplaceFile(String filename) {
        Scanner scanner = new Scanner(System.in);

        final String confirmationMessage =
                String.format("%s already exists. Would you like to replace it? (Y/N)", filename);

        return doesUserApprove(scanner, confirmationMessage);
    }

    /**
     * Reads user input in a loop until "Y" or "N" received.
     *
     * @param scanner Scanner used to read user input
     * @param confirmationMessage Message to prompt user for input
     * @return true if user inputs "Y", false if user inputs "N"
     */
    private boolean doesUserApprove(Scanner scanner, String confirmationMessage) {
        do {
            System.out.print(confirmationMessage);
            System.out.print(": ");
            String confirmation = scanner.nextLine().trim();

            switch (confirmation) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Unrecognized input!"
                        + " Please ensure that you only respond with Y or N.");
            }
        } while (true);
    }

    private void createFile() throws InvalidInputException {

        System.out.println("File does not exist.");

        try {
            FileCreater.createFile(filename);
        } catch (IOException e) {
            throw new InvalidInputException("Unable to create file.");
        }
    }

    private ArrayList<String> getColumnsToInclude() {
        ArrayList<String> columnsToInclude = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String includeAllColumnsMessage = "Would you like to include all columns? (Y/N)";
        if (doesUserApprove(scanner, includeAllColumnsMessage)) {
            Collections.addAll(columnsToInclude, ALL_COLUMNS);

            return columnsToInclude;
        }

        System.out.println("Please select the columns you would like to include in your csv:");

        for (String column : ALL_COLUMNS) {
            String confirmationMessage = String.format("Would you like to include %s in your csv? (Y/N)", column);

            boolean shouldIncludeColumn = doesUserApprove(scanner, confirmationMessage);
            if (shouldIncludeColumn) {
                columnsToInclude.add(column);
            }
        }

        return columnsToInclude;
    }
}
