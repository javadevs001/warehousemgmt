package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleState;
import be.atc.warehousemgmt.model.entity.delivery.VehicleType;

/**
 * Created by  Wéry Lionel. on 16/07/16.
 */
public class VehicleBean {

    private Long vehicleId;
    private String label;
    private String vehicleState;
    private Long vehicleTypeId;
    private String vehicleTypeLabel;

    public VehicleBean() {
    }

    public static VehicleBean of(Vehicle vehicle) {
        VehicleBean vehicleBean = new VehicleBean();
        vehicleBean.setVehicleId(vehicle.getVehicleId());
        vehicleBean.setLabel(vehicle.getLabel());
        vehicleBean.setVehicleState(vehicle.getVehicleState() != null ? vehicle.getVehicleState().name() : "");
        vehicleBean.setVehicleId(vehicle.getVehicleType() != null ? vehicle.getVehicleType().getVehicleTypeId() : null);
        vehicleBean.setVehicleTypeLabel(vehicle.getVehicleType() != null ? vehicle.getVehicleType().getLabel() : "");
        return vehicleBean;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }


    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Vehicle prepareForCreate(VehicleType vehicleType) {
        Vehicle vehicle = new Vehicle();
        vehicle.setLabel(getLabel());
        vehicle.setVehicleState(VehicleState.AVAILABLE);
        vehicle.setVehicleType(vehicleType);
        return vehicle;
    }


    public String getVehicleTypeLabel() {
        return vehicleTypeLabel;
    }

    public void setVehicleTypeLabel(String vehicleTypeLabel) {
        this.vehicleTypeLabel = vehicleTypeLabel;
    }
}
