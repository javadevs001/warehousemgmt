package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Wéry Lionel. on 06/08/2016
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByLabel(String label);

    List<Vehicle> findAllByVehicleState(VehicleState vehicleState);
  // @Query("SELECT v FROM Vehicle v where v.vehicleId = ?1");
   // Vehicle findById(Long id);


}


