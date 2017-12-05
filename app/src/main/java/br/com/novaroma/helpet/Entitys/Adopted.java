package br.com.novaroma.helpet.Entitys;

/**
 * Created by eduar on 04/12/2017.
 */

public class Adopted extends Entity {

    private Animal animal;
    private String description;

    public Adopted() {}

    public Adopted(Animal animal, String description) {
        this.animal = animal;
        this.description = description;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return animal.getSpecies() + ", " + description;
    }
}
