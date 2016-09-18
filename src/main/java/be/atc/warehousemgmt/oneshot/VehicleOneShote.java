package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleState;
import be.atc.warehousemgmt.model.entity.delivery.VehicleType;
import be.atc.warehousemgmt.model.service.VehicleService;
import be.atc.warehousemgmt.model.service.VehicleTypeService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created  by  Wéry Lionel. on 06/08/2016.
 */
public class VehicleOneShote {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("DEV");
        VehicleService vehicleService = applicationContext.getBean(VehicleService.class);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleState(VehicleState.AVAILABLE);
        vehicle.setLabel("test");
        vehicleService.saveVehicle(vehicle);

    }



}

