package be.atc.warehousemgmt.model.entity.supplier;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.person.Person;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

@Entity
public class SupplierOrder extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierOrderId;

    @Enumerated(EnumType.STRING)
    private SupplierOrderState state; /* NEW,PENDING,DONE,CANCELED */
    @Enumerated(EnumType.STRING)
    private SupplierOrderPriority priority; /* LOW,MEDIUM,HIGH */
    @Enumerated(EnumType.STRING)
    private SupplierOrderType type; /* Regular,Threshold,Exceptional */

    @ManyToOne
    @JoinColumn
    private Person person; /* Supplier */

    public SupplierOrder() {
    }

    public Long getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(Long supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public SupplierOrderState getState() {
        return state;
    }

    public void setState(SupplierOrderState state) {
        this.state = state;
    }

    public SupplierOrderPriority getPriority() {
        return priority;
    }

    public void setPriority(SupplierOrderPriority priority) {
        this.priority = priority;
    }

    public SupplierOrderType getType() {
        return type;
    }

    public void setType(SupplierOrderType type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
