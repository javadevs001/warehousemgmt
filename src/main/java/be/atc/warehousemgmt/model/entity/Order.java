package be.atc.warehousemgmt.model.entity;

import be.atc.warehousemgmt.model.enums.OrderType;
import be.atc.warehousemgmt.model.enums.State;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Order extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private String priority;

    @ManyToOne
    @JoinColumn
    private Delivery delivery;

    @ManyToOne
    private Person person;

    public Order() {
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


}
