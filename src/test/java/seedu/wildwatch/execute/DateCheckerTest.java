package seedu.wildwatch.execute;

import org.junit.jupiter.api.Test;
import seedu.wildwatch.error.DateChecker;
import seedu.wildwatch.ui.LinePrinter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateCheckerTest {
    @Test
    public void testDateHandler() {
        LinePrinter.printHorizontalLines();
        System.out.println("Testing whether date is valid...");
        LinePrinter.printHorizontalLines();
        assertTrue(DateChecker.isDateValid("09-11-23"));
        assertFalse(DateChecker.isDateValid("9-11-23"));
        assertFalse(DateChecker.isDateValid("99-11-23"));
    }
}
