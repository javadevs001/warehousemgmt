package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleType;
import be.atc.warehousemgmt.model.service.VehicleTypeService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Wéry Lionel on 08/08/2016.
 */
public class VehicleTypeOneShote {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("DEV");

        VehicleTypeService vehicleTypeService = applicationContext.getBean(VehicleTypeService.class);
        VehicleType vehicleT = new VehicleType();
        vehicleT.setLabel("Type A");
        vehicleT.setMaximumWeight(26.00);
        vehicleT.setSurface(33.976);
        vehicleT.setThreshold(23.7823);
        vehicleTypeService.SaveVehicleType(vehicleT);

        VehicleType vehicleT2 = new VehicleType();
        vehicleT2.setLabel("Type B");
        vehicleT2.setMaximumWeight(9.00);
        vehicleT2.setSurface(17.812);
        vehicleT2.setThreshold(12.4684);
        vehicleTypeService.SaveVehicleType(vehicleT2);
    }


}
