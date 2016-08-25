package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.*;
import be.atc.warehousemgmt.model.repository.OrderDetailRepository;
import be.atc.warehousemgmt.model.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 **/

@Service
@Transactional
public class SupplierOrderServiceImpl implements SupplierOrderService {

    private static Logger logger = LoggerFactory.getLogger(SupplierOrderServiceImpl.class);

    @Inject
    private OrdersRepository ordersRepository;
    @Inject
    private OrderDetailRepository orderDetailRepository;
    @Inject
    private SupplierOrderDetailService supplierOrderDetailService;

    @Scheduled(cron = "0 0 19 1/1 * ?") /* Utiliser le site http://www.cronmaker.com/ pour générer vos CRON */
    public void addSupplierOrdersFromSupplierOrderDetailSynchro() {
        List<SupplierOrderDetail> supplierOrderDetails = supplierOrderDetailService.getAll();
        logger.warn("Start new addSupplierOrdersFromSupplierOrderDetailSynchro with supplierOrderDetails size : " + supplierOrderDetails.size());
        for (SupplierOrderDetail supplierOrderDetail : supplierOrderDetails) {
            Article article = supplierOrderDetail.getArticle();
            Person person = article.getPerson();
            List<Orders> orders = ordersRepository.findByPersonAndStateOrderByCreatedDateDesc(person, OrderState.TO_TREAT);
            if (!orders.isEmpty()) {
                Orders order = orders.get(0);
                Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findByOrdersAndArticle(order, article);
                if (orderDetailOptional.isPresent()) {
                    OrderDetail orderDetail = orderDetailOptional.get();
                    Integer quantityToSet = Integer.valueOf(orderDetail.getQuantity()) + supplierOrderDetail.getQuantity();
                    orderDetail.setQuantity(quantityToSet.toString());
                    orderDetailRepository.save(orderDetail);
                } else {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setQuantity(supplierOrderDetail.getQuantity().toString());
                    orderDetail.setOrderDetailState(OrderDetailState.WAIT_FOR_STOCK);
                    orderDetail.setOrders(order);
                    orderDetailRepository.save(orderDetail);
                }
            } else {
                Orders ordersToSave = new Orders();
                ordersToSave.setState(OrderState.TO_TREAT);
                ordersToSave.setPriority(OrderPriority.Regular);
                ordersToSave.setPerson(person);
                ordersToSave.setType(OrderType.Supplier);
                ordersToSave = ordersRepository.save(ordersToSave);

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrders(ordersToSave);
                orderDetail.setArticle(article);
                orderDetail.setQuantity(supplierOrderDetail.getQuantity().toString());
                orderDetail.setOrderDetailState(OrderDetailState.WAIT_FOR_STOCK);
                orderDetailRepository.save(orderDetail);
            }
        }

        for (SupplierOrderDetail supplierOrderDetail : supplierOrderDetails) {
            supplierOrderDetailService.delete(supplierOrderDetail);
        }

        logger.warn("End of addSupplierOrdersFromSupplierOrderDetailSynchro with supplierOrderDetails size : " + supplierOrderDetails.size());
    }

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
    public OrderDetail findSupplierOrderDetailById(Long orderDetailId) {
        return orderDetailRepository.findOne(orderDetailId);
    }

    @Override
    public OrderDetail saveSupplierOrdersDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findAllSupplierOrderDetailBySupplierOrder(Orders orders) {
        return orderDetailRepository.findAllByOrders(orders);
    }

    @Override
    public Optional<OrderDetail> findOrderDetailByOrdersAndArticle(Orders supplierOrders, Article article) {
        return orderDetailRepository.findByOrdersAndArticle(supplierOrders, article);
    }

    @Override
    public boolean supplierOrderDetailExist(Long supplierOrderDetailId) {
        return orderDetailRepository.exists(supplierOrderDetailId);
    }


    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.delete(orderDetail);
    }

    @Override
    public boolean supplierOrderExist(Long supplierOrderId) {
        return ordersRepository.exists(supplierOrderId);
    }

    @Override
    public void deleteSupplierOrder(Orders supplierOrders) {
        ordersRepository.delete(supplierOrders);
    }
}
