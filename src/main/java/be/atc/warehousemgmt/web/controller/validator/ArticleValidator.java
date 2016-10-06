package be.atc.warehousemgmt.web.controller.validator;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.service.ArticleService;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.web.controller.bean.ArticleBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import javax.inject.Inject;
import javax.validation.constraints.Null;
import java.util.Optional;

/**
 * Created by Maximilien on 29/08/16.
 */
@Component
public class ArticleValidator {
    @Inject
    private ArticleService articleService;

    public void validateArticle(ArticleBean articleBean, BindingResult errors) {

        String articleLabel = articleBean.getLabel();
        String description = articleBean.getDescription();

        if (StringUtils.isBlank(articleLabel)){
            errors.rejectValue("label" , "", null,"Le label de l article ne peut pas etre vide");
        }
        if (StringUtils.isBlank(description)){
            errors.rejectValue("description" , "", null,"La description de l article ne peut pas etre vide");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personId", "", "Le choix du fournisseur est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boxId", "", "Le choix de la boite est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "depth", "", "La profondeur de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "width", "", "La largeur de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "", "Le poids de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "", "La quantitée de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "threshold", "", "Le seuil de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "packageQuantity", "", "L'unité de vente de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sellingUnitPrice", "", "Le prix de vente de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "buyingUnitPrice", "", "LE prix d'achat de l'article est obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "", "La hauteur de l'article est obligatoire");
    }

    public void validateArticleForInsert (ArticleBean articleBean, BindingResult errors){
        String label = articleBean.getLabel();
        Optional<Article> articleOptionalLabel = articleService.findByLabel(label);
        if (articleOptionalLabel.isPresent() ){
            errors.rejectValue("label" , "", null,"Le label de l'article existe déja");
        }
        validateArticle(articleBean,errors);
    }




}
