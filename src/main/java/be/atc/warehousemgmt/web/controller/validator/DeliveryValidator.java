package be.atc.warehousemgmt.web.controller.validator;

import be.atc.warehousemgmt.model.entity.delivery.DeliveryState;
import be.atc.warehousemgmt.model.repository.OrdersRepository;
import be.atc.warehousemgmt.model.service.PaletteService;
import be.atc.warehousemgmt.model.service.VehicleService;
import be.atc.warehousemgmt.web.controller.bean.DeliveryBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.inject.Inject;

/**
 * Created by ahmedidoumhaidi on 18/09/16.
 */
@Component
public class DeliveryValidator {

    @Inject
    private PaletteService paletteService;
    @Inject
    private VehicleService vehicleService;
    @Inject
    private OrdersRepository ordersRepository;

    public void validateDelivery(DeliveryBean deliveryBean, BindingResult errors) {

        Long paletteId = deliveryBean.getPaletteId();
        Long vehicleId = deliveryBean.getVehicleId();
        Long paletteCount = deliveryBean.getPaletteCount();
        Long orderId = deliveryBean.getOrderId();
        String deliveryState = deliveryBean.getDeliveryState();

        if (!validateDeliveryState(deliveryState)) {
            errors.rejectValue("deliveryState", "", null, "Etat de la livraison est invalide");
        }

        if (paletteId == null || !paletteService.exists(paletteId)) {
            errors.rejectValue("paletteId", "", null, "Veuillez selectionner un type de palette valide");
        }

        if (vehicleId == null || !vehicleService.exists(vehicleId)) {
            errors.rejectValue("vehicleId", "", null, "Veuillez selectionner un camion valide");
        }

        if (paletteCount == null || paletteCount <= 0L) {
            errors.rejectValue("paletteCount", "", null, "Le nombre de palette est obligatoire");
        }

        if (orderId == null || !ordersRepository.exists(orderId)) {
            errors.rejectValue("orderId", "", null, "Veuillez selectionner un commande à livrer");
        }

    }

    private boolean validateDeliveryState(String deliveryState) {
        if (StringUtils.isBlank(deliveryState)) return false;
        try {
            DeliveryState.valueOf(deliveryState);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
