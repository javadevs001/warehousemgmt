package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleType;
import be.atc.warehousemgmt.model.repository.VehicleRepository;
import be.atc.warehousemgmt.model.repository.VehicleTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by  Wéry Lionel. on 06/08/2016
 */

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Inject
    private VehicleRepository vehicleRepository;

    @Inject
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public Optional<Vehicle> getOptionalVehicleByLabel(String label) {
        return vehicleRepository.findByLabel(label);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleType> findAllVehicleType() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public List<Vehicle> findAllVehicle(){
        return vehicleRepository.findAll();}

    @Override
    public VehicleType findVehicleTypeById(Long vehicleTypeId) {
        return vehicleTypeRepository.findOne(vehicleTypeId);
    }

    @Override
    public Vehicle findByVehicleById(Long vehicleId) {
        return vehicleRepository.findOne(vehicleId);
    }

    @Override
    public boolean exists(Long vehicleId) {
        return vehicleRepository.exists(vehicleId);
    }
}






