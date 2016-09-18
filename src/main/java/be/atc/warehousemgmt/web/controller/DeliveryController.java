package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.delivery.Delivery;
import be.atc.warehousemgmt.model.entity.delivery.DeliveryHasPalette;
import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.orders.OrderState;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.entity.palette.Palette;
import be.atc.warehousemgmt.model.repository.DeliveryHasPaletteRepository;
import be.atc.warehousemgmt.model.repository.OrdersRepository;
import be.atc.warehousemgmt.model.service.DeliveryService;
import be.atc.warehousemgmt.model.service.PaletteService;
import be.atc.warehousemgmt.model.service.VehicleService;
import be.atc.warehousemgmt.web.controller.bean.DeliveryBean;
import be.atc.warehousemgmt.web.controller.validator.DeliveryValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Wéry Lionel on 06/08/2016.
 */
@Controller
@RequestMapping("/DeliveryController/")
public class DeliveryController {

    @Inject
    private DeliveryService deliveryService;
    @Inject
    private VehicleService vehicleService;
    @Inject
    private PaletteService paletteService;
    @Inject
    private DeliveryHasPaletteRepository deliveryHasPaletteRepository;
    @Inject
    private DeliveryValidator deliveryValidator;
    @Inject
    private OrdersRepository ordersRepository;

    @RequestMapping(value = "deliveryTableView", method = RequestMethod.GET)
    public String getAllDeliveryTable(Model model) {
        List<DeliveryBean> deliveryBeen = deliveryService.findAllDelivery().stream().map(DeliveryBean::of).collect(Collectors.toList());
        model.addAttribute("deliveries", deliveryBeen);
        return "deliveryTableView";
    }

    @RequestMapping(value = "getDeliveryForm", method = RequestMethod.GET)
    public String getDeliveryForm(Model model, @RequestParam(required = false) Long deliveryId) {
        DeliveryBean deliveryBean = new DeliveryBean();
        if (deliveryId != null && deliveryService.exists(deliveryId)) {
            Delivery delivery = deliveryService.findById(deliveryId);
            Orders orders = ordersRepository.findByDelivery(delivery);
            List<DeliveryHasPalette> deliveryHasPalettes = deliveryHasPaletteRepository.findByDelivery(delivery);
            deliveryBean = DeliveryBean.of(delivery, deliveryHasPalettes, orders);
        }
        model.addAttribute("deliveryBean", deliveryBean);
        model.addAttribute("vehicles", vehicleService.findAllVehicle());
        model.addAttribute("palettes", paletteService.getAllPalette());
        model.addAttribute("orders", ordersRepository.findAllByState(OrderState.READY_TO_DELIVRED));
        return "addNewDelivery";
    }

    @RequestMapping(value = "saveDelivery", method = RequestMethod.POST)
    public String saveDelivery(@ModelAttribute DeliveryBean deliveryBean, BindingResult errors, Model model) {
        deliveryValidator.validateDelivery(deliveryBean, errors);
        if (errors.hasErrors()) {
            model.addAttribute("vehicles", vehicleService.findAllVehicle());
            model.addAttribute("palettes", paletteService.getAllPalette());
            model.addAttribute("orders", ordersRepository.findAllByState(OrderState.READY_TO_DELIVRED));
            return "addNewDelivery";
        }

        Delivery delivery;
        Long deliveryId = deliveryBean.getDeliveryId();
        Vehicle vehicle = vehicleService.findByVehicleById(deliveryBean.getVehicleId());
        Palette palette = paletteService.findPaletteById(deliveryBean.getPaletteId());
        Long orderId = deliveryBean.getOrderId();
        Orders one = ordersRepository.findOne(orderId);
        if (deliveryId != null && deliveryService.exists(deliveryId)) {
            Delivery currentDelivery = deliveryService.findById(deliveryId);
            delivery = deliveryService.addNewDelivery(deliveryBean.prepareForUpdate(currentDelivery, vehicle));
            DeliveryHasPalette deliveryHasPalette = new DeliveryHasPalette();
            deliveryHasPalette.setDelivery(delivery);
            deliveryHasPalette.setPalette(palette);
            deliveryHasPalette.setPaletteCount(deliveryBean.getPaletteCount());
            deliveryHasPaletteRepository.save(deliveryHasPalette);
        } else {
            delivery = deliveryService.addNewDelivery(deliveryBean.prepareForCreation(vehicle));
            Optional<DeliveryHasPalette> byDeliveryAndPalette = deliveryHasPaletteRepository.findByDeliveryAndPalette(delivery, palette);
            if (byDeliveryAndPalette.isPresent()) {
                DeliveryHasPalette deliveryHasPalette = byDeliveryAndPalette.get();
                deliveryHasPalette.setPalette(palette);
                deliveryHasPalette.setPaletteCount(deliveryBean.getPaletteCount());
                deliveryHasPaletteRepository.save(deliveryHasPalette);
            } else {
                DeliveryHasPalette deliveryHasPalette = new DeliveryHasPalette();
                deliveryHasPalette.setDelivery(delivery);
                deliveryHasPalette.setPalette(palette);
                deliveryHasPalette.setPaletteCount(deliveryBean.getPaletteCount());
                deliveryHasPaletteRepository.save(deliveryHasPalette);
            }
        }

        one.setDelivery(delivery);
        ordersRepository.save(one);
        return "redirect:deliveryTableView";
    }

    @RequestMapping(value = "deleteDelivery", method = RequestMethod.GET)
    public String deleteDelivery(@RequestParam Long deliveryId) {
        if (deliveryId != null && deliveryService.exists(deliveryId)) {
            Delivery delivery = deliveryService.findById(deliveryId);
            deliveryService.deleteDelivery(delivery);
        }
        return "redirect:deliveryTableView";
    }

}
