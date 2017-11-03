package br.com.novaroma.helpet_android.Entity;

/**
 * Created by eduar on 03/11/2017.
 */

public class Address extends Entity{

    private String street, neighborhood, city, state;

    public Address(){}

    public Address(String street, String neighborhood, String city, String state) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
