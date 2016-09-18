package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleState;
import be.atc.warehousemgmt.model.entity.palette.Palette;
import be.atc.warehousemgmt.model.service.PaletteService;
import be.atc.warehousemgmt.model.service.VehicleService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created  by  Wéry Lionel. on 06/08/2016.
 */
public class VehicleOneShote {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("DEV");
        VehicleService vehicleService = applicationContext.getBean(VehicleService.class);
        PaletteService paletteService = applicationContext.getBean(PaletteService.class);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleState(VehicleState.AVAILABLE);
        vehicle.setLabel("V2");
        vehicleService.saveVehicle(vehicle);

        Palette palette = new Palette();
        palette.setPaletteCount(100);
        palette.setSurface(120);
        palette.setType("P120");
        paletteService.savePalette(palette);

    }



}

