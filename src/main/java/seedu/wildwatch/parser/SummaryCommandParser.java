package seedu.wildwatch.parser;

import seedu.wildwatch.command.SummaryCommand;
import seedu.wildwatch.exception.InvalidInputException;

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
