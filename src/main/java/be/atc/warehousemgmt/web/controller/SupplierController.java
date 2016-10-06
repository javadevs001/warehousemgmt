package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.OrderPriority;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.web.controller.bean.ArticleBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderDetailBean;
import be.atc.warehousemgmt.web.controller.validator.SupplierOrderValidator;
import be.atc.warehousemgmt.web.controller.validator.SupplierValidator;
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
 * Created by Maximilien on 21/08/16.
 */
@Controller
@RequestMapping("/SupplierController/")
public class SupplierController {
    @Inject
    private PersonService personService;
    @Inject
    private SupplierValidator supplierValidator;

    @RequestMapping(value = "saveSupplier", method = RequestMethod.POST)
    public String saveSupplier(Model model, @ModelAttribute SupplierBean supplierBean, BindingResult errors, RedirectAttributes redirectAttributes) {
        if (supplierBean.getPersonId() == null){
            supplierValidator.validateSupplierForInsert(supplierBean, errors);
            if (errors.hasErrors()) {
                model.addAttribute("persons", personService.getAllSuppliers());
                return "supplierForm";
            }else {
            personService.savePerson(supplierBean.prepareForCreation());}
        }
        else {
            supplierValidator.validateSupplier(supplierBean, errors);
            if (errors.hasErrors()) {
                model.addAttribute("persons", personService.findPersonById(supplierBean.getPersonId()));
                return "supplierDetail";
            }else {
            Person supplier = personService.findPersonById(supplierBean.getPersonId());
            personService.savePerson(supplierBean.prepareForUpdate(supplier));}
        }
        return "redirect:/SupplierController/getSupplierTable";
    }

    @RequestMapping(value = "getSupplierTable", method = RequestMethod.GET)
    public String getSupplierTable(Model model) {
        List<SupplierBean> supplierBeen = personService.getAllSuppliers().stream().map(SupplierBean::of).collect(Collectors.toList());
        model.addAttribute("supplierBeen", supplierBeen);
        return "supplierTable";
    }


    @RequestMapping(value = "getAddSupplierForm", method = RequestMethod.GET)
    public String getAddSupplierForm(Model model) {
        SupplierBean supplierBean = new SupplierBean();
        model.addAttribute("supplierBean", supplierBean);
        model.addAttribute("persons", personService.getAllSuppliers());
        return "supplierForm";
    }


    @RequestMapping(value = "getSupplierDetail", method = RequestMethod.GET)
    public String getSupplierDetail(Model model, @RequestParam  Long personId) {
        SupplierBean supplierBean = new SupplierBean();
        if (personId != null && personService.personExist(personId)){
            Person supplier = personService.findPersonById(personId);
            supplierBean = SupplierBean.of(supplier);
        }
        model.addAttribute("supplierBean", supplierBean);
        return "supplierDetail";
    }

    @RequestMapping(value = "deleteSupplier", method = RequestMethod.GET)
    public String deleteArticle (Model model , @RequestParam Long personId){
        Person supplier = personService.findPersonById(personId);
        personService.delete(supplier);
        return "redirect:/SupplierController/getSupplierTable";
    }

}
