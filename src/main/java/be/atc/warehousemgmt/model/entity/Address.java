package be.atc.warehousemgmt.model.entity;

import javax.persistence.Embeddable;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Embeddable
public class Address {

    private String city;
    private String postCode;
    private String street;
    private String number;
    private String box;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
