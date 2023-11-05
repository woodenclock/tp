//@@woodenclock
package seedu.wildwatch.error;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateChecker {
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static boolean isDateValid(String date) {
        try {
            // Split the date string into parts
            String[] parts = date.trim().split("-");

            // Prepend "20" to the year part
            String year = "20" + parts[2];

            // Reconstruct the date string with the updated year
            String updatedDate = parts[0] + "-" + parts[1] + "-" + year;

            LocalDate.parse(updatedDate.trim(), DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
