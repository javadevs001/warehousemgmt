package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.service.DeliveryService;
import be.atc.warehousemgmt.web.controller.bean.DeliveryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wéry Lionel on 06/08/2016.
 */
@Controller
@RequestMapping("/DeliveryController/")
public class DeliveryController {

    @Inject
    private DeliveryService deliveryService;

    @RequestMapping(value = "deliveryTableView", method = RequestMethod.GET)
    public String getAllDeliveryTable(Model model) {
        List<DeliveryBean> deliveryBeen = deliveryService.findAllDelivery().stream().map(DeliveryBean::of).collect(Collectors.toList());
        model.addAttribute("deliveries", deliveryBeen);
        return "deliveryTableView";
    }

}
