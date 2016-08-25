package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.orders.SupplierOrderSynchro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ahmedidoumhaidi on 25/08/16.
 */
public interface SupplierOrderSynchroRepository extends JpaRepository<SupplierOrderSynchro, Long> {


}
