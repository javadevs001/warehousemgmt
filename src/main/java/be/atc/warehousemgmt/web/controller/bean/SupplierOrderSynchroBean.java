package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.orders.SupplierOrderSynchro;

import java.time.format.DateTimeFormatter;

/**
 * @author ahmedidoumhaidi
 * @since 11/09/16.
 */

public class SupplierOrderSynchroBean {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long supplierOrderSynchroId;
    private String synchroDateTime;
    private Long ordersId;
    private Long orderDetailId;
    private boolean merged;
    private String oldQuantity;
    private String quantity;

    public SupplierOrderSynchroBean() {
    }

    public static SupplierOrderSynchroBean of(SupplierOrderSynchro supplierOrderSynchro) {
        SupplierOrderSynchroBean supplierOrderSynchroBean = new SupplierOrderSynchroBean();
        supplierOrderSynchroBean.setSupplierOrderSynchroId(supplierOrderSynchro.getSupplierOrderSynchroId());
        supplierOrderSynchroBean.setMerged(supplierOrderSynchro.isMerged());
        supplierOrderSynchroBean.setOldQuantity(supplierOrderSynchro.getOldQuantity());
        supplierOrderSynchroBean.setQuantity(supplierOrderSynchro.getQuantity());
        supplierOrderSynchroBean.setSynchroDateTime(supplierOrderSynchro.getSynchroDateTime().format(formatter));
        supplierOrderSynchroBean.setOrderDetailId(supplierOrderSynchro.getOrderDetailId());
        supplierOrderSynchroBean.setOrdersId(supplierOrderSynchro.getOrdersId());
        return supplierOrderSynchroBean;
    }

    public Long getSupplierOrderSynchroId() {
        return supplierOrderSynchroId;
    }

    public void setSupplierOrderSynchroId(Long supplierOrderSynchroId) {
        this.supplierOrderSynchroId = supplierOrderSynchroId;
    }

    public String getSynchroDateTime() {
        return synchroDateTime;
    }

    public void setSynchroDateTime(String synchroDateTime) {
        this.synchroDateTime = synchroDateTime;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    public String getOldQuantity() {
        return oldQuantity;
    }

    public void setOldQuantity(String oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
