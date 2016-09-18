package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleType;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */
public interface VehicleService {

    Optional<Vehicle> getOptionalVehicleByLabel(String label);

    Vehicle saveVehicle(Vehicle vehicle);

    List<VehicleType> findAllVehicleType();
    List<Vehicle> findAllVehicle();
    VehicleType findVehicleTypeById(Long vehicleTypeId);
}


