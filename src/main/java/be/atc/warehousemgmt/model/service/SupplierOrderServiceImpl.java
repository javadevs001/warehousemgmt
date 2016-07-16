package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.OrderType;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.repository.OrderDetailRepository;
import be.atc.warehousemgmt.model.repository.OrdersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 **/

@Service
@Transactional
public class SupplierOrderServiceImpl implements SupplierOrderService {

    @Inject
    private OrdersRepository ordersRepository;
    @Inject
    private OrderDetailRepository orderDetailRepository;


    @Override
    public List<Orders> getAllSupplierOrders() {
        return ordersRepository.findAllByType(OrderType.Supplier);
    }

    @Override
    public Orders saveSupplierOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders findSupplierOrders(Long ordersId) {
        return ordersRepository.findOne(ordersId);
    }

    @Override
    public OrderDetail saveSupplierOrdersDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findAllSupplierOrderDetailBySupplierOrder(Orders orders) {
        return orderDetailRepository.findAllByOrders(orders);
    }
}
