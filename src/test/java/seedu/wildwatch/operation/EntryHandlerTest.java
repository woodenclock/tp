package seedu.wildwatch.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;

public class EntryHandlerTest {

    @BeforeEach
    public void setUp() {
        // Set up necessary mocks, initial data, etc.
    }

    @Test
    public void testAddEntryFromFile() {
        String input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel_2 R/Injured left flipper";
        assertDoesNotThrow(() -> EntryHandler.handleEntry(input, true));
    }

    @Test
    public void testAddEntryNotFromFile() {
        String input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel_2 R/Injured left flipper";
        assertDoesNotThrow(() -> EntryHandler.handleEntry(input, false));
    }

    @Test
    public void testDeleteEntryWithValidNumber() {
        String input = "delete 1"; // Assuming 1 is a valid entry number.
        assertDoesNotThrow(() -> EntryHandler.handleEntry(input, false));
    }

    @Test
    public void testDeleteEntryWithInvalidNumber() {
        String input = "delete -5"; // Negative numbers should be invalid.
        assertThrows(IncorrectInputException.class, () -> EntryHandler.handleEntry(input, false));
    }

    @Test
    public void testListEntry() {
        String input = "list";
        assertDoesNotThrow(() -> EntryHandler.handleEntry(input, false));
    }

    @Test
    public void testUnknownCommand() {
        String input = "unknownCommand";
        assertThrows(UnknownInputException.class, () -> EntryHandler.handleEntry(input, false));
    }
}

