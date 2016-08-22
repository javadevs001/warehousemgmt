package be.atc.warehousemgmt.web.controller.validator;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.*;
import be.atc.warehousemgmt.model.service.ArticleService;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.model.service.SupplierOrderService;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderDetailBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import javax.inject.Inject;
import java.util.Optional;


/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */

@Component
public class SupplierOrderValidator {

    @Inject
    private PersonService personService;
    @Inject
    private SupplierOrderService supplierOrderService;
    @Inject
    private ArticleService articleService;

    public void validateSupplierOrder(SupplierOrderBean supplierOrderBean, BindingResult errors) {

        Long personId = supplierOrderBean.getPersonId();
        if (personId == null || !personService.exists(personId)) {
            errors.rejectValue("personId", "", null, "Le choix du fournisseur est invalide");
        }


        if (!validateOrdersPriority(supplierOrderBean.getPriority())) {
            errors.rejectValue("priority", "", null, "La priorité est invalide");
        }

    }

    private boolean validateOrdersState(String state) {
        if (StringUtils.isBlank(state)) return false;
        try {
            return OrderState.valueOf(state) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateOrdersType(String type) {
        if (StringUtils.isBlank(type)) return false;
        try {
            return OrderType.valueOf(type) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateOrdersPriority(String priority) {
        if (StringUtils.isBlank(priority)) return false;
        try {
            return OrderPriority.valueOf(priority) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void validateSupplierOrderDetailBean(SupplierOrderDetailBean supplierOrderDetailBean, BindingResult errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "article", "", "Le choix de l'article est obligatoire");

        if (!validateOrderQuantity(supplierOrderDetailBean.getQuantity())) {
            errors.rejectValue("quantity", "", "La quantité est invalide");
        }

        if (!errors.hasErrors() && supplierOrderDetailBean.getSupplierOrderDetailId() == null) {
            if (orderDetailExist(supplierOrderDetailBean))
                errors.rejectValue("article", "", null, "Il existe déja une ligne de commande pour cette article.");
        }
    }

    private boolean validateOrderQuantity(String quantity) {
        if (StringUtils.isBlank(quantity)) return false;
        try {
            Integer.valueOf(quantity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean orderDetailExist(SupplierOrderDetailBean supplierOrderDetailBean) {
        Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrderDetailBean.getSupplierOrderId());
        Article article = articleService.findArticleById(supplierOrderDetailBean.getArticle());
        Optional<OrderDetail> orderDetailByOrdersAndArticle = supplierOrderService.findOrderDetailByOrdersAndArticle(supplierOrders, article);
        return orderDetailByOrdersAndArticle.isPresent();
    }

}
