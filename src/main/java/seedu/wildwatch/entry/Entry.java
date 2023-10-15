package seedu.wildwatch.entry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entry {
    private LocalDate date;
    private String species;
    private String name;
    private String remark;

    public Entry(String date, String species, String name, String remark) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yy");
        this.date = LocalDate.parse(date, inputFormat);
        this.species = species;
        this.name = name;
        this.remark = remark;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
