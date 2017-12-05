package br.com.novaroma.helpet.Entitys;

/**
 * Created by eduar on 05/11/2017.
 */

public class Animal extends Entity {
    private String species;
    private String gait;
    private String color;

    public Animal() {}

    public Animal(String species, String gait, String color) {
        this.species = species;
        this.gait = gait;
        this.color = color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGait() {
        return gait;
    }

    public void setGait(String gait) {
        this.gait = gait;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", gait='" + gait + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
