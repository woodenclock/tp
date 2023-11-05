package seedu.wildwatch.parser;

import seedu.wildwatch.command.SummaryCommand;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.InvalidInputException;

public class SummaryCommandParser implements Parser<SummaryCommand> {

    private static final String COMMAND_WORD = "summary";

    @Override
    public SummaryCommand parse(String input) throws InvalidInputException {
        String speciesName = getArgumentFromInput(input);
        // speciesName can be blank - i.e. no argument specified
        if( !speciesName.isEmpty() ) {
            // if there is an argument specified, check if it
            boolean hasSpecie = EntryList.hasSpecie(speciesName);
            if( !hasSpecie ) {
                throw new InvalidInputException("Specie does not exists !");
            }
        }
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
