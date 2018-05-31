package lebui.blogx.shared.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lebui.blogx.shared.entity.Article;
import lebui.blogx.shared.repository.ArticleRepository;

//@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

//    @PreAuthorize("principal.id == #accountId")
    public Collection<Article> findArticleByAccountId(int accountId) {
        return articleRepository.findByAccountId(accountId);
    }
}
