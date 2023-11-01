//@@lctxct
package seedu.wildwatch.parser;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.error.DateChecker;
import seedu.wildwatch.error.InvalidInputErrorType;

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
    public AddCommand parse(String input) throws InvalidInputException {
        performChecks(input);

        final Matcher matcher = AddCommand.ADD_ENTRY_COMMAND_FORMAT.matcher(input);
        boolean isMatch = matcher.matches();

        assert isMatch : "Command should match format.";

        final String date = matcher.group("date").trim();
        final String species = matcher.group("species").trim();
        final String name = matcher.group("name").trim();
        String remark = matcher.group("remark");

        if (remark == null) {
            remark = "";
        } else {
            remark = remark.trim();
        }

        Entry newEntry = new Entry(date, species, name, remark);

        return new AddCommand(newEntry);
    }

    /**
     * Ensures that {@code input} adheres to the command format.
     *
     * @param input
     * @throws InvalidInputException thrown if the input does not adhere to command format.
     */
    private void performChecks(String input) throws InvalidInputException {

        final Matcher matcher = ADD_ENTRY_COMMAND_FORMAT_CHECK.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidInputException("Invalid command format.");
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
     * @throws InvalidInputException thrown when date is not correctly defined
     */
    private void checkDate(Matcher matcher) throws InvalidInputException {
        if (matcher.group("dprefix") == null) {
            throw new InvalidInputException("D/ is not defined");
        }
        if (matcher.group("date") == null) {
            throw new InvalidInputException("Date value cannot be empty.");
        }
        String date = matcher.group("date").trim();
        if (!DateChecker.isDateValid(date)) {
            throw new InvalidInputException(InvalidInputErrorType.INVALID_DATE);
        }
    }

    /**
     * Checks that species is correctly defined in input. Checks the following:
     * 1. S/ is present in user input
     * 2. Species is defined
     *
     * @param matcher Input matched against command pattern
     * @throws InvalidInputException thrown when species is not correctly defined
     */
    private void checkSpecies(Matcher matcher) throws InvalidInputException {
        if (matcher.group("sprefix") == null) {
            throw new InvalidInputException("S/ is not defined");
        }
        if (matcher.group("species") == null) {
            throw new InvalidInputException("Species is not defined.");
        }
    }

    /**
     * Checks that name is correctly defined in input. Checks the following:
     * 1. N/ is present in user input
     * 2. Name is defined
     *
     * @param matcher Input matched against command pattern
     * @throws InvalidInputException thrown when species is not correctly defined
     */
    private void checkName(Matcher matcher) throws InvalidInputException {
        if (matcher.group("nprefix") == null) {
            throw new InvalidInputException("N/ is not defined");
        }
        if (matcher.group("name") == null) {
            throw new InvalidInputException("Name is not defined");
        }
    }
}
