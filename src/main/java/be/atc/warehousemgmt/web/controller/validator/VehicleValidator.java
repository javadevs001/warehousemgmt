package be.atc.warehousemgmt.web.controller.validator;

import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.model.service.VehicleService;
import be.atc.warehousemgmt.web.controller.bean.VehicleBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.inject.Inject;
import javax.naming.Binding;

/**
 * Created by Wéry Lionel on 21/08/2016.
 */
@Component /** Cette annotation est importante si tu veux utiliser @Inject */
public class VehicleValidator {
    @Inject
    private VehicleService vehicleService;

    public void validateNewVehicle(VehicleBean vehicleBean, BindingResult errors){
        String label = vehicleBean.getLabel();
        if(StringUtils.isBlank(label)){
            errors.rejectValue("label", "", null, "Le nom est obligatoire");
        }else{
            if (vehicleService.getOptionalVehicleByLabel(label).isPresent()) {
                errors.rejectValue("label", "", null, "Le nom est déjà utilisé");
            }
        }

        if (vehicleBean.getVehicleTypeId() == null) {
            errors.rejectValue("vehicleTypeId", "", null, "Le type est invalide");
        }
    }


}

