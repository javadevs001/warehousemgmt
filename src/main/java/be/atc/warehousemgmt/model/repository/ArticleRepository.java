package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByPerson(Person person);

}
