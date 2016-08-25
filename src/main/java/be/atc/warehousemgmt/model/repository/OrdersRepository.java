package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.orders.OrderState;
import be.atc.warehousemgmt.model.entity.orders.OrderType;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByType(@Param("supplier") OrderType supplier);

    List<Orders> findByPersonAndStateOrderByCreatedDateDesc(Person person, OrderState orderState);
}
