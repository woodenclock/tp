package seedu.wildwatch.storage;

import seedu.wildwatch.entry.Entry;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class EntryToStringConverter {
    private static final DateTimeFormatter STD_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yy");

    /**
     * Returns String that is in the format to be written to file.
     *
     * @param entry Entry of interest.
     * @return String.
     * @throws IOException when there is problem with formatting the task.
     */
    public static String toFileString(Entry entry) throws IOException {
        assert entry != null : "Trying to convert a null entry to file string.";
        String date = entry.getDate().format(STD_FORMAT);
        String species = entry.getSpecies();
        String name = entry.getName();
        String remark = entry.getRemark();

        return String.format("%s / %s / %s / %s", date, species, name, remark);
    }
}
