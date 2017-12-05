package br.com.novaroma.helpet.Entitys;

/**
 * Created by eduar on 04/12/2017.
 */

public class Resgated extends Entity {

    private Animal animal;
    private String description;
    private Address address;

    public Resgated() {}

    public Resgated(Animal animal, String description, Address address) {
        this.animal = animal;
        this.description = description;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return description;
    }
}
