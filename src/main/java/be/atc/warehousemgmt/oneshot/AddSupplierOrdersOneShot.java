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
import be.atc.warehousemgmt.model.service.SupplierOrderDetailService;
import be.atc.warehousemgmt.model.service.SupplierOrderService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public class AddSupplierOrdersOneShot {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("dev");
        SupplierOrderService supplierOrderService = applicationContext.getBean(SupplierOrderService.class);
        SupplierOrderDetailService supplierOrderDetailService = applicationContext.getBean(SupplierOrderDetailService.class);
        PersonService personService = applicationContext.getBean(PersonService.class);
        ArticleService articleService = applicationContext.getBean(ArticleService.class);

        Person person = new Person();
        person.setCompanyName("Delhaise");
        person.setPersonType(PersonType.Supplier);
        person.setName("Ahmed Idoumhaidi");
        person.setAddressStreet("Rue de delhaise");
        person.setAddressCity("Charleroi");
        person.setAddressNumber("12");
        person.setAddressPostCode("6010");
        personService.savePerson(person);

        person = new Person();
        person.setCompanyName("Colruyt");
        person.setPersonType(PersonType.Supplier);
        person.setName("Ahmed Idoumhaidi");
        person.setAddressStreet("Rue de colruyt");
        person.setAddressCity("Charleroi");
        person.setAddressNumber("18");
        person.setAddressPostCode("6010");
        personService.savePerson(person);

        Orders orders = new Orders();
        orders.setPerson(person);
        orders.setPriority(OrderPriority.Exceptional);
        orders.setState(OrderState.TO_TREAT);
        orders.setType(OrderType.Supplier);
        supplierOrderService.saveSupplierOrder(orders);

        Article article = new Article();
        article.setPerson(person);
        article.setBuyingUnitPrice(10d);
        article.setDescription("Aucun description pour l'instant");
        article.setLabel("Coca cola");
        article.setPackageQuantity(1);
        article.setSellingUnitPrice(13d);
        article.setVolume(5d);
        article.setDepth(5d);
        article.setHeight(5d);
        articleService.saveArticle(article);

        article = new Article();
        article.setPerson(person);
        article.setBuyingUnitPrice(10d);
        article.setDescription("Aucun description pour l'instant");
        article.setLabel("Sprite");
        article.setPackageQuantity(1);
        article.setSellingUnitPrice(13d);
        article.setVolume(5d);
        article.setDepth(5d);
        article.setHeight(5d);
        articleService.saveArticle(article);

      /*  Article articleById = articleService.findArticleById(1L);
        Person person = articleById.getPerson();
        SupplierOrderDetail supplierOrderDetail = new SupplierOrderDetail();
        supplierOrderDetail.setArticle(articleById);
        supplierOrderDetail.setQuantity(10000);
        supplierOrderDetail.setSupplierOrderDetailType(SupplierOrderDetailType.Regular);
        supplierOrderDetailService.save(supplierOrderDetail);*/

    }
}
