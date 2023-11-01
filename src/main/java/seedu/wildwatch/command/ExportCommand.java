//@@lctxct
package seedu.wildwatch.command;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.storage.EntryToStringConverter;
import seedu.wildwatch.storage.FileCreater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    private final String filename;

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

        File file = new File(filename);
        if (file.exists()) {
            boolean canReplaceFile = canReplaceFile(filename);
            if (!canReplaceFile) {
                System.out.println("Ignoring export command...");
                return;
            }
        } else {
            createFile();
        }

        ArrayList<Entry> entries = EntryList.getArray();

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("id,date,species,name,remarks");
            for (int i = 0; i < EntryList.getArraySize(); i++) {
                writer.write(EntryToStringConverter.toCSVString(entries.get(i), i+1));
            }
            writer.close();
        } catch (IOException e) {
            throw new InvalidInputException("Error writing to file.");
        }

        System.out.printf("%s has been written to!%n", filename);
    }

    /**
     * Confirms with user if file can be replaced. Returns true if user
     * accepts, and false otherwise.
     *
     * @return True if user allows file to be replaced, else false.
     */
    private boolean canReplaceFile(String filename) {
        final String confirmationMessage =
                String.format("%s already exists. Would you like to replace it? (Y/N)", filename);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(confirmationMessage);
            System.out.print(">> ");
            String confirmation = scanner.nextLine().trim();

            switch (confirmation) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Unrecognized input!"
                        + "Please ensure you only respond with Y or N.");
            }

        } while (true);
    }

    private void createFile() throws InvalidInputException {

        System.out.println("File does not exist.");
        String createNewFileMessage =
                String.format("Creating a new file %s", filename);
        System.out.println(createNewFileMessage);

        try {
            FileCreater.createFile(filename);
        } catch (IOException e) {
            throw new InvalidInputException("Unable to create file.");
        }
    }
}
