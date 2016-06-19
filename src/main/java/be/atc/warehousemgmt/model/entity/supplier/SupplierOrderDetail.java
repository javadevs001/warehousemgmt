package be.atc.warehousemgmt.model.entity.supplier;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

@Entity
public class SupplierOrderDetail extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;
    @Column
    private String amount;
    @ManyToOne
    @JoinColumn
    private SupplierOrder supplierOrder;
    @ManyToOne
    @JoinColumn
    private Article article;

    public SupplierOrderDetail() {
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
