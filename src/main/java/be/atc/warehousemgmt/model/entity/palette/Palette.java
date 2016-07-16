package be.atc.warehousemgmt.model.entity.palette;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Palette extends AbstractAuditingEntity {

    @Transient
    transient public static final Integer PALETTE_HEIGHT_CM = 100;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paletteId;
    @Column
    private String type;
    private Integer surface;
    private Integer paletteCount;

    public Palette() {
    }

    public Long getPaletteId() {
        return paletteId;
    }

    public void setPaletteId(Long paletteId) {
        this.paletteId = paletteId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Integer getPaletteCount() {
        return paletteCount;
    }

    public void setPaletteCount(Integer paletteCount) {
        this.paletteCount = paletteCount;
    }
}
