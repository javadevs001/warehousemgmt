package be.atc.warehousemgmt.model.entity.delivery;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.palette.Palette;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 16/07/16.
 */

@Entity
public class DeliveryHasPalette extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryHasPaletteId;

    @ManyToOne
    @JoinColumn
    private Delivery delivery;

    @ManyToOne
    @JoinColumn
    private Palette palette;

    @Column
    private Long paletteCount;

    public Long getDeliveryHasPaletteId() {
        return deliveryHasPaletteId;
    }

    public void setDeliveryHasPaletteId(Long deliveryHasPaletteId) {
        this.deliveryHasPaletteId = deliveryHasPaletteId;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public Long getPaletteCount() {
        return paletteCount;
    }

    public void setPaletteCount(Long paletteCount) {
        this.paletteCount = paletteCount;
    }
}
