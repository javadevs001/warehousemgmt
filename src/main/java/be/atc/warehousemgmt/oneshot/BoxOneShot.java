package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.box.Box;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleState;
import be.atc.warehousemgmt.model.repository.BoxRepository;
import be.atc.warehousemgmt.model.service.VehicleService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Maximilien on 18/09/16.
 */
public class BoxOneShot {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("DEV");
        BoxRepository boxRepository = applicationContext.getBean(BoxRepository.class);

        Box box = new Box();
        box.setLabel("box A");
        Box box1 = new Box();
        box1.setLabel("box B");
        Box box2 = new Box();
        box2.setLabel("box C");
        boxRepository.save(box);
        boxRepository.save(box1);
        boxRepository.save(box2);
    }
}
