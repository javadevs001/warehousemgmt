package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryHasPalette;
import be.atc.warehousemgmt.model.entity.palette.Palette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 18/09/16.
 */
public interface DeliveryHasPaletteRepository extends JpaRepository<DeliveryHasPalette, Long> {

    List<DeliveryHasPalette> findByDelivery(Delivery delivery);

    Optional<DeliveryHasPalette> findByDeliveryAndPalette(Delivery delivery, Palette palette);

}
