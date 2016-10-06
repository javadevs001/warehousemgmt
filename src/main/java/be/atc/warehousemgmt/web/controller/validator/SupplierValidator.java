package be.atc.warehousemgmt.web.controller.validator;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.web.controller.bean.SupplierBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.inject.Inject;
import java.io.FileDescriptor;
import java.util.Optional;

/**
 * Created by Maximilien on 21/08/16.
 */
@Component
public class SupplierValidator {

    @Inject
    private PersonService personService;

    public void validateSupplier(SupplierBean supplierBean, BindingResult errors) {
        String companyName = supplierBean.getCompanyName();
        String addressBox = supplierBean.getAddressBox();
        String phone = supplierBean.getPhone();
        String addressCity = supplierBean.getAddressCity();
        String addressPostCode = supplierBean.getAddressPostCode();
        String addressStreet = supplierBean.getAddressStreet();
        String addressNumber = supplierBean.getAddressNumber();
        String tva = supplierBean.getTva();
        String email = supplierBean.getEmail();
        if (StringUtils.isBlank(companyName)){
            errors.rejectValue("companyName" , "", null,"Le nom du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(email)){
            errors.rejectValue("email" , "", null,"L'email du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(phone)){
            errors.rejectValue("phone" , "", null,"Le téléphone du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(addressCity)){
            errors.rejectValue("addressCity" , "", null,"La ville du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(addressPostCode)){
            errors.rejectValue("addressPostCode" , "", null,"Le code postal du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(addressStreet)){
            errors.rejectValue("addressStreet" , "", null,"La rue du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(addressNumber)){
            errors.rejectValue("addressNumber" , "", null,"Le numéro de l'adresse du fournisseur ne peut pas etre vide");
        }
        if (StringUtils.isBlank(tva)){
            errors.rejectValue("tva" , "", null,"La tva du fournisseur ne peut pas etre vide");
        }
        if (!NumberUtils.isNumber(addressBox) && !StringUtils.isBlank(addressBox)){
            errors.rejectValue("addressBox" , "", null,"La boite du fournisseur doit etre un nombre");
        }
        if (!NumberUtils.isNumber(addressPostCode)){
            errors.rejectValue("addressPostCode" , "", null,"Le code postal du fournisseur doit etre un nombre");
        }
        if (!NumberUtils.isNumber(addressNumber)){
            errors.rejectValue("addressNumber" , "", null,"Le numéro de l'adresse du fournisseur doit etre un nombre");
        }
    }

    public void validateSupplierForInsert (SupplierBean supplierBean, BindingResult errors){
        String companyName = supplierBean.getCompanyName();
        String email = supplierBean.getEmail();
        Optional<Person> personOptionalCompanyName = personService.findByCompanyName(companyName);
        Optional<Person> personOptionalEmail = personService.findByEmail(email);
        if (personOptionalCompanyName.isPresent()){
            errors.rejectValue("companyName" , "", null,"Le nom du fournisseur existe déja");
        }
        if(personOptionalEmail.isPresent()){
            errors.rejectValue("email" , "", null,"L'email du fournisseur existe déja");
        }
        validateSupplier(supplierBean,errors);
    }
}
