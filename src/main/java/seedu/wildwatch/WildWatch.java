package seedu.wildwatch;

import seedu.operatingsystem.BootUp;
import java.util.Scanner;

public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        System.out.println(BootUp.WELCOME_MESSAGE);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}
