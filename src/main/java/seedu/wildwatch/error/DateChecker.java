//@@woodenclock
package seedu.wildwatch.error;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public class DateChecker {
    private static final Pattern DATE_PATTERN = Pattern.compile(
            "(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-\\d{2}"   // dd-mm-yy
    );
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static boolean isDateValid(String date) {
        try {
            date = date.trim();
            if (DATE_PATTERN.matcher(date).matches()) {
                String updatedDate = prepender(date);
                LocalDate.parse(updatedDate, DATE_FORMATTER);
                return true;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
        return false;
    }

    public static String prepender(String date) {
        // Split the date string into parts
        String[] parts = date.trim().split("-");

        // Prepend "20" to the year part
        String year = "20" + parts[2];

        // Reconstruct the date string with the updated year
        String updatedDate = parts[0] + "-" + parts[1] + "-" + year;

        return updatedDate;
    }
}
