package be.atc.warehousemgmt.model.entity;

import be.atc.warehousemgmt.model.enums.LocationState;
import be.atc.warehousemgmt.model.enums.Zone;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Location extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @Column(nullable = false, unique = true)
    private String reference;
    @Enumerated(EnumType.STRING)
    private LocationState state; /* EMPTY OR ASSIGNED */
    @Enumerated(EnumType.STRING)
    private Zone zone;
    @Column
    private String locationType;

    private Location() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public LocationState getState() {
        return state;
    }

    public void setState(LocationState state) {
        this.state = state;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
