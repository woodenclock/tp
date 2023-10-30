package seedu.wildwatch.parser;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.exception.InvalidInputException;

public interface Parser<T extends Command> {

    T parse(String input) throws InvalidInputException;
}
