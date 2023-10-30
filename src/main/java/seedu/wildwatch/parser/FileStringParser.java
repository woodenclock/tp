package seedu.wildwatch.parser;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.command.AddFileStringCommand;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.DateHandler;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileStringParser implements Parser<AddFileStringCommand> {

    private static final Pattern ADD_FILE_ENTRY_COMMAND_FORMAT_CHECK =
            Pattern.compile("\\s*(?<date>[^/]+)?\\s*/" +
                    "\\s*(?<species>[^/]+)?\\s*/" +
                    "\\s*(?<name>[^/]+)?\\s*/" +
                    "\\s*(?<remark>[^/]+)?");

    @Override
    public AddFileStringCommand parse(String input) throws IncorrectInputException {
        performChecks(input);

        final Matcher matcher = AddFileStringCommand.FILE_STRING_FORMAT.matcher(input);
        boolean isMatch = matcher.matches();

        assert isMatch : "Input line should match format.";

        final String date = matcher.group("date");
        final String species = matcher.group("species");
        final String name = matcher.group("name");
        final String remark = matcher.group("remark");

        Entry newEntry = new Entry(date, species, name, remark);

        return new AddFileStringCommand(newEntry);
    }

    private void performChecks(String input) throws IncorrectInputException {

        final Matcher matcher = ADD_FILE_ENTRY_COMMAND_FORMAT_CHECK.matcher(input);
        if (!matcher.matches()) {
            throw new IncorrectInputException("Invalid entry found!\n" + input);
        }

        // Check that all groups present
        if (matcher.group("date") == null ||
                matcher.group("species") == null ||
                matcher.group("name") == null) {
            throw new IncorrectInputException("Invalid entry found!\n" + input);
        }

        // Check that date is valid
        if (!DateHandler.isDateValid(matcher.group("date"))) {
            throw new IncorrectInputException("Invalid entry found!\n" + input);
        }
    }
}
