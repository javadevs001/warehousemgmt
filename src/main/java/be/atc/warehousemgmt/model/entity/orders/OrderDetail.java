package be.atc.warehousemgmt.model.entity.orders;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 9/07/16.
 */

@Entity
public class OrderDetail extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;
    @Column
    private String quantity;
    @ManyToOne
    @JoinColumn
    private Orders orders;
    @ManyToOne
    @JoinColumn
    private Article article;
    @Enumerated(EnumType.STRING)
    private OrderDetailState orderDetailState;

    public OrderDetail() {
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public OrderDetailState getOrderDetailState() {
        return orderDetailState;
    }

    public void setOrderDetailState(OrderDetailState orderDetailState) {
        this.orderDetailState = orderDetailState;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
