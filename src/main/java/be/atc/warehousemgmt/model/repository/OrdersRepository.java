package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.orders.OrderType;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByType(OrderType supplier);
}