package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderSynchro;

import java.util.List;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface SupplierOrderService {

    List<Orders> getAllSupplierOrders();

    Orders saveSupplierOrder(Orders orders);

    Orders findSupplierOrders(Long ordersId);

    OrderDetail findSupplierOrderDetailById(Long orderDetailId);

    OrderDetail saveSupplierOrdersDetail(OrderDetail orderDetail);

    List<OrderDetail> findAllSupplierOrderDetailBySupplierOrder(Orders orders);

    Optional<OrderDetail> findOrderDetailByOrdersAndArticle(Orders supplierOrders, Article article);

    boolean supplierOrderDetailExist(Long supplierOrderDetailId);

    void deleteOrderDetail(OrderDetail orderDetail);

    boolean supplierOrderExist(Long supplierOrderId);

    void deleteSupplierOrder(Orders supplierOrders);

    void addSupplierOrdersFromSupplierOrderDetailSynchro();

    void saveTheSupplierOrderSynchro(Orders orders, OrderDetail orderDetail, String oldQuantity, String quantityToSet, boolean merged);

    List<SupplierOrderSynchro> getAllSupplierOrdersSynchronized();
}
