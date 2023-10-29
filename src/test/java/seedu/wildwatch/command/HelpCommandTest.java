package seedu.wildwatch.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class HelpCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();

    @BeforeEach
    void redirectSystemOut() {
        System.setOut(new PrintStream(mockOutput));
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    void testExecute() {
        HelpCommand helpCommand = new HelpCommand();
        helpCommand.execute();

        // Define the expected help page content
        String expectedHelpPage = "No worries, I'm here to help!\n" +
                "\n" +
                "---------------------------HELP PAGE-----------------------------\n" +
                "\n" +
                "_________________________________________________________________\n" +
                "1.  Get help - show the list of commands available for this app\n" +
                "     Format: help\n" +
                "     Examples: \n" +
                "       help\n" +
                "\n" +
                "_________________________________________________________________\n" +
                "2.  To add a new wildlife\n" +
                "     Format: add D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                "       DATE should be in the format DD-MM-YY\n" +
                "     Examples: \n" +
                "       add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper\n" +
                "\n" +
                "_________________________________________________________________\n" +
                "3.  To list all wildlife,\n" +
                "     Format: list\n" +
                "     Examples: \n" +
                "       list\n" +
                "\n" +
                "_________________________________________________________________\n" +
                "4.  To delete a wildlife\n" +
                "     Format: delete INDEX\n" +
                "       The index refers to the index number shown in the displayed observation list.\n" +
                "       Note:\n" +
                "           - The index must be a positive integer:\n" +
                "           - Deleted items may not be recoverable:\n" +
                "     Examples: \n" +
                "       delete 1\n" +
                "_________________________________________________________________\n" +
                "\n" +
                "-------------------------HELP PAGE END---------------------------\n" +
                "\n";

        // Normalize the line separators in the actual and expected output to ignore differences
        String actualOutput = mockOutput.toString().replace(System.lineSeparator(), "\n");
        String expectedOutput = expectedHelpPage.replace(System.lineSeparator(), "\n");

        // Assert: Verify the printed output matches the expected help page content
        assertEquals(expectedOutput, actualOutput);
    }
}
