package lebui.blogx.webservice.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lebui.blogx.shared.entity.Article;
import lebui.blogx.shared.service.ArticleService;
import lebui.blogx.util.ArticleViewModel;

//@RestController
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/users/{accountId}/articles")
    public Collection<ArticleViewModel> findArticlesByUser(@PathVariable Integer accountId) {
        Collection<Article> articles = articleService.findArticleByAccountId(accountId);
        
        Collection<ArticleViewModel> model = articles
            .stream()
            .map(a -> new ArticleViewModel(a))
            .collect(Collectors.toList())
            ;
        
        return model;
    }
}
