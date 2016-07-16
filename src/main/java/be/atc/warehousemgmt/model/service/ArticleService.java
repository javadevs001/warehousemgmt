package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
public interface ArticleService {
    List<Article> findAllBySupplier(Person person);

    Article saveArticle(Article article);

    Article findArticleById(Long article);

}
