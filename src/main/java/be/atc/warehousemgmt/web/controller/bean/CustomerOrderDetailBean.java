package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;

import java.time.format.DateTimeFormatter;

/**
 * Created by Vaio on 13/09/2016.
 */
public class CustomerOrderDetailBean {


    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long customerOrderDetailId;
    private Long customerOrderId;
    private String quantity;
    private Long article;
    private String state;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    private String articleLabel;

public CustomerOrderDetailBean() {}

    public static CustomerOrderDetailBean of(OrderDetail orderDetail) {
        CustomerOrderDetailBean customerOrderDetailBean = new CustomerOrderDetailBean();
        customerOrderDetailBean.setCustomerOrderId(orderDetail.getOrders().getOrdersId());
        customerOrderDetailBean.setArticle(orderDetail.getArticle().getArticleId());
        customerOrderDetailBean.setQuantity(orderDetail.getQuantity());
        customerOrderDetailBean.setCustomerOrderDetailId(orderDetail.getOrderDetailId());
        customerOrderDetailBean.setState(orderDetail.getOrderDetailState() != null ? orderDetail.getOrderDetailState().name() : "");
        customerOrderDetailBean.setCreatedDate(orderDetail.getCreatedDate().format(formatter));
        customerOrderDetailBean.setUpdatedDate(orderDetail.getLastModifiedDate().format(formatter));
        customerOrderDetailBean.setCreatedBy(orderDetail.getCreatedBy());
        customerOrderDetailBean.setUpdatedBy(orderDetail.getLastModifiedBy());
        customerOrderDetailBean.setArticleLabel(orderDetail.getArticle().getLabel());
        return customerOrderDetailBean;
    }


    public OrderDetail prepareForCreation(Article article, Orders orders) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrders(orders);
        orderDetail.setArticle(article);
        orderDetail.setQuantity(getQuantity());
        return orderDetail;
    }


    public String getArticleLabel() {
        return articleLabel;
    }

    public void setArticleLabel(String articleLabel) {
        this.articleLabel = articleLabel;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public Long getCustomerOrderDetailId() {
        return customerOrderDetailId;
    }

    public void setCustomerOrderDetailId(Long customerOrderDetailId) {
        this.customerOrderDetailId = customerOrderDetailId;
    }

    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }




}
