package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;

import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 16/07/16.
 */
public interface VehicleService {

    Optional<Vehicle> getOptionalVehicleByLabel(String label);

    Vehicle saveVehicle(Vehicle vehicle);

}
