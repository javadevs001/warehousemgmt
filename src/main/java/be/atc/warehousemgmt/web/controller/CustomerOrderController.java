package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.delivery.Vehicle;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.OrderPriority;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.entity.palette.Palette;
import be.atc.warehousemgmt.model.service.*;
import be.atc.warehousemgmt.web.controller.bean.CustomerOrderBean;
import be.atc.warehousemgmt.web.controller.bean.CustomerOrderDetailBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wéry Lionel on 11/09/2016.
 */
@Controller
@RequestMapping("/CustomerOrderController/")

public class CustomerOrderController {

    @Inject
    private CustomerOrderService customerOrderService;
    @Inject
    private PersonService personService;
    @Inject
    private ArticleService articleService;
    @Inject
    private VehicleService vehicleService;
    @Inject
    private PaletteService paletteService;

    @RequestMapping(value = "getCustomerOrderTable", method = RequestMethod.GET)
    public String getCustomerOrdersTable(Model model) {
        List<CustomerOrderBean> customerOrderBeen = customerOrderService.getAllCustomerOrder().stream().map(CustomerOrderBean::of).collect(Collectors.toList());
        model.addAttribute("customerOrderBeen", customerOrderBeen);
        return "customerOrderTable";

    }


    @RequestMapping(value = "getCustomerOrderDetail", method = RequestMethod.GET)
    public String getCustomerOrderDetail(Model model, @RequestParam Long customerOrderId) {
        Orders orders = customerOrderService.FindCustomerOrders(customerOrderId);
        List<OrderDetail> orderDetails = customerOrderService.FindAllCustomerOrdersDetailByOrders(orders);
        model.addAttribute("customerOrder", orders);
        model.addAttribute("customerOrderDetails", orderDetails.stream().map(CustomerOrderDetailBean::of).collect(Collectors.toList()));
        model.addAttribute("customerArticles", articleService.findAllByCustomer(orders.getPerson()));
        return "customerOrderDetail";
    }


    @RequestMapping(value = "getAddNewDelivery", method = RequestMethod.GET)
    public String getAddNewDelivery(Model model, @RequestParam Long customerOrderId) {
        Orders orders = customerOrderService.FindCustomerOrders(customerOrderId);
        List<OrderDetail> orderDetails = customerOrderService.FindAllCustomerOrdersDetailByOrders(orders);
        model.addAttribute("customerOrder", orders);
        List<Palette> palettes = paletteService.getAllPaletteType();
        model.addAttribute("palettes",palettes);
        List<Vehicle> vehicles = vehicleService.findAllVehicle();
        model.addAttribute("vehicles", vehicles);

        return "AddNewDelivery";

    }
}

