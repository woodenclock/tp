package seedu.wildwatch.command;

import org.junit.jupiter.api.Test;
import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.wildwatch.entry.EntryList.addEntry;
import static seedu.wildwatch.entry.EntryList.clearEntry;

public class DeleteCommandTest {
    @Test
    public void testDeleteCommand() {
        clearEntry();
        addEntry(new Entry("09-11-23", "Lion", "Simba", "This is Simba"));

        int entryListSizeBefore = EntryList.getArraySize();
        DeleteCommand deleteCommand = new DeleteCommand(1);
        deleteCommand.execute();

        int entryListSizeAfter = EntryList.getArraySize();

        assertEquals(entryListSizeBefore - 1, entryListSizeAfter);
    }

    @Test
    public void testDeleteCommandWithInvalidIndex(){
        EntryList.clearEntry();
        addEntry(new Entry("09-11-23", "Lion", "Simba", "This is Simba"));

        DeleteCommand deleteCommand = new DeleteCommand(2);
        deleteCommand.execute();

        int entryListSizeAfter = EntryList.getArraySize();

        assertEquals(1,entryListSizeAfter,"Entry count should remain the same due to deletiong of an invalid index");

    }
}