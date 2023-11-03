package seedu.wildwatch.parser;

import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.command.DeleteCommand;
import seedu.wildwatch.command.SummaryCommand;
import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SummaryCommandParser implements Parser<SummaryCommand> {

    private static final String COMMAND_WORD = "summary";

    @Override
    public SummaryCommand parse(String input) throws InvalidInputException {
        String speciesName = getArgumentFromInput(input);

        return new SummaryCommand(speciesName);
    }

    /**
     * Gets the argument (species name) if specified.
     *
     * @param input
     * @return species name if specified, otherwise an empty string.
     */
    protected String getArgumentFromInput(String input) {
        return input.replace("summary", "").trim();
    }
}
