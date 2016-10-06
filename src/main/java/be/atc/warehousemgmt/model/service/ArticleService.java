package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
public interface ArticleService {
    List<Article> findAllBySupplier(Person person);
    Article saveArticle(Article article);
    Article findArticleById(Long article);
    List<Article> findAll ();

    boolean articleExist(Long articleId);

    List<Article> findByArchivedFalse();

    Optional<Article> findByLabel(String label);
}
