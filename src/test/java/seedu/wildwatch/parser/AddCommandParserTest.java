package seedu.wildwatch.parser;

import org.junit.jupiter.api.Test;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.entry.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.error.IncorrectInputErrorType;

public class AddCommandParserTest {
    private final AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_success() throws Exception {
        String input;
        AddCommand expected;

        // add command with remark
        input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        expected = new AddCommand(
                new Entry("02-03-23",
                        "Annam Leaf Turtle",
                        "Ariel",
                        "Injured left flipper"));

        AddCommand actual = parser.parse(input);
        assertEquals(actual, expected);

        // add command without remark
        input = "add D/02-03-23 S/Annam Leaf Turtle N/Ariel";
        expected = new AddCommand(
                new Entry("02-03-23",
                        "Annam Leaf Turtle",
                        "Ariel",
                        ""));

        assertEquals(parser.parse(input), expected);

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
        String input;

        // D/ prefix is not present
        input = "add S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getCustomMessage(), "D/ is not defined");
        }

        // date is not specified
        input = "add D/ S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getCustomMessage(), "Date value cannot be empty.");
        }

        // date is not in a correct format
        input = "add D/1 S/Annam Leaf Turtle N/Ariel R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getError(), IncorrectInputErrorType.INVALID_DATE);
        }

        // S/ prefix is not present
        input = "add D/02-03-23 N/Ariel R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getCustomMessage(), "S/ is not defined");
        }

        // species is not specified
        input = "add D/02-03-23 S/ N/Ariel R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getCustomMessage(), "Species is not defined.");
        }

        // N/ prefix is not present
        input = "add D/02-03-23 S/Annam Leaf Turtle R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getCustomMessage(), "N/ is not defined");
        }

        // name is not specified
        input = "add D/02-03-23 S/Annam Leaf Turtle N/ R/Injured left flipper";
        try {
            parser.parse(input);
        } catch (IncorrectInputException e) {
            assertEquals(e.getCustomMessage(), "Name is not defined");
        }
    }
}
