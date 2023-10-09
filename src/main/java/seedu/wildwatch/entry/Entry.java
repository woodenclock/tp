package seedu.wildwatch.entry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entry {
    private LocalDate date;
    private String species;
    private String remark;

    public Entry(String date, String species, String remark) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yy");
        this.date = LocalDate.parse(date, inputFormat);
        this.species = species;
        this.remark = remark;
    }
}
