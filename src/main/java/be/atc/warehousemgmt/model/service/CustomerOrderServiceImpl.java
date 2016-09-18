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
 * Created by Wwéry Lionel on 11/09/2016.
 */

@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Inject
    private OrdersRepository ordersRepository;
    @Inject
    private OrderDetailRepository ordersDetailRepository;

    @Override
    public Orders FindCustomerOrders(Long ordersId) {
        return ordersRepository.findOne(ordersId);
    }
    @Override
    public Orders SaveCustomerOrders(Orders orders) {
        return ordersRepository.save(orders);
    }
    @Override
    public List<OrderDetail> FindAllCustomerOrdersDetailByOrders(Orders orders) {
        return ordersDetailRepository.findAllByOrders(orders);
            }
    @Override
    public OrderDetail SaveOrderDetail(OrderDetail orderDetail) {
        return ordersDetailRepository.save(orderDetail);
    }
    @Override
    public List<Orders> getAllCustomerOrder()  {
        return ordersRepository.findAllByType(OrderType.Customer);
    }
}

