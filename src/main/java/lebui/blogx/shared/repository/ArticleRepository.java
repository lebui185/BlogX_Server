package lebui.blogx.shared.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import lebui.blogx.shared.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Collection<Article> findByAccountId(Integer accountId);

}
