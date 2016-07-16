package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface SupplierOrderService {

    List<Orders> getAllSupplierOrders();

    Orders saveSupplierOrder(Orders orders);

    Orders findSupplierOrders(Long ordersId);

    OrderDetail saveSupplierOrdersDetail(OrderDetail orderDetail);

    List<OrderDetail> findAllSupplierOrderDetailBySupplierOrder(Orders orders);
}
