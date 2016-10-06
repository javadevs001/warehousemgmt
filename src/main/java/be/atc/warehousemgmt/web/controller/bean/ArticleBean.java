package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;
import be.atc.warehousemgmt.model.entity.box.Box;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Maximilien on 29/08/16.
 */
public class ArticleBean {

    private Long articleId;
    private String label;
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
    private Long personId;
    private String personName;
    private Long boxId;
    private String boxLabel;

    public ArticleBean() {
    }

    public static ArticleBean of(Article article) {
        ArticleBean articleBean = new ArticleBean();
        articleBean.setArchived(article.isArchived());
        articleBean.setBuyingUnitPrice(article.getBuyingUnitPrice());
        articleBean.setDepth(article.getDepth());
        articleBean.setDescription(article.getDescription());
        articleBean.setHeight(article.getHeight());
        articleBean.setLabel(article.getLabel());
        articleBean.setPackageQuantity(article.getPackageQuantity());
        articleBean.setQuantity(article.getQuantity());
        articleBean.setSellingUnitPrice(article.getSellingUnitPrice());
        articleBean.setThreshold(article.getThreshold());
        articleBean.setVolume(article.getVolume());
        articleBean.setWeight(article.getWeight());
        articleBean.setWidth(article.getWidth());
        articleBean.setArticleId(article.getArticleId());
        articleBean.setPersonId(article.getPerson().getPersonId());
        articleBean.setPersonName(article.getPerson().getCompanyName());
        articleBean.setBoxId(article.getBox().getBoxId());
        articleBean.setBoxLabel(article.getBox().getLabel());
        return articleBean;
    }

    public Article prepareForCreation(Person person , Box box) {
        Article article = new Article();
        article.setArticleId(getArticleId());
        article.setArchived(false);
        article.setWidth(getWidth());
        article.setDepth(getDepth());
        article.setHeight(getHeight());
        article.setVolume(getWidth()*getDepth()*getHeight());
        article.setWeight(getWeight());
        article.setDescription(getDescription());
        article.setLabel(getLabel());
        article.setBuyingUnitPrice(getBuyingUnitPrice());
        article.setSellingUnitPrice(getSellingUnitPrice());
        article.setPackageQuantity(getPackageQuantity());
        article.setQuantity(getQuantity());
        article.setThreshold(getThreshold());
        article.setArchived(isArchived());
        article.setPerson(person);
        article.setBox(box);
        return article;
    }
    public Article prepareForUpdate (Article article){
        article.setWidth(getWidth());
        article.setDepth(getDepth());
        article.setHeight(getHeight());
        article.setWeight(getWeight());
        article.setDescription(getDescription());
        article.setLabel(getLabel());
        article.setBuyingUnitPrice(getBuyingUnitPrice());
        article.setSellingUnitPrice(getSellingUnitPrice());
        article.setPackageQuantity(getPackageQuantity());
        article.setQuantity(getQuantity());
        article.setThreshold(getThreshold());
        article.setArchived(isArchived());
        article.setVolume(getWidth()*getDepth()*getHeight());
        return article;
    }

    public boolean isArchived() {
        return archived;
    }

    public String getPersonName() {
        return personName;
    }

    public String getBoxLabel() {
        return boxLabel;
    }

    public Long getPersonId() {
        return personId;
    }

    public Long getBoxId() {
        return boxId;
    }

    public Double getBuyingUnitPrice() {
        return buyingUnitPrice;
    }

    public Double getSellingUnitPrice() {
        return sellingUnitPrice;
    }

    public Double getDepth() {
        return depth;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getVolume() {
        return volume;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public void setBoxLabel(String boxLabel) {
        this.boxLabel = boxLabel;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setBuyingUnitPrice(Double buyingUnitPrice) {
        this.buyingUnitPrice = buyingUnitPrice;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setSellingUnitPrice(Double sellingUnitPrice) {
        this.sellingUnitPrice = sellingUnitPrice;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }



}
