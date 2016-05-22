package be.atc.warehousemgmt.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class BoxType extends AbstractAuditingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boxTypeId;


    private Integer height;
    private Integer width;
    private Integer length;

    public BoxType() {
    }

    public Long getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Long boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
