package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.delivery.VehicleType;
import be.atc.warehousemgmt.model.service.VehicleService;
import be.atc.warehousemgmt.web.controller.bean.VehicleBean;
import be.atc.warehousemgmt.web.controller.validator.VehicleValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by  Wéry Lionel on 16/07/16.
 */

@Controller
@RequestMapping("/VehicleController/")
public class VehicleController {

    @Inject
    private VehicleService vehicleService;
    @Inject
    private VehicleValidator vehicleValidator;

    @RequestMapping(value = "searchVehicleByLabel", method = RequestMethod.GET)
    @ResponseBody
    public String searchVehicleByLabel(@RequestParam String label) {
        Optional<Vehicle> optionalVehicleByLabel = vehicleService.getOptionalVehicleByLabel(label);
        if (optionalVehicleByLabel.isPresent()) {
            Vehicle vehicle = optionalVehicleByLabel.get();
            return String.valueOf(vehicle.getVehicleId());
        } else {
            return "Vehicule introuvable";
        }
    }

    @RequestMapping(value = "getAddVehicleForm", method = RequestMethod.GET)
    public String getAddVehicleForm(Model model) {
        VehicleBean vehicleBean = new VehicleBean();
        model.addAttribute("vehicleBean", vehicleBean);
        model.addAttribute("vehicleTypeList", vehicleService.findAllVehicleType());
        return "addVehicleForm";
    }

    @RequestMapping (value = "SaveNewVehicle", method = RequestMethod.POST)
    public String SaveNewVehicle (Model model, @ModelAttribute VehicleBean vehicleBean, BindingResult errors){
        vehicleValidator.validateNewVehicle(vehicleBean, errors);
        if(errors.hasErrors()){
            model.addAttribute("vehicleTypeList", vehicleService.findAllVehicleType());
            return "addVehicleForm";
        }
        VehicleType vehicleType = vehicleService.findVehicleTypeById(vehicleBean.getVehicleTypeId());
        vehicleService.saveVehicle(vehicleBean.prepareForCreate(vehicleType));
        return "redirect:getAddVehicleForm";
    }

    @RequestMapping (value= "VehicleTableView", method = RequestMethod.GET)
    public String getAllVehicleTable(Model model)
    {
        List<VehicleBean> vehicleBeen = vehicleService.findAllVehicle().stream().map(VehicleBean::of).collect(Collectors.toList());
        model.addAttribute("vehicles", vehicleBeen );
        return "VehicleTableView";
    }

}

