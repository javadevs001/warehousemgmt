package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryHasPalette;
import be.atc.warehousemgmt.model.repository.DeliveryRepository;
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
}
