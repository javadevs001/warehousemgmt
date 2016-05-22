package be.atc.warehousemgmt.model.entity;

import be.atc.warehousemgmt.model.enums.PersonType;
import be.atc.warehousemgmt.model.enums.Title;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Person extends AbstractAuditingEntity {

    @Enumerated(EnumType.STRING)
    private Title title; /* Mr Mrs */
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phone;
    private String fax;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private PersonType type; /* Customer Or Supplier */

    public Person() {
    }


    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }
}
