package be.atc.warehousemgmt.model.entity.location;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Location extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @Column(nullable = false, unique = true)
    private String reference;
    @Enumerated(EnumType.STRING)
    private LocationState state; /* EMPTY OR ASSIGNED */
    @Enumerated(EnumType.STRING)
    private Zone zone;
    @Column
    private String locationType;

    @ManyToOne
    @JoinColumn
    private Article article;
    @Column
    private Integer articleQuantity;
    private boolean completed; /* L'emplacement est rempli */
    private Integer articleQuantityAvailableToStore; /* Le nombre d'article qu'on peut encore mettre dans cette emplacement */

    private Location() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public LocationState getState() {
        return state;
    }

    public void setState(LocationState state) {
        this.state = state;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(Integer articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Integer getArticleQuantityAvailableToStore() {
        return articleQuantityAvailableToStore;
    }

    public void setArticleQuantityAvailableToStore(Integer articleQuantityAvailableToStore) {
        this.articleQuantityAvailableToStore = articleQuantityAvailableToStore;
    }
}
