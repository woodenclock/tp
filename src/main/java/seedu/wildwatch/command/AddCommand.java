package seedu.wildwatch.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for adding task to EntryList
 */
public class AddCommand extends Command {

    public static final Pattern ADD_ENTRY_COMMAND_FORMAT =
            Pattern.compile("add"
                    + " D/(?<date>[^/]+)"
                    + " S/(?<species>[^/]+)"
                    + " N/(?<name>[^/]+)"
                    + "(?: R/(?<remark>[^/]+))?");

    public static void addEntry(String inputBuffer, boolean isFromFile) throws IncorrectInputException {
        //if (!isFromFile) {
        //    Ui.listMessagePrinter();
        //}

        final Matcher matcher = ADD_ENTRY_COMMAND_FORMAT.matcher(inputBuffer);
        if (!matcher.matches()) {
            throw new IncorrectInputException();
        }

        final String date = matcher.group("date");
        final String species = matcher.group("species");
        final String name = matcher.group("name");
        final String remark = matcher.group("remark");

        EntryList.addEntry(date, species, name, remark);
        Ui.entryAddedMessagePrinter();
        Ui.printEntry(EntryList.getArraySize() - 1);
    }
}

