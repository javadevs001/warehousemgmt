package be.atc.warehousemgmt.model.entity.orders;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 9/07/16.
 */
@Entity
public class SupplierOrderDetail extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierOrderDetailId;

    @ManyToOne
    @JoinColumn
    private Article article;
    @Column
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private SupplierOrderDetailType supplierOrderDetailType;

    public SupplierOrderDetail() {
    }

    public Long getSupplierOrderDetailId() {
        return supplierOrderDetailId;
    }

    public void setSupplierOrderDetailId(Long supplierOrderDetailId) {
        this.supplierOrderDetailId = supplierOrderDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public SupplierOrderDetailType getSupplierOrderDetailType() {
        return supplierOrderDetailType;
    }

    public void setSupplierOrderDetailType(SupplierOrderDetailType supplierOrderDetailType) {
        this.supplierOrderDetailType = supplierOrderDetailType;
    }
}
