package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;

/**
 * Created by ahmedidoumhaidi on 16/07/16.
 */
public class VehicleBean {

    private Long vehicleId;
    private String label;
    private String vehicleState;
    private Long vehicleTypeId;

    public VehicleBean() {
    }

    public static VehicleBean of(Vehicle vehicle) {
        VehicleBean vehicleBean = new VehicleBean();
        vehicleBean.setVehicleId(vehicle.getVehicleId());
        vehicleBean.setLabel(vehicle.getLabel());
        vehicleBean.setVehicleState(vehicle.getVehicleState() != null ? vehicle.getVehicleState().name() : "");
        vehicleBean.setVehicleId(vehicle.getVehicleType() != null ? vehicle.getVehicleType().getVehicleTypeId() : null);
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
}
