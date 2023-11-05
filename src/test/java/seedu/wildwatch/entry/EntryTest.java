package seedu.wildwatch.entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EntryTest {
    private Entry entry;

    @BeforeEach
    void setUp() {
        entry = new Entry("01-01-20", "Lion", "Simba", "King of the Jungle");
    }

    @Test
    void constructor_validInputs_InitializesCorrectly() {
        LocalDate expectedDate = LocalDate.of(2020, 1, 1);
        assertEquals(expectedDate, entry.getDate());
        assertEquals("Lion", entry.getSpecies());
        assertEquals("Simba", entry.getName());
        assertEquals("King of the Jungle", entry.getRemark());
    }

    @Test
    void getters_whenCalled_ReturnCorrectValues() {
        assertEquals(LocalDate.of(2020, 1, 1), entry.getDate());
        assertEquals("Lion", entry.getSpecies());
        assertEquals("Simba", entry.getName());
        assertEquals("King of the Jungle", entry.getRemark());
    }

    @Test
    void setters_whenCalled_UpdateValues() {
        entry.setDate("02-02-20");
        entry.setSpecies("Elephant");
        entry.setName("Dumbo");
        entry.setRemark("Loves to fly");

        assertEquals(LocalDate.of(2020, 2, 2), entry.getDate());
        assertEquals("Elephant", entry.getSpecies());
        assertEquals("Dumbo", entry.getName());
        assertEquals("Loves to fly", entry.getRemark());
    }

    @Test
    void equals_differentEntries_ReturnsFalse() {
        Entry anotherEntry = new Entry("01-01-20", "Tiger", "Shere Khan",
                "Lurks in the shadows");
        assertFalse(entry.equals(anotherEntry));
    }

    @Test
    void equals_sameEntries_ReturnsTrue() {
        Entry sameEntry = new Entry("01-01-20", "Lion", "Simba", "King of the Jungle");
        assertTrue(entry.equals(sameEntry));
    }
}
