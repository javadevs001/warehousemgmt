package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;

import java.util.List;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */
public interface DeliveryService {
    List<Delivery> findAllDelivery();
    Delivery addNewDelivery(Delivery delivery);
    Delivery findById(Long deliveryId);

    boolean exists(Long deliveryId);

    void deleteDelivery(Delivery delivery);

}
