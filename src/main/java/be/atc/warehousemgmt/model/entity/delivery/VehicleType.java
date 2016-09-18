package be.atc.warehousemgmt.model.entity.delivery;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by Wéry Lionel on 12/07/16.
 */

@Entity
public class VehicleType extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleTypeId;
    @Column
    private String label;
    @Column
    private Double surface;
    @Column
    private Double maximumWeight;
    @Column
    private Double threshold;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
}
