package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderPriority;
import be.atc.warehousemgmt.model.entity.orders.OrderState;
import be.atc.warehousemgmt.model.entity.orders.OrderType;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.service.ArticleService;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.model.service.SupplierOrderService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public class AddSupplierOrdersOneShot {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("dev");
        SupplierOrderService supplierOrderService = applicationContext.getBean(SupplierOrderService.class);
        PersonService personService = applicationContext.getBean(PersonService.class);
        ArticleService articleService = applicationContext.getBean(ArticleService.class);

        Person person = new Person();
        person.setCompanyName("Carrefour");
        person.setPersonType(PersonType.Supplier);
        personService.savePerson(person);

        Orders orders = new Orders();
        orders.setPerson(person);
        orders.setPriority(OrderPriority.Exceptional);
        orders.setState(OrderState.TO_TREAT);
        orders.setType(OrderType.Supplier);
        supplierOrderService.saveSupplierOrder(orders);


        Article article5 = new Article();
        article5.setPerson(person);
        article5.setBuyingUnitPrice(40d);
        article5.setDescription("Aucune description pour l'instant");
        article5.setLabel("Jack Daniels");
        article5.setPackageQuantity(6);
        article5.setSellingUnitPrice(55d);
        article5.setVolume(11d);
        article5.setDepth(11d);
        article5.setHeight(16d);
        article5.setWeight(14.0);
        articleService.saveArticle(article5);




    }
}
