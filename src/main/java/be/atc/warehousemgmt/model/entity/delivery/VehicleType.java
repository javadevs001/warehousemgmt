package be.atc.warehousemgmt.model.entity.delivery;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */

@Entity
public class VehicleType extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleTypeId;

    @Column
    private Double surface;
    @Column
    private Double maximumWeight;

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Double getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(Double maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }
}
