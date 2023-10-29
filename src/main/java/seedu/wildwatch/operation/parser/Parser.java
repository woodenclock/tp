package seedu.wildwatch.operation.parser;

import seedu.wildwatch.command.Command;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownInputException;

public interface Parser<T extends Command> {

    T parse(String input) throws IncorrectInputException, UnknownInputException;
}
