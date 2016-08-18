package be.atc.warehousemgmt.web.controller.bean;

/**
 * Created by mikelcromphoudt on 18/08/16.
 */
public class OrderDetailStatusBean {

    private Long orderDetailIdModal;
    private String orderDetailState;

    public Long getOrderDetailIdModal() {
        return orderDetailIdModal;
    }

    public void setOrderDetailIdModal(Long orderDetailIdModal) {
        this.orderDetailIdModal = orderDetailIdModal;
    }

    public String getOrderDetailState() {
        return orderDetailState;
    }

    public void setOrderDetailState(String orderDetailState) {
        this.orderDetailState = orderDetailState;
    }
}
