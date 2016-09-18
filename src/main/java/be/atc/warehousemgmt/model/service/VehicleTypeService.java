package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.VehicleType;

import java.util.List;
import java.util.Optional;

/**
 * Created by Wéry Lionel on 08/08/2016.
 */
public interface VehicleTypeService {

    Optional<VehicleType> getOptionalVehicleTypeByLabel(String label);
    VehicleType SaveVehicleType(VehicleType vehicleType);
    List<VehicleType> findAllVehicleType();

}
