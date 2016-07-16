package be.atc.warehousemgmt.model.entity.catalog;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.box.Box;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Article extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;

    @Column(unique = true, nullable = false)
    private String label;
    @Column
    private Double buyingUnitPrice;
    private Double sellingUnitPrice;
    private Integer packageQuantity;
    private Integer threshold; /* Seuil */
    private Integer quantity; /* La quantité dans la ZONE (IN & STOCK) */
    private Double depth;
    private Double width;
    private Double height;
    private Double weight;
    private String description;
    private Double volume;
    private boolean archived;

    @ManyToOne
    private Person person;
    @ManyToOne
    @JoinColumn
    private Box box;

    public Article() {
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getBuyingUnitPrice() {
        return buyingUnitPrice;
    }

    public void setBuyingUnitPrice(Double buyingUnitPrice) {
        this.buyingUnitPrice = buyingUnitPrice;
    }

    public Double getSellingUnitPrice() {
        return sellingUnitPrice;
    }

    public void setSellingUnitPrice(Double sellingUnitPrice) {
        this.sellingUnitPrice = sellingUnitPrice;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
