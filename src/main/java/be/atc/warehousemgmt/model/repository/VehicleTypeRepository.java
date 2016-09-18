package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.delivery.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Wéry Lionel on 08/08/2016.
 */
public interface VehicleTypeRepository extends JpaRepository<VehicleType,Long>{

    Optional<VehicleType> findByLabel(String label);


}
