package seedu.wildwatch.entry;

import java.time.LocalDate;
import java.util.ArrayList;

public class EntryList {
    private static ArrayList<Entry> entries = new ArrayList<>();   //Keeps track of all Entry instances made

    public static ArrayList<Entry> getArray() {
        return entries;
    }

    public static int getArraySize() {
        return entries.size();
    }

    public static void addEntry(String date, String species, String remark) {
        entries.add(new Entry(date, species, remark));
    }

    public static Entry getEntry(int nthTask) {
        return entries.get(nthTask);
    }

    public static LocalDate getEntryDate(int nthTask) {
        return getEntry(nthTask).getDate();
    }

    public static String getEntrySpecies(int nthTask) {
        return getEntry(nthTask).getSpecies();
    }

    public static String getEntryRemark(int nthTask) {
        return getEntry(nthTask).getRemark();
    }

    public static boolean isArrayEmpty() {
        return entries.isEmpty();
    }
}
