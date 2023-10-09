package seedu.duke.animal;

/**
 * Animal is an abstract class for all wildlife.
 */
public abstract class Animal {
    private String species;
    private String name;
    private String remark;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
