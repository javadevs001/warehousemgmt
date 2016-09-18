package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryHasPalette;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.repository.DeliveryHasPaletteRepository;
import be.atc.warehousemgmt.model.repository.DeliveryRepository;
import be.atc.warehousemgmt.model.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Inject
    private DeliveryRepository deliveryRepository;
    @Inject
    private DeliveryHasPaletteRepository deliveryHasPaletteRepository;
    @Inject
    private OrdersRepository ordersRepository;

    @Override
    public List<Delivery> findAllDelivery() {
        return deliveryRepository.findAll();
    }


    @Override
    public Delivery addNewDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery findById(Long deliveryId){
        return deliveryRepository.findOne(deliveryId);
    }

    @Override
    public boolean exists(Long deliveryId) {
        return deliveryRepository.exists(deliveryId);
    }

    @Override
    public void deleteDelivery(Delivery delivery) {
        List<DeliveryHasPalette> byDelivery = deliveryHasPaletteRepository.findByDelivery(delivery);
        byDelivery.stream().forEach((d) -> {
            deliveryHasPaletteRepository.delete(d);
        });
        Orders byDelivery1 = ordersRepository.findByDelivery(delivery);
        byDelivery1.setDelivery(null);
        ordersRepository.save(byDelivery1);
        deliveryRepository.delete(delivery);
    }
}
