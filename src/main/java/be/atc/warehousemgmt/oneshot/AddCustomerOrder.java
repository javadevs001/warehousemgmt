package be.atc.warehousemgmt.oneshot;

import be.atc.warehousemgmt.config.OneShotConfig;
import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.*;
import be.atc.warehousemgmt.model.service.ArticleService;
import be.atc.warehousemgmt.model.service.CustomerOrderService;
import be.atc.warehousemgmt.model.service.PersonService;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Wéry Lionel on 11/09/2016.
 */
public class AddCustomerOrder {

 /**   public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("dev");
        CustomerOrderService customerOrderService = applicationContext.getBean(CustomerOrderService.class);
        PersonService personService = applicationContext.getBean(PersonService.class);
        ArticleService articleService = applicationContext.getBean(ArticleService.class);

        Person person = new Person();
        person.setCompanyName("T Shop");
        person.setPersonType(PersonType.Customer);
        personService.savePerson(person);

        Orders orders = new Orders();
        orders.setPerson(person);
        orders.setPriority(OrderPriority.Urgent);
        orders.setState(OrderState.TO_TREAT);
        orders.setType(OrderType.Customer);
        customerOrderService.SaveCustomerOrders(orders);


        Article article3 = new Article();
        article3.setPerson(person);
        article3.setBuyingUnitPrice(24d);
        article3.setDescription("Thé noir du Vietnam");
        article3.setLabel("Black tea");
        article3.setPackageQuantity(24);
        article3.setSellingUnitPrice(50d);
        article3.setVolume(12d);
        article3.setDepth(12d);
        article3.setHeight(16d);
        article3.setWeight(10.0);
        articleService.saveArticle(article3);

        Article article4 = new Article();
        article4.setPerson(person);
        article4.setBuyingUnitPrice(16d);
        article4.setDescription("Thé vert de chine");
        article4.setLabel("Green Tea");
        article4.setPackageQuantity(24);
        article4.setSellingUnitPrice(35d);
        article4.setVolume(11d);
        article4.setDepth(11d);
        article4.setHeight(16d);
        article4.setWeight(10.0);
        articleService.saveArticle(article4);

        Article article6 = new Article();
        article6.setPerson(person);
        article6.setBuyingUnitPrice(50d);
        article6.setDescription("Thé de chine");
        article6.setLabel("Chiana Tea");
        article6.setPackageQuantity(18);
        article6.setSellingUnitPrice(55d);
        article6.setVolume(25d);
        article6.setDepth(20d);
        article6.setHeight(20d);
        article6.setWeight(10.0);
        articleService.saveArticle(article6);

        Article article7 = new Article();
        article7.setPerson(person);
        article7.setBuyingUnitPrice(32d);
        article7.setDescription("Thé Américain");
        article7.setLabel("Red Tea");
        article7.setPackageQuantity(24);
        article7.setSellingUnitPrice(33d);
        article7.setVolume(8d);
        article7.setDepth(8d);
        article7.setHeight(10d);
        article7.setWeight(10.0);
        articleService.saveArticle(article7);


        Article article8 = new Article();
        article8.setPerson(person);
        article8.setBuyingUnitPrice(1000d);
        article8.setDescription("Le thé le plus cher du monde");
        article8.setLabel("Da Hong Pao");
        article8.setPackageQuantity(12);
        article8.setSellingUnitPrice(33d);
        article8.setVolume(8d);
        article8.setDepth(8d);
        article8.setHeight(10d);
        article8.setWeight(10.0);
        articleService.saveArticle(article8);
}
}*/


    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = OneShotConfig.initApplicationContextFromEnvironment("dev");
        CustomerOrderService customerOrderService = applicationContext.getBean(CustomerOrderService.class);
        PersonService personService = applicationContext.getBean(PersonService.class);
        ArticleService articleService = applicationContext.getBean(ArticleService.class);

        Person person = new Person();
        person.setCompanyName("Leader Price");
        person.setPersonType(PersonType.Customer);
        personService.savePerson(person);


        Orders orders = new Orders();
        orders.setPerson(person);
        orders.setPriority(OrderPriority.Urgent);
        orders.setState(OrderState.TO_TREAT);
        orders.setType(OrderType.Customer);
        customerOrderService.SaveCustomerOrders(orders);


        Article article5 = new Article();
        article5.setPerson(person);
        article5.setBuyingUnitPrice(60d);
        article5.setDescription("Mise en bouteille au château");
        article5.setLabel("Bordeaux");
        article5.setPackageQuantity(6);
        article5.setSellingUnitPrice(55d);
        article5.setVolume(20d);
        article5.setDepth(20d);
        article5.setHeight(20d);
        article5.setWeight(30.0);
        articleService.saveArticle(article5);


    }

}