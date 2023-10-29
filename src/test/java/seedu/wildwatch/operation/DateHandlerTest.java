package seedu.wildwatch.operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateHandlerTest {
    @Test
    public void testDateHandler() {
        Ui.printHorizontalLines();
        System.out.println("Testing whether date is valid...");
        Ui.printHorizontalLines();
        assertTrue(DateHandler.isDateValid("09-11-23"));
        assertFalse(DateHandler.isDateValid("9-11-23"));
        assertFalse(DateHandler.isDateValid("99-11-23"));
    }
}
