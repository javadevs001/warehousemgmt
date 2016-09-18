package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.delivery.VehicleType;
import be.atc.warehousemgmt.model.repository.VehicleTypeRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wéry Lionel on 08/08/2016.
 */

@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeService {


    @Inject
        private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public Optional<VehicleType> getOptionalVehicleTypeByLabel(String label) {
        return vehicleTypeRepository.findByLabel(label);
    }

    @Override
    public List<VehicleType> findAllVehicleType(){
        return vehicleTypeRepository.findAll();
    }

    @Override
    public VehicleType SaveVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }
}
