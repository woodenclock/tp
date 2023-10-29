package seedu.wildwatch.operation;

import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.command.DeleteCommand;
import seedu.wildwatch.command.FindCommand;
import seedu.wildwatch.entry.EntryList;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Ui class that is in-charge of interaction with the user
 * Represents the user interface of the application.
 * Provides methods to interact with the user and display messages.
 * Prints out appropriate messages such as errors and tasks added
 */
public class Ui {
    private static final int NUMBER_OF_UNDERSCORES = 60;
    private static Scanner in = new Scanner(System.in);

    public static void inputPromptPrinter() {
        System.out.print(">>> ");
    }

    /**
     * Prints out appropriate message when checking if file exists
     */
    public static void checkingIfFileExistsMessagePrinter() {
        System.out.println("Checking if \"WildWatch.txt\" already exists...");
    }

    /**
     * Prints out appropriate message when file is corrupt
     */
    public static void corruptFileMessagePrinter() {
        System.out.println("File is corrupted.\nUnable to read file");
    }

    public static void entryAddedMessagePrinter() {
        System.out.println("The following entry has been added:");
    }

    public static void entryCountPrinter() {
        System.out.println("Now you have " + (EntryList.getArraySize()) + " entries in the list.");
    }

    public static void emptyDescriptionMessagePrinter(String description) {
        if (description == null) {
            System.out.println("OOPS!!! The description cannot be empty. :-(");
        } else if (description.equals(AddCommand.COMMAND_WORD)) {
            System.out.println("OOPS!!! The description of an add command cannot be empty. :-(");
        } else if (description.equals(DeleteCommand.COMMAND_WORD)) {
            System.out.println("OOPS!!! The description of a delete command cannot be empty. :-(");
        } else if (description.equals(FindCommand.COMMAND_WORD)) {
            System.out.println("OOPS!!! The description of a find command cannot be empty. :-(");
        } else {
            System.out.println("OOPS!!! The description cannot be empty. :-(");
        }
    }

    public static void emptyListMessagePrinter() {
        System.out.println("OOPS!!! Nothing to list. :-(");
    }

    public static void entryNotFoundMessagePrinter() {
        System.out.println("OOPS!!! The entry number could not be found :-(");
    }

    public static void entryRemovedMessagePrinter() {
        System.out.println("The entry has been removed.");
    }

    /**
     * Prints an error message to the console.
     *
     * @param exception The exception that occurred.
     */
    public static void errorMessagePrinter(Exception exception) {
        System.out.println("An error occurred: " + exception.getMessage());
    }

    /**
     * Prints out appropriate message when creation of new file failed
     */
    public static void fileCreationFailMessagePrinter() {
        System.out.println("File creation failed.");
    }

    /**
     * Prints out appropriate message when file already exists
     */
    public static void fileExistMessagePrinter() {
        System.out.println("File already exists.\nOpening existing file...\n");
    }

    /**
     * Prints out appropriate message when file is not found
     */
    public static void fileNotFoundMessagePrinter() {
        System.out.println("File not found.");
    }

    public static void findTaskMessagePrinter(boolean hasMatch, ArrayList<Integer> matchingTasks) {
        if (!hasMatch) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.print((i+1) + ".");
                printEntry(matchingTasks.get(i));
            }
        }
    }

    public static void incorrectInputMessagePrinter(String error) {
        System.out.println("OOPS!!! Format of command is incorrect.");
        System.out.println(error);
    }

    public static void invalidDateMessagePrinter() {
        System.out.println("OOPS!!! Invalid Date input :-(");
    }

    /**
     * Returns input of the user from the console.
     * @return The user's input as a trimmed string.
     */
    public static String inputRetriever() {
        return in.nextLine().trim();
    }

    public static void listMessagePrinter() {
        System.out.println("Here are the entries in your list: ");
    }

    /**
     * Prints out appropriate message when no file found
     */
    public static void noFileMessagePrinter() {
        System.out.println("File does not exist.");
    }

    /**
     * Prints out message after a new file has been created.
     */
    public static void createNewFileMessagePrinter() {
        System.out.println("Creating new file...\nFile created successfully.");
    }

    public static void printEntry(int nthEntry) {
        System.out.print("Date: [" +
                EntryList.getEntryDate(nthEntry).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "] | ");
        System.out.print("Species: [" + EntryList.getEntrySpecies(nthEntry) + "] | ");
        System.out.print("Name: [" + EntryList.getEntryName(nthEntry) + "] | ");
        System.out.print("Remark: [" + EntryList.getEntryRemark(nthEntry) + "]");
        System.out.print(System.lineSeparator());
    }

    public static void printHorizontalLines() {
        for (int i = 0; i < NUMBER_OF_UNDERSCORES; i++) {
            System.out.print("_");
        }
        System.out.print(System.lineSeparator());
    }

    /**
     * Prints out appropriate message when tasks are loaded
     */
    public static void taskLoadedMessagePrinter() {
        System.out.println("These are tasks loaded from before: ");
    }

    public static void unknownInputMessagePrinter() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void printSummarySpecieMessage() {
        System.out.println("Here are the species recorded: ");
    }
    public static void printSummaryNameMessage(String speciesName) {
        System.out.println("Here is the data for the " + speciesName + ", grouped by their names");
    }
}


