package be.atc.warehousemgmt.model.entity;

import be.atc.warehousemgmt.model.enums.State;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class OrderDetail extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column
    private String amount;

    @ManyToOne
    @JoinColumn
    private Order order;

    @OneToOne
    private Product product;

    public OrderDetail() {
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
