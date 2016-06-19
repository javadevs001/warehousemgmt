package be.atc.warehousemgmt.web.bean;

import be.atc.warehousemgmt.model.entity.person.Person;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrder;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrderPriority;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrderState;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrderType;

import java.time.format.DateTimeFormatter;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

public class SupplierOrderBean {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private Long supplierOrderId;
    private String state;
    private String type;
    private String priority;
    private Long personId;
    private String personFullName;

    public SupplierOrderBean() {
    }

    public static SupplierOrderBean from(SupplierOrder supplierOrder) {
        SupplierOrderBean supplierOrderBean = new SupplierOrderBean();
        supplierOrderBean.setSupplierOrderId(supplierOrder.getSupplierOrderId());
        supplierOrderBean.setCreatedBy(supplierOrder.getCreatedBy());
        supplierOrderBean.setCreatedDate(supplierOrder.getCreatedDate().format(dateTimeFormatter));
        supplierOrderBean.setUpdatedDate(supplierOrder.getLastModifiedDate().format(dateTimeFormatter));
        supplierOrderBean.setType(supplierOrder.getType().name());
        supplierOrderBean.setPriority(supplierOrder.getPriority().name());
        supplierOrderBean.setState(supplierOrder.getState().name());
        /* Supplier infos */
        Person person = supplierOrder.getPerson();
        supplierOrderBean.setPersonId(person.getPersonId());
        supplierOrderBean.setPersonFullName(person.getFirstName() + person.getLastName());
        return supplierOrderBean;
    }

    public SupplierOrder prepareForCreation(Person person) {
        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setPerson(person);
        supplierOrder.setType(SupplierOrderType.valueOf(getType()));
        supplierOrder.setPriority(SupplierOrderPriority.valueOf(getPriority()));
        supplierOrder.setState(SupplierOrderState.valueOf(getState()));
        return supplierOrder;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(Long supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonFullName() {
        return personFullName;
    }

    public void setPersonFullName(String personFullName) {
        this.personFullName = personFullName;
    }
}
