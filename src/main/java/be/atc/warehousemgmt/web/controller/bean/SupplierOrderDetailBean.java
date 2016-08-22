package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.OrderDetailState;
import be.atc.warehousemgmt.model.entity.orders.Orders;

import java.time.format.DateTimeFormatter;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
public class SupplierOrderDetailBean {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long supplierOrderDetailId;
    private Long supplierOrderId;
    private String quantity;
    private Long article;
    private String state;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    private String articleLabel;
    private boolean updateCase;

    public SupplierOrderDetailBean() {
    }

    public static SupplierOrderDetailBean of(OrderDetail orderDetail) {
        SupplierOrderDetailBean supplierOrderDetailBean = new SupplierOrderDetailBean();
        supplierOrderDetailBean.setSupplierOrderId(orderDetail.getOrders().getOrdersId());
        supplierOrderDetailBean.setArticle(orderDetail.getArticle().getArticleId());
        supplierOrderDetailBean.setQuantity(orderDetail.getQuantity());
        supplierOrderDetailBean.setSupplierOrderDetailId(orderDetail.getOrderDetailId());
        supplierOrderDetailBean.setState(orderDetail.getOrderDetailState() != null ? orderDetail.getOrderDetailState().name() : "");
        supplierOrderDetailBean.setCreatedDate(orderDetail.getCreatedDate().format(formatter));
        supplierOrderDetailBean.setUpdatedDate(orderDetail.getLastModifiedDate().format(formatter));
        supplierOrderDetailBean.setCreatedBy(orderDetail.getCreatedBy());
        supplierOrderDetailBean.setUpdatedBy(orderDetail.getLastModifiedBy());
        supplierOrderDetailBean.setArticleLabel(orderDetail.getArticle().getLabel());
        return supplierOrderDetailBean;
    }

    public OrderDetail prepareForCreation(Article article, Orders orders) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrders(orders);
        orderDetail.setArticle(article);
        orderDetail.setQuantity(getQuantity());
        orderDetail.setOrderDetailState(OrderDetailState.WAIT_FOR_STOCK);
        return orderDetail;
    }

    public OrderDetail prepareForUpdate(OrderDetail supplierOrderDetail) {
        supplierOrderDetail.setQuantity(getQuantity());
        return supplierOrderDetail;
    }

    public Long getSupplierOrderDetailId() {
        return supplierOrderDetailId;
    }

    public void setSupplierOrderDetailId(Long supplierOrderDetailId) {
        this.supplierOrderDetailId = supplierOrderDetailId;
    }

    public Long getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(Long supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
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

    public String getArticleLabel() {
        return articleLabel;
    }

    public void setArticleLabel(String articleLabel) {
        this.articleLabel = articleLabel;
    }

    public boolean isUpdateCase() {
        return updateCase;
    }

    public void setUpdateCase(boolean updateCase) {
        this.updateCase = updateCase;
    }
}
