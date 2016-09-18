package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.OrderDetailState;


import java.util.List;

/**
 * Created by Wéry Lionel on 11/09/2016.
 */
public interface CustomerOrderService {
    List<Orders> getAllCustomerOrder();
    Orders FindCustomerOrders(Long ordersId);
    Orders SaveCustomerOrders (Orders orders);
    List<OrderDetail> FindAllCustomerOrdersDetailByOrders(Orders orders);
    OrderDetail SaveOrderDetail (OrderDetail orderDetail);


}





