package seedu.wildwatch.operation.parser;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.DateHandler;
import seedu.wildwatch.operation.error.IncorrectInputErrorType;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddCommandParser implements Parser<AddCommand> {

    private static final Pattern ADD_ENTRY_COMMAND_FORMAT_CHECK =
            Pattern.compile("add"
                    + "\\s*(?<dprefix> D/)?\\s*(?<date>[^/]+)?"
                    + "\\s*(?<sprefix> S/)?\\s*(?<species>[^/]+)?"
                    + "\\s*(?<nprefix> N/)?\\s*(?<name>[^/]+)?"
                    + "\\s*(?: R/(?<remark>[^/]+))?");

    @Override
    public AddCommand parse(String input) throws IncorrectInputException {
        performChecks(input);

        final Matcher matcher = AddCommand.ADD_ENTRY_COMMAND_FORMAT.matcher(input);
        boolean isMatch = matcher.matches();

        assert isMatch : "Command should match format.";

        final String date = matcher.group("date");
        final String species = matcher.group("species");
        final String name = matcher.group("name");
        final String remark = matcher.group("remark");

        Entry newEntry = new Entry(date, species, name, remark);

        return new AddCommand(newEntry);
    }

    /**
     * Ensures that {@code input} adheres to the command format.
     *
     * @param input
     * @throws IncorrectInputException thrown if the input does not adhere to command format.
     */
    private void performChecks(String input) throws IncorrectInputException {

        final Matcher matcher = ADD_ENTRY_COMMAND_FORMAT_CHECK.matcher(input);
        if (!matcher.matches()) {
            throw new IncorrectInputException("Invalid command format.");
        }

        checkDate(matcher);
        checkSpecies(matcher);
        checkName(matcher);
    }

    /**
     * Checks that date is correctly defined in input. Checks the following:
     * 1. D/ is present in user input
     * 2. A date value is defined
     * 3. Date provided is correctly formatted
     *
     * @param matcher Input matched against command pattern
     * @throws IncorrectInputException thrown when date is not correctly defined
     */
    private void checkDate(Matcher matcher) throws IncorrectInputException {
        if (matcher.group("dprefix") == null) {
            throw new IncorrectInputException("D/ is not defined");
        }
        if (matcher.group("date") == null) {
            throw new IncorrectInputException("Date value cannot be empty.");
        }
        String date = matcher.group("date");
        if (!DateHandler.isDateValid(date)) {
            throw new IncorrectInputException(IncorrectInputErrorType.INVALID_DATE);
        }
    }

    /**
     * Checks that species is correctly defined in input. Checks the following:
     * 1. S/ is present in user input
     * 2. Species is defined
     *
     * @param matcher Input matched against command pattern
     * @throws IncorrectInputException thrown when species is not correctly defined
     */
    private void checkSpecies(Matcher matcher) throws IncorrectInputException {
        if (matcher.group("sprefix") == null) {
            throw new IncorrectInputException("S/ is not defined");
        }
        if (matcher.group("species") == null) {
            throw new IncorrectInputException("Species is not defined.");
        }
    }

    /**
     * Checks that name is correctly defined in input. Checks the following:
     * 1. N/ is present in user input
     * 2. Name is defined
     *
     * @param matcher Input matched against command pattern
     * @throws IncorrectInputException thrown when species is not correctly defined
     */
    private void checkName(Matcher matcher) throws IncorrectInputException {
        if (matcher.group("nprefix") == null) {
            throw new IncorrectInputException("N/ is not defined");
        }
        if (matcher.group("name") == null) {
            throw new IncorrectInputException("Name is not defined");
        }
    }
}
