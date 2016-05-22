package be.atc.warehousemgmt.model.entity;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Product extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @OneToOne
    private Location location;

    @ManyToOne
    @JoinColumn
    private Article article;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
