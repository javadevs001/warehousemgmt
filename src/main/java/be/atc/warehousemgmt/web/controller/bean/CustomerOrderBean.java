package be.atc.warehousemgmt.web.controller.bean;

import java.time.format.DateTimeFormatter;

/**
 * Created by Vaio on 13/09/2016.
 */

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.orders.OrderPriority;
import be.atc.warehousemgmt.model.entity.orders.OrderState;
import be.atc.warehousemgmt.model.entity.orders.OrderType;
import be.atc.warehousemgmt.model.entity.orders.Orders;


public class CustomerOrderBean {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        CustomerOrderBean.formatter = formatter;
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

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
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

    private Long ordersId;
    private String state;
    private String priority;
    private String type;
    private String customerCompanyName;
    private String createdDate;
    private String createdBy;
    private String lastModifiedDate;
    private String lastModifiedBy;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    private Long personId;


    public static CustomerOrderBean of(Orders orders){

        CustomerOrderBean customerOrderBean = new CustomerOrderBean();
        customerOrderBean.setOrdersId(orders.getOrdersId());
        customerOrderBean.setPriority(orders.getPriority().name());
        customerOrderBean.setState(orders.getState().name());
        customerOrderBean.setType(orders.getType().name());
        customerOrderBean.setCustomerCompanyName(orders.getPerson().getCompanyName());
        customerOrderBean.setCreatedBy(orders.getCreatedBy());
        customerOrderBean.setLastModifiedBy(orders.getLastModifiedBy());
        customerOrderBean.setCreatedDate(orders.getCreatedDate().format(formatter));
        customerOrderBean.setLastModifiedDate(orders.getLastModifiedDate().format(formatter));
        return customerOrderBean;

    }

    public Orders prepareForCreation(Person person) {
        Orders orders = new Orders();
        orders.setPerson(person);
        orders.setPriority(OrderPriority.valueOf(getPriority()));
        orders.setType(OrderType.Customer);
        orders.setState(OrderState.TO_TREAT);
        return orders;
    }

}
