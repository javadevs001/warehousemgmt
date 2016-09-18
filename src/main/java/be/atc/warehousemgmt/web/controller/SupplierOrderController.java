package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.OrderPriority;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.service.ArticleService;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.model.service.SupplierOrderService;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderDetailBean;
import be.atc.warehousemgmt.web.controller.validator.SupplierOrderValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aidoumhaidi
 */

@Controller
@RequestMapping("/SupplierOrderController/")
public class SupplierOrderController {

    @Inject
    private SupplierOrderService supplierOrderService;
    @Inject
    private PersonService personService;
    @Inject
    private SupplierOrderValidator supplierOrderValidator;
    @Inject
    private ArticleService articleService;

    @RequestMapping(value = "getSupplierOrderTable", method = RequestMethod.GET)
    public String getSupplierOrdersTable(Model model) {
        List<SupplierOrderBean> supplierOrderBeen = supplierOrderService.getAllSupplierOrders().stream().map(SupplierOrderBean::of).collect(Collectors.toList());
        model.addAttribute("supplierOrderBeen", supplierOrderBeen);
        return "supplierOrderTable";
    }

    @RequestMapping(value = "getAddSupplierOrderForm", method = RequestMethod.GET)
    public String getAddSupplierOrdersForm(Model model) {
        SupplierOrderBean supplierOrderBean = new SupplierOrderBean();
        model.addAttribute("supplierOrderBean", supplierOrderBean);
        model.addAttribute("priorities", OrderPriority.values());
        model.addAttribute("persons", personService.getAllSuppliers());
        return "supplierOrderForm";
    }

    @RequestMapping(value = "saveSupplierOrder", method = RequestMethod.POST)
    public String saveSupplierOrders(Model model, @ModelAttribute SupplierOrderBean supplierOrderBean, BindingResult errors, RedirectAttributes redirectAttributes) {
        supplierOrderValidator.validateSupplierOrder(supplierOrderBean, errors);
        if (errors.hasErrors()) {
            model.addAttribute("priorities", OrderPriority.values());
            model.addAttribute("persons", personService.getAllSuppliers());
            return "supplierOrderForm";
        }

        Person person = personService.findPersonById(supplierOrderBean.getPersonId());
        supplierOrderService.saveSupplierOrder(supplierOrderBean.prepareForCreation(person));
        return "redirect:/SupplierOrderController/getSupplierOrderTable";
    }

    @RequestMapping(value = "getSupplierOrderDetail", method = RequestMethod.GET)
    public String getSupplierOrderDetail(Model model, @RequestParam Long supplierOrderId) {
        Orders orders = supplierOrderService.findSupplierOrders(supplierOrderId);
        List<OrderDetail> orderDetails = supplierOrderService.findAllSupplierOrderDetailBySupplierOrder(orders);
        model.addAttribute("supplierOrder", orders);
        model.addAttribute("supplierOrderDetails", orderDetails.stream().map(SupplierOrderDetailBean::of).collect(Collectors.toList()));
        return "supplierOrderDetail";
    }

    @RequestMapping(value = "getSupplierOrderDetailForm", method = RequestMethod.GET)
    public String getSupplierOrdersDetailForm(Model model, @RequestParam Long supplierOrdersId) {
        Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrdersId);
        SupplierOrderDetailBean supplierOrderDetailBean = new SupplierOrderDetailBean();
        supplierOrderDetailBean.setSupplierOrderId(supplierOrders.getOrdersId());
        model.addAttribute("supplierOrderDetailBean", supplierOrderDetailBean);
        model.addAttribute("articles", articleService.findAllBySupplier(supplierOrders.getPerson()));
        return "supplierOrderDetailForm";
    }

    @RequestMapping(value = "saveSupplierOrderDetail", method = RequestMethod.POST)
    public String saveSupplierOrdersDetail(Model model, @ModelAttribute SupplierOrderDetailBean supplierOrderDetailBean, BindingResult errors) {
        supplierOrderValidator.validateSupplierOrderDetailBean(supplierOrderDetailBean, errors);
        if (errors.hasErrors()) {
            Person person = supplierOrderService.findSupplierOrders(supplierOrderDetailBean.getSupplierOrderId()).getPerson();
            model.addAttribute("articles", articleService.findAllBySupplier(person));
            return "supplierOrderDetailForm";
        }

        Orders orders = supplierOrderService.findSupplierOrders(supplierOrderDetailBean.getSupplierOrderId());
        Article article = articleService.findArticleById(supplierOrderDetailBean.getArticle());
        OrderDetail orderDetail = supplierOrderService.saveSupplierOrdersDetail(supplierOrderDetailBean.prepareForCreation(article, orders));
        return "redirect:getSupplierOrderTable";

            }

}
