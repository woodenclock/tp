package seedu.wildwatch.execute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import seedu.wildwatch.exception.InvalidInputException;

public class RouterTest {

    @BeforeEach
    public void setUp() {
        // Set up necessary mocks, initial data, etc.
    }

    @Test
    public void testAddEntryFromFile() {
        String input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel_2 R/Injured left flipper";
        assertDoesNotThrow(() -> Router.route(input));
    }

    @Test
    public void testAddEntryNotFromFile() {
        String input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel_2 R/Injured left flipper";
        assertDoesNotThrow(() -> Router.route(input));
    }

    @Test
    public void testDeleteEntryWithValidNumber() {
        CommandHandler.processCommand("add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper");
        String input = "delete 1"; // 1 is a valid entry number.
        assertDoesNotThrow(() -> Router.route(input));
    }

    @Test
    public void testDeleteEntryWithInvalidNumber() {
        String input = "delete -5"; // Negative numbers should be invalid.
        assertThrows(InvalidInputException.class, () -> Router.route(input));
    }

    @Test
    public void testListEntry() {
        String input = "list";
        assertDoesNotThrow(() -> Router.route(input));
    }

    @Test
    public void testInvalidCommand() {
        String input = "invalidCommand";
        assertThrows(InvalidInputException.class, () -> Router.route(input));
    }
}

