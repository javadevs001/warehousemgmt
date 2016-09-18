package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ahmedidoumhaidi on 13/07/16.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Inject
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAllBySupplier(Person person) {
        return articleRepository.findAllByPerson(person);
    }

    @Override
    public List<Article> findAllByCustomer(Person person) {return articleRepository.findAllByPerson(person);}

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findArticleById(Long article) {
        return articleRepository.findOne(article);
    }



}
