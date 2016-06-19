package be.atc.warehousemgmt.model.entity.customer;

import be.atc.warehousemgmt.model.entity.AbstractAuditingEntity;
import be.atc.warehousemgmt.model.entity.catalog.Product;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class CustomerOrderDetail extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerOrderDetailId;
    @Column
    private String state;
    private String amount;
    @ManyToOne
    @JoinColumn
    private CustomerOrder customerOrder;
    @OneToOne
    private Product product;

    public CustomerOrderDetail() {
    }

    public Long getCustomerOrderDetailId() {
        return customerOrderDetailId;
    }

    public void setCustomerOrderDetailId(Long customerOrderDetailId) {
        this.customerOrderDetailId = customerOrderDetailId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
