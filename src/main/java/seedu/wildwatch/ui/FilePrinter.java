package seedu.wildwatch.ui;

public class FilePrinter {
    /**
     * Prints out appropriate message when file is corrupt
     */
    public static void corruptFileMessagePrinter() {
        System.out.println("File is corrupted.\nUnable to read file");
    }

    /**
     * Prints out message after a new file has been created.
     */
    public static void createNewFileMessagePrinter() {
        System.out.println("Creating new file...\nFile created successfully.");
    }

    /**
     * Prints out appropriate message when creation of new file failed
     */
    public static void fileCreationFailMessagePrinter() {
        System.out.println("File creation failed.");
    }

    /**
     * Prints out appropriate message when file already exists.
     */
    public static void fileExistMessagePrinter() {
        System.out.println("File already exists.\nOpening existing file...\n");
    }

    /**
     * Prints out appropriate message when no file found.
     * Home directory meaning where WildWatch.jar file is residing.
     */
    public static void noFileMessagePrinter() {
        System.out.println("File does not exist.");
    }

    /**
     * Prints out appropriate message when checking if file exists
     */
    public static void checkingIfFileExistsMessagePrinter() {
        System.out.println("Checking if \"WildWatch.txt\" already exists...");
    }

    /**
     * Prints out appropriate message when tasks are loaded
     */
    public static void taskLoadedMessagePrinter() {
        System.out.println("These are entries loaded from before: ");
    }
}
