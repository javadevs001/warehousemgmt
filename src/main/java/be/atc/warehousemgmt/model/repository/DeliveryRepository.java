package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

    List<Delivery> findAllByDeliveryState(DeliveryState deliveryState);

}
