package be.atc.warehousemgmt.model.entity.orders;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.delivery.Delivery;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 9/07/16.
 */

@Entity
public class Orders extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordersId;

    @ManyToOne
    @JoinColumn
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Enumerated(EnumType.STRING)
    private OrderPriority priority;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @ManyToOne
    @JoinColumn
    private Person person;

    @Column
    private boolean archived;

    public Orders() {
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public OrderPriority getPriority() {
        return priority;
    }

    public void setPriority(OrderPriority priority) {
        this.priority = priority;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
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
}
