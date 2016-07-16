package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.service.VehicleService;
import be.atc.warehousemgmt.web.controller.bean.VehicleBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 16/07/16.
 */

@Controller
@RequestMapping("/VehicleController/")
public class VehicleController {

    @Inject
    private VehicleService vehicleService;

    @RequestMapping(value = "searchVehicleByLabel", method = RequestMethod.GET)
    @ResponseBody
    public String searchVehicleByLabel(@RequestParam String label) {
        Optional<Vehicle> optionalVehicleByLabel = vehicleService.getOptionalVehicleByLabel(label);
        if (optionalVehicleByLabel.isPresent()) {
            Vehicle vehicle = optionalVehicleByLabel.get();
            return String.valueOf(vehicle.getVehicleId());
        } else {
            return "Vehicle introuvable";
        }
    }

    @RequestMapping(value = "getAddVehicleForm", method = RequestMethod.GET)
    public String getAddVehicleForm(Model model) {
        VehicleBean vehicleBean = new VehicleBean();
        model.addAttribute("vehicleBean", vehicleBean);
        return "addVehicleForm";
    }

}
