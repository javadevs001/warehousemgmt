package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.orders.Orders;

/**
 * Created by mikelcromphoudt on 25/08/16.
 */
public class CheckSupplierOrderBean {

    private Long ordersId;
    private String state;

    public CheckSupplierOrderBean() {

    }

    public static CheckSupplierOrderBean of(Orders orders) {
        CheckSupplierOrderBean checkSupplierOrderBean = new CheckSupplierOrderBean();
        checkSupplierOrderBean.setOrdersId(orders.getOrdersId());
        checkSupplierOrderBean.setState(orders.getState() != null ? orders.getState().name() : "");
        return checkSupplierOrderBean;
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
}
