package seedu.wildwatch.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;

public class EntryHandlerTest {

    @BeforeEach
    public void setup() {
        // Initialize or set up any required resources for tests
    }

    @Test
    public void testHandleEntry_AddFromFile() {
        try {
            EntryHandler.handleEntry("add testEntry", true);
            // Further assertions or verifications here based on expected behavior
        } catch (UnknownInputException | IncorrectInputException e) {
            Assertions.fail("Exception should not be thrown for valid input.");
        }
    }

    @Test
    public void testHandleEntry_UnknownInput() {
        Assertions.assertThrows(UnknownInputException.class, () -> {
            EntryHandler.handleEntry("unknownInput", false);
        });
    }

    // You can add more test methods for various cases, e.g., for "delete", "list", etc.

}
