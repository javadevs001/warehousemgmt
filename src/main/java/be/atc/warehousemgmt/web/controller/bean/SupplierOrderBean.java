package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.orders.OrderPriority;
import be.atc.warehousemgmt.model.entity.orders.OrderState;
import be.atc.warehousemgmt.model.entity.orders.OrderType;
import be.atc.warehousemgmt.model.entity.orders.Orders;

import java.time.format.DateTimeFormatter;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public class SupplierOrderBean {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long ordersId;
    private String state;
    private String priority;
    private String type;
    private String supplierCompanyName;
    private String createdDate;
    private String createdBy;
    private String lastModifiedDate;
    private String lastModifiedBy;
    private Long personId;
    private boolean updateCase;

    public static SupplierOrderBean of(Orders orders) {
        SupplierOrderBean supplierOrderBean = new SupplierOrderBean();
        supplierOrderBean.setOrdersId(orders.getOrdersId());
        supplierOrderBean.setPriority(orders.getPriority().name());
        supplierOrderBean.setState(orders.getState().name());
        supplierOrderBean.setType(orders.getType().name());
        supplierOrderBean.setSupplierCompanyName(orders.getPerson().getCompanyName());
        supplierOrderBean.setCreatedBy(orders.getCreatedBy());
        supplierOrderBean.setLastModifiedBy(orders.getLastModifiedBy());
        supplierOrderBean.setCreatedDate(orders.getCreatedDate().format(formatter));
        supplierOrderBean.setLastModifiedDate(orders.getLastModifiedDate().format(formatter));
        supplierOrderBean.setPersonId(orders.getPerson() != null ? orders.getPerson().getPersonId() : null);
        return supplierOrderBean;
    }

    public Orders prepareForCreation(Person person) {
        Orders orders = new Orders();
        orders.setPerson(person);
        orders.setPriority(OrderPriority.valueOf(getPriority()));
        orders.setType(OrderType.Supplier);
        orders.setState(OrderState.TO_TREAT);
        return orders;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public boolean isUpdateCase() {
        return updateCase;
    }

    public void setUpdateCase(boolean updateCase) {
        this.updateCase = updateCase;
    }
}
