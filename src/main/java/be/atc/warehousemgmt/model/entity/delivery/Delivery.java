package be.atc.warehousemgmt.model.entity.delivery;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by Wéry Lionel on 22/05/16.
 */

@Entity
public class Delivery extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;
    @ManyToOne
    @JoinColumn
    private Vehicle vehicle;
    @Enumerated(EnumType.STRING)
    private DeliveryState deliveryState;

    public Delivery() {
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public DeliveryState getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(DeliveryState deliveryState) {
        this.deliveryState = deliveryState;
    }
}
