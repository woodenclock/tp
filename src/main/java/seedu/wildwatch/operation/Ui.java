package seedu.wildwatch.operation;

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

    public static void printHorizontalLines() {
        for (int i = 0; i < NUMBER_OF_UNDERSCORES; i++) {
            System.out.print("_");
        }
        System.out.print(System.lineSeparator());
    }

    /**
     * Returns input of the user from the console.
     *
     * @return The user's input as a trimmed string.
     */
    public static String inputRetriever() {
        return in.nextLine().trim();
    }
}
