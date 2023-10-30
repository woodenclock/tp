package seedu.wildwatch.parser;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.exception.IncorrectInputException;

public interface Parser<T extends Command> {

    T parse(String input) throws IncorrectInputException;
}
