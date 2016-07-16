package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 16/07/16.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByLabel(String label);
}
