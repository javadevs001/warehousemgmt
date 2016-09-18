package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryHasPalette;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryState;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.entity.palette.Palette;

import java.util.List;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */
public class DeliveryBean {

    private Long deliveryId;
    private String deliveryState;
    private Long vehicleId;
    private Long orderId;
    private Long paletteId;
    private Long paletteCount;
    private String vehicleLabel;
    private String vehicleState;

    public DeliveryBean() {}

    public static DeliveryBean of(Delivery delivery){
        DeliveryBean deliveryBean = new DeliveryBean();
        deliveryBean.setDeliveryId(delivery.getDeliveryId());
        deliveryBean.setDeliveryState(delivery.getDeliveryState().name());
        if (delivery.getVehicle() != null) {
            deliveryBean.setVehicleState(delivery.getVehicle().getVehicleState().name());
            deliveryBean.setVehicleLabel(delivery.getVehicle().getLabel());
        }
        return deliveryBean;
    }

    public static DeliveryBean of(Delivery delivery, List<DeliveryHasPalette> deliveryHasPalettes, Orders orders) {
        DeliveryBean deliveryBean = new DeliveryBean();
        deliveryBean.setDeliveryId(delivery.getDeliveryId());
        deliveryBean.setDeliveryState(delivery.getDeliveryState().name());
        if (delivery.getVehicle() != null) {
            deliveryBean.setVehicleState(delivery.getVehicle().getVehicleState().name());
            deliveryBean.setVehicleLabel(delivery.getVehicle().getLabel());
            deliveryBean.setVehicleId(delivery.getVehicle().getVehicleId());
        }

        if (!deliveryHasPalettes.isEmpty()) {
            DeliveryHasPalette deliveryHasPalette = deliveryHasPalettes.get(0);
            Palette palette = deliveryHasPalette.getPalette();
            deliveryBean.setPaletteId(palette.getPaletteId());
            deliveryBean.setPaletteCount(deliveryHasPalette.getPaletteCount());
        }

        deliveryBean.setOrderId(orders.getOrdersId());
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPaletteId() {
        return paletteId;
    }

    public void setPaletteId(Long paletteId) {
        this.paletteId = paletteId;
    }

    public Long getPaletteCount() {
        return paletteCount;
    }

    public void setPaletteCount(Long paletteCount) {
        this.paletteCount = paletteCount;
    }

    public Delivery prepareForCreation(Vehicle vehicle) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryState(DeliveryState.valueOf(getDeliveryState()));
        delivery.setVehicle(vehicle);
        return delivery;
    }

    public Delivery prepareForUpdate(Delivery delivery, Vehicle vehicle) {
        delivery.setVehicle(vehicle);
        delivery.setDeliveryState(DeliveryState.valueOf(getDeliveryState()));
        return delivery;
    }
}
