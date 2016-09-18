package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.delivery.*;
import be.atc.warehousemgmt.model.service.DeliveryService;
import be.atc.warehousemgmt.model.service.VehicleService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by  Wéry Lionel. on 06/08/2016.
 */
public class DeliveryOneShot {

    public static void main(String[] args) {
        AbstractApplicationContext context = OneShotConfig.initApplicationContextFromEnvironment("DEV");

        DeliveryService deliveryService = context.getBean(DeliveryService.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);

        /**Vehicle vehicle = new Vehicle();
        vehicle.setLabel("Camion X12");
        vehicle.setVehicleState(VehicleState.AVAILABLE);
        vehicle = vehicleService.saveVehicle(vehicle);

        Delivery delivery = new Delivery();
        delivery.setDeliveryState(DeliveryState.DELIVERED);
        delivery.setVehicle(vehicle);
        deliveryService.addNewDelivdery(delivery); **/

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setLabel("Camion X01");
        vehicle1.setVehicleState(VehicleState.UNAVAILABLE);
        /*vehicle1.setVehicleType();*/
        vehicle1 = vehicleService.saveVehicle(vehicle1);






    }

}
