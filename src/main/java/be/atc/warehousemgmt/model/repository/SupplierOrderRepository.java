package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.supplier.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Long> {
}
