package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */
public class DeliveryBean {

    private Long deliveryId;
    private String deliveryState;
    private String vehicleLabel;
    private String vehicleState;

    public DeliveryBean() {}

    public static DeliveryBean of(Delivery delivery){
        DeliveryBean deliveryBean = new DeliveryBean();
        deliveryBean.setDeliveryId(delivery.getDeliveryId());
        deliveryBean.setDeliveryState(delivery.getDeliveryState().name());
        deliveryBean.setVehicleState(delivery.getVehicle().getVehicleState().name());
        deliveryBean.setVehicleLabel(delivery.getVehicle() != null ? delivery.getVehicle().getLabel() : "");
        return deliveryBean;
    }

    public String getVehicleLabel() {
        return vehicleLabel;
    }

    public void setVehicleLabel(String vehicleLabel) {
        this.vehicleLabel = vehicleLabel;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getVehicleState() {  return vehicleState;   }

    public void setVehicleState(String vehicleState) {  this.vehicleState = vehicleState;   }
}
