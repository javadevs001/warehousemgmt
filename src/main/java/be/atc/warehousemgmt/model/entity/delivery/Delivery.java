package be.atc.warehousemgmt.model.entity.delivery;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.Person;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Delivery extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @ManyToOne
    @JoinColumn
    private Person person;

    @ManyToOne
    @JoinColumn
    private Vehicle vehicle;

    @Column
    private String label;

    public Delivery() {
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
