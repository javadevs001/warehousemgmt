package be.atc.warehousemgmt.model.entity;

import be.atc.warehousemgmt.model.enums.OrderType;
import be.atc.warehousemgmt.model.enums.State;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Command extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @Column
    private String priority;
    @ManyToOne
    @JoinColumn
    private Delivery delivery;
    @ManyToOne
    @JoinColumn
    private Person person;

    public Command() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
