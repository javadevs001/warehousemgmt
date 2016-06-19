package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.person.Person;
import be.atc.warehousemgmt.model.entity.supplier.SupplierOrder;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.model.service.SupplierOrderService;
import be.atc.warehousemgmt.web.bean.SupplierOrderBean;
import be.atc.warehousemgmt.web.validator.SupplierOrderValidator;
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
 * Created by ahmedidoumhaidi on 19/06/16.
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

    @RequestMapping(value = "SupplierOrderTable", method = RequestMethod.GET)
    public String getSupplierOrderTable(Model model) {
        List<SupplierOrderBean> supplierOrderBeen = supplierOrderService.getAllSupplierOrder().stream().map(SupplierOrderBean::from).collect(Collectors.toList());
        model.addAttribute("supplierOrderBeen", supplierOrderBeen);
        return "supplierOrderTableView";
    }

    @RequestMapping(value = "SupplierOrderForm", method = RequestMethod.GET)
    public String getSupplierOrderForm(Model model) {
        SupplierOrderBean supplierOrderBean = new SupplierOrderBean();
        model.addAttribute("supplierOrderBean", supplierOrderBean);
        model.addAttribute("suppliers", personService.getAllSuppliers());
        return "supplierOrderFormView";
    }

    @RequestMapping(value = "saveSupplierOrder", method = RequestMethod.POST)
    public String saveSupplierOrder(Model model, @ModelAttribute SupplierOrderBean supplierOrderBean, BindingResult errors, RedirectAttributes redirectAttributes) {
        supplierOrderValidator.validate(supplierOrderBean, errors);
        if (errors.hasErrors()) {
            model.addAttribute("suppliers", personService.getAllSuppliers());
            return "supplierOrderFormView";
        }

        Person person = personService.getPersonById(supplierOrderBean.getPersonId());
        SupplierOrder supplierOrder = supplierOrderService.saveSupplierOrder(supplierOrderBean.prepareForCreation(person));
        redirectAttributes.addAttribute("supplierOrderId", supplierOrder.getSupplierOrderId());
        return "redirect:supplierOrderDetail";
    }

    @RequestMapping(value = "SupplierOrderDetail", method = RequestMethod.GET)
    public String getSupplierOrderDetail(Model model, @RequestParam Long supplierOrderId) {
        SupplierOrder supplierOrder = supplierOrderService.getSupplierOrderById(supplierOrderId);
        model.addAttribute("supplierOrderBean", SupplierOrderBean.from(supplierOrder));
        return "supplierOrderDetailView";
    }

}
