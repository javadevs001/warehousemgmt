package be.atc.warehousemgmt.model.entity.palette;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.customer.CustomerOrder;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Palette extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paletteId;

    @ManyToOne
    @JoinColumn
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn
    private CustomerOrder customerOrder;
    @ManyToOne
    @JoinColumn
    private PaletteType paletteType;

    public Palette() {
    }

    public Long getPaletteId() {
        return paletteId;
    }

    public void setPaletteId(Long paletteId) {
        this.paletteId = paletteId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public PaletteType getPaletteType() {
        return paletteType;
    }

    public void setPaletteType(PaletteType paletteType) {
        this.paletteType = paletteType;
    }
}
