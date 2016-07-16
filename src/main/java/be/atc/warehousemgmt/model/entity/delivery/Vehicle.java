package be.atc.warehousemgmt.model.entity.delivery;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;

import javax.persistence.*;


@Entity
public class Vehicle extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    @Column
    private String label;
    @Enumerated(EnumType.STRING)
    private VehicleState vehicleState;
    @Column
    private Double usedSurface;
    private Double usedWeight;
    @ManyToOne
    @JoinColumn
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getUsedSurface() {
        return usedSurface;
    }

    public void setUsedSurface(Double usedSurface) {
        this.usedSurface = usedSurface;
    }

    public Double getUsedWeight() {
        return usedWeight;
    }

    public void setUsedWeight(Double usedWeight) {
        this.usedWeight = usedWeight;
    }

}
