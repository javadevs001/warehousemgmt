package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByPerson(Person person);
    List<Article> findByArchivedFalse();

    Optional<Article> findByLabel(String label);
}
