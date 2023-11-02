package seedu.wildwatch.parser;

import org.junit.jupiter.api.Test;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.entry.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.error.InvalidInputErrorType;

public class AddCommandParserTest {
    private final AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_success() throws Exception {
        String input;
        AddCommand expected, actual;

        // add command with remark
        input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        expected = new AddCommand(
                new Entry("02-03-23",
                        "Annam Leaf Turtle",
                        "Ariel",
                        "Injured left flipper"));

        actual = parser.parse(input);
        assertEquals(actual, expected);

        // add command without remark
        input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel";
        expected = new AddCommand(
                new Entry("02-03-23",
                        "Annam Leaf Turtle",
                        "Ariel",
                        ""));

        actual = parser.parse(input);
        assertEquals(actual, expected);

        // add command with spacings between prefix and values
        input = "add D/ 02-03-23 S/ Annam Leaf Turtle N/ Ariel R/ Injured left flipper";
        expected = new AddCommand(
                new Entry("02-03-23",
                        "Annam Leaf Turtle",
                        "Ariel",
                        "Injured left flipper"));

        actual = parser.parse(input);
        assertEquals(actual, expected);

        // add command with extra spacings after definitions
        input = "add   D/  02-03-23   S/  Annam Leaf Turtle   N/  Ariel   R/  Injured left flipper  ";
        expected = new AddCommand(
                new Entry("02-03-23",
                        "Annam Leaf Turtle",
                        "Ariel",
                        "Injured left flipper"));

        actual = parser.parse(input);
        assertEquals(actual, expected);
    }

    @Test
    public void parse_exceptionThrown() throws Exception {

        // D/ prefix is not present
        final String test_input_1 = "add S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        InvalidInputException exception_1 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_1));
        assertEquals(exception_1.getError(), InvalidInputErrorType.INVALID_INPUT);
        assertEquals(exception_1.getCustomMessage(), "D/ is not defined");

        // date is not specified
        final String test_input_2 = "add D/ S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        InvalidInputException exception_2 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_2));
        assertEquals(exception_2.getError(), InvalidInputErrorType.INVALID_INPUT);
        assertEquals(exception_2.getCustomMessage(), "Date value cannot be empty.");

        // date is not in a correct format
        final String test_input_3 = "add D/1 S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        InvalidInputException exception_3 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_3));
        assertEquals(exception_3.getError(), InvalidInputErrorType.INVALID_DATE);
        assertEquals(exception_3.getCustomMessage(), "Command is invalid.");

        // S/ prefix is not present
        final String test_input_4 = "add D/02-03-23 N/Ariel R/Injured left flipper";
        InvalidInputException exception_4 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_4));
        assertEquals(exception_4.getError(), InvalidInputErrorType.INVALID_INPUT);
        assertEquals(exception_4.getCustomMessage(), "S/ is not defined");

        // species is not specified
        final String test_input_5 = "add D/02-03-23 S/ N/Ariel R/Injured left flipper";
        InvalidInputException exception_5 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_5));
        assertEquals(exception_5.getError(), InvalidInputErrorType.INVALID_INPUT);
        assertEquals(exception_5.getCustomMessage(), "Species is not defined.");

        // N/ prefix is not present
        final String test_input_6 = "add D/02-03-23 S/Annam Leaf Turtle R/Injured left flipper";
        InvalidInputException exception_6 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_6));
        assertEquals(exception_6.getError(), InvalidInputErrorType.INVALID_INPUT);
        assertEquals(exception_6.getCustomMessage(), "N/ is not defined");

        // name is not specified
        final String test_input_7 = "add D/02-03-23 S/Annam Leaf Turtle N/ R/Injured left flipper";
        InvalidInputException exception_7 = assertThrows(InvalidInputException.class, () -> parser.parse(test_input_7));
        assertEquals(exception_7.getError(), InvalidInputErrorType.INVALID_INPUT);
        assertEquals(exception_7.getCustomMessage(), "Name is not defined");

    }
}
