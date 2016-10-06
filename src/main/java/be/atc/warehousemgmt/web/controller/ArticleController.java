package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.box.Box;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.repository.BoxRepository;
import be.atc.warehousemgmt.model.service.ArticleService;
import be.atc.warehousemgmt.model.service.PersonService;
import be.atc.warehousemgmt.web.controller.bean.ArticleBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierBean;
import be.atc.warehousemgmt.web.controller.bean.SupplierOrderDetailBean;
import be.atc.warehousemgmt.web.controller.validator.ArticleValidator;
import be.atc.warehousemgmt.web.controller.validator.SupplierValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maximilien on 29/08/16.
 */
@Controller
@RequestMapping("/ArticleController/")
public class ArticleController {
    @Inject
    private PersonService personService;
    @Inject
    private ArticleService articleService;
    @Inject
    private ArticleValidator articleValidator;
    @Inject
    private BoxRepository boxRepository;

    @RequestMapping(value = "saveArticle", method = RequestMethod.POST)
    public String saveArticle(Model model, @ModelAttribute ArticleBean articleBean, BindingResult errors, RedirectAttributes redirectAttributes) {
        if (articleBean.getArticleId() == null){
            articleValidator.validateArticleForInsert(articleBean, errors);
            if (errors.hasErrors()) {
                model.addAttribute("articles", articleService.findAll());
                model.addAttribute("persons", personService.getAllSuppliers());
                model.addAttribute("boxs", boxRepository.findAll());
                return "articleForm";
            }else {
                Person person = personService.findPersonById(articleBean.getPersonId());
                Box box = boxRepository.findOne(articleBean.getBoxId());
                articleService.saveArticle(articleBean.prepareForCreation(person , box));}
        }
        else {
            articleValidator.validateArticle(articleBean, errors);
            if (errors.hasErrors()) {
                model.addAttribute("articles", articleService.findArticleById(articleBean.getArticleId()));
                model.addAttribute("persons", personService.findPersonById(articleBean.getPersonId()));
                model.addAttribute("boxs", boxRepository.findOne(articleBean.getBoxId()));
                return "articleDetail";
            }else {
            Article article = articleService.findArticleById(articleBean.getArticleId());
            articleService.saveArticle(articleBean.prepareForUpdate(article));}
        }
        return "redirect:/ArticleController/getArticleTable";
    }

    @RequestMapping(value = "getArticleTable", method = RequestMethod.GET)
    public String getArticleTable(Model model) {
        List<ArticleBean> articleBeen = articleService.findByArchivedFalse().stream().map(ArticleBean::of).collect(Collectors.toList());
        model.addAttribute("articleBeen", articleBeen);
        return "articleTable";
    }


    @RequestMapping(value = "getAddArticleForm", method = RequestMethod.GET)
    public String getAddArticleForm(Model model) {
        ArticleBean articleBean = new ArticleBean();
        model.addAttribute("articleBean", articleBean);
        model.addAttribute("persons", personService.getAllSuppliers());
        model.addAttribute("boxs", boxRepository.findAll());
        return "articleForm";
    }

    @RequestMapping(value = "getArticleDetail", method = RequestMethod.GET)
    public String getArticleDetail(Model model, @RequestParam  Long articleId) {
        ArticleBean articleBean = new ArticleBean();
        if (articleId != null && articleService.articleExist (articleId)){
            Article article = articleService.findArticleById(articleId);
            articleBean = ArticleBean.of(article);
        }
        model.addAttribute("articleBean", articleBean);
        return "articleDetail";
    }

    @RequestMapping(value = "deleteArticle", method = RequestMethod.GET)
    public String deleteArticle (Model model , @RequestParam Long articleId){
        ArticleBean articleBean = new ArticleBean();
        Article article = articleService.findArticleById(articleId);
        article.setArchived(true);
        articleBean = ArticleBean.of(article);
        articleService.saveArticle(article);
        return "redirect:/ArticleController/getArticleTable";
    }
}
