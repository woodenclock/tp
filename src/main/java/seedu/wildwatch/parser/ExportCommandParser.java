//@@lctxct
package seedu.wildwatch.parser;

import seedu.wildwatch.command.ExportCommand;
import seedu.wildwatch.error.InvalidInputErrorType;
import seedu.wildwatch.exception.InvalidInputException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Parses export command. Accepts optional {@code filename} argument
 * proceeding {@code export} keyword.
 */
public class ExportCommandParser implements Parser<ExportCommand> {

    private static final Pattern FILENAME_FORMAT = Pattern.compile("\\w+.csv");

    @Override
    public ExportCommand parse(String input) throws InvalidInputException {
        final Matcher matcher = ExportCommand.EXPORT_COMMAND_FORMAT.matcher(input);

        if (!matcher.matches()) {
            throw new InvalidInputException(InvalidInputErrorType.INVALID_INPUT);
        }

        String filename = matcher.group("filename");
        if (filename == null) {
            return new ExportCommand();
        }

        if (checkFilenameValid(filename)) {
            return new ExportCommand(filename);
        }

        System.out.println("Filename is invalid. Using default filename...");

        return new ExportCommand();
    }

    /**
     * Checks if filename is in the format {@code [a-zA-Z0-9_].csv}.
     *
     * @param filename Input to test
     * @return true if filename is valid, else false
     */
    private boolean checkFilenameValid(String filename) {
        final Matcher matcher = FILENAME_FORMAT.matcher(filename);
        return matcher.matches();
    }

}
