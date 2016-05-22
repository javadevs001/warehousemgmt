package be.atc.warehousemgmt.model.entity;

import javax.persistence.*;

/**
 * Created by ahmedidoumhaidi on 22/05/16.
 */

@Entity
public class Delivery extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @ManyToOne
    @JoinColumn
    private Person person;

    @ManyToOne
    @JoinColumn
    private Vehicle vehicle;


}
