package be.atc.warehousemgmt.web.validator;

import be.atc.warehousemgmt.model.entity.supplier.SupplierOrderPriority;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrderState;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrderType;
import be.atc.warehousemgmt.web.bean.SupplierOrderBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

@Component
public class SupplierOrderValidator {

    public void validate(SupplierOrderBean supplierOrderBean, BindingResult errors) {

        if (supplierOrderBean.getPersonId() == null) {
            errors.rejectValue("personId", "", null, "Le choix du fournisseur est obligatoire.");
        }

        if (!validateSupplierOrderPriority(supplierOrderBean.getPriority())) {
            errors.rejectValue("priority", "", null, "Le champ priorité est invalide.");
        }

        if (!validateSupplierOrderState(supplierOrderBean.getState())) {
            errors.rejectValue("state", "", null, "Le statut de la commande est invalide.");
        }

        if (!validateSupplierOrderType(supplierOrderBean.getType())) {
            errors.rejectValue("type", "", null, "Le type de la commande est invalide.");
        }

    }

    private boolean validateSupplierOrderPriority(String priority) {
        try {
            return SupplierOrderPriority.valueOf(priority) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateSupplierOrderState(String state) {
        try {
            return SupplierOrderState.valueOf(state) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateSupplierOrderType(String type) {
        try {
            return SupplierOrderType.valueOf(type) != null;
        } catch (Exception e) {
            return false;
        }
    }

}
