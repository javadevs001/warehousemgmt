package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 16/07/16.
 */

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Inject
    private VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> getOptionalVehicleByLabel(String label) {
        return vehicleRepository.findByLabel(label);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
