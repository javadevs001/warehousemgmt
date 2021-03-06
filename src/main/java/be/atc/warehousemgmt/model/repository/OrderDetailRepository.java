package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllByOrders(Orders orders);

    Optional<OrderDetail> findByOrdersAndArticleAndArchivedFalse(Orders supplierOrders, Article article);
}
