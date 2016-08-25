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

    @RequestMapping(value = "getSupplierOrdersTable", method = RequestMethod.GET)
    public String getSupplierOrdersTable(Model model) {
        List<SupplierOrderBean> supplierOrderBeen = supplierOrderService.getAllSupplierOrders().stream().filter((d) -> !d.isArchived()).map(SupplierOrderBean::of).collect(Collectors.toList());
        model.addAttribute("supplierOrderBeen", supplierOrderBeen);
        return "supplierOrderTable";
    }

    @RequestMapping(value = "getAddSupplierOrderForm", method = RequestMethod.GET)
    public String getAddSupplierOrdersForm(Model model, @RequestParam(required = false) Long supplierOrderId) {
        SupplierOrderBean supplierOrderBean = new SupplierOrderBean();
        if (supplierOrderId != null && supplierOrderService.supplierOrderExist(supplierOrderId)) {
            Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrderId);
            supplierOrderBean = SupplierOrderBean.of(supplierOrders);
            supplierOrderBean.setUpdateCase(true);
        }
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

        Orders orders = null;
        Person person = personService.findPersonById(supplierOrderBean.getPersonId());
        if (supplierOrderBean.getOrdersId() != null && supplierOrderService.supplierOrderExist(supplierOrderBean.getOrdersId())) {
            Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrderBean.getOrdersId());
            orders = supplierOrderService.saveSupplierOrder(supplierOrderBean.prepareForUpdate(supplierOrders));
        } else {
            orders = supplierOrderService.saveSupplierOrder(supplierOrderBean.prepareForCreation(person));
        }
        redirectAttributes.addAttribute("supplierOrderId", orders.getOrdersId());
        return "redirect:/SupplierOrderController/getSupplierOrderDetail";
    }

    @RequestMapping(value = "getSupplierOrderDetail", method = RequestMethod.GET)
    public String getSupplierOrderDetail(Model model, @RequestParam Long supplierOrderId) {
        Orders orders = supplierOrderService.findSupplierOrders(supplierOrderId);
        List<OrderDetail> orderDetails = supplierOrderService.findAllSupplierOrderDetailBySupplierOrder(orders);
        model.addAttribute("supplierOrder", SupplierOrderBean.of(orders));
        model.addAttribute("supplierOrderDetails", orderDetails.stream().filter((d) -> !d.isArchived()).map(SupplierOrderDetailBean::of).collect(Collectors.toList()));
        return "supplierOrderDetail";
    }

    @RequestMapping(value = "getSupplierOrderDetailForm", method = RequestMethod.GET)
    public String getSupplierOrdersDetailForm(Model model, @RequestParam Long supplierOrdersId, @RequestParam(required = false) Long supplierOrderDetailId) {
        Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrdersId);
        SupplierOrderDetailBean supplierOrderDetailBean = new SupplierOrderDetailBean();
        supplierOrderDetailBean.setSupplierOrderId(supplierOrders.getOrdersId());
        if (supplierOrderDetailId != null && supplierOrderService.supplierOrderDetailExist(supplierOrderDetailId)) {
            OrderDetail supplierOrderDetailById = supplierOrderService.findSupplierOrderDetailById(supplierOrderDetailId);
            supplierOrderDetailBean = SupplierOrderDetailBean.of(supplierOrderDetailById);
            supplierOrderDetailBean.setUpdateCase(true);
        }
        model.addAttribute("supplierOrderDetailBean", supplierOrderDetailBean);
        model.addAttribute("articles", articleService.findAllBySupplier(supplierOrders.getPerson()));
        return "supplierOrderDetailForm";
    }

    @RequestMapping(value = "saveSupplierOrderDetail", method = RequestMethod.POST)
    public String saveSupplierOrdersDetail(Model model, RedirectAttributes redirectAttributes, @ModelAttribute SupplierOrderDetailBean supplierOrderDetailBean, BindingResult errors) {
        supplierOrderValidator.validateSupplierOrderDetailBean(supplierOrderDetailBean, errors);
        if (errors.hasErrors()) {
            Person person = supplierOrderService.findSupplierOrders(supplierOrderDetailBean.getSupplierOrderId()).getPerson();
            model.addAttribute("articles", articleService.findAllBySupplier(person));
            return "supplierOrderDetailForm";
        }

        Orders orders = supplierOrderService.findSupplierOrders(supplierOrderDetailBean.getSupplierOrderId());
        Article article = articleService.findArticleById(supplierOrderDetailBean.getArticle());
        if (supplierOrderDetailBean.getSupplierOrderDetailId() != null && supplierOrderService.supplierOrderDetailExist(supplierOrderDetailBean.getSupplierOrderDetailId())) {
            OrderDetail supplierOrderDetailById = supplierOrderService.findSupplierOrderDetailById(supplierOrderDetailBean.getSupplierOrderDetailId());
            supplierOrderService.saveSupplierOrdersDetail(supplierOrderDetailBean.prepareForUpdate(supplierOrderDetailById));
        } else {
            supplierOrderService.saveSupplierOrdersDetail(supplierOrderDetailBean.prepareForCreation(article, orders));
        }
        redirectAttributes.addAttribute("supplierOrderId", orders.getOrdersId());
        return "redirect:/SupplierOrderController/getSupplierOrderDetail";
    }

}
