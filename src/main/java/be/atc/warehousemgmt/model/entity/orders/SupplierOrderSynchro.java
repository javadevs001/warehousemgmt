package be.atc.warehousemgmt.model.entity.orders;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by ahmedidoumhaidi on 25/08/16.
 **/

@Entity
public class SupplierOrderSynchro extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierOrderSynchroId;

    private LocalDateTime synchroDateTime;
    private Long ordersId;
    private Long orderDetailId;
    private boolean merged;
    private String oldQuantity;
    private String quantity;

    public SupplierOrderSynchro() {
    }

    public Long getSupplierOrderSynchroId() {
        return supplierOrderSynchroId;
    }

    public void setSupplierOrderSynchroId(Long supplierOrderSynchroId) {
        this.supplierOrderSynchroId = supplierOrderSynchroId;
    }

    public LocalDateTime getSynchroDateTime() {
        return synchroDateTime;
    }

    public void setSynchroDateTime(LocalDateTime synchroDateTime) {
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
