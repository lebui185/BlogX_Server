package lebui.blogx.shared.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import lebui.blogx.config.PersistenceTestConfig;
import lebui.blogx.shared.entity.Article;
import lebui.blogx.shared.entity.Tag;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PersistenceTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class TagRepositoryTest {
    
    @Resource
    private TagRepository tagRepository;
    
    @Resource
    private ArticleRepository articleRepository;
    
    @Resource
    private EntityManager entityManager;
    
    @Test
    public void createTag_includeArticle_NotSaveArticle() {
        Set<Article> articles = new HashSet<>();
        articles.add(new Article());        
        Tag tag = new Tag();
        tag.setName("tag01");
        tag.setArticles(articles);
        
        tag = tagRepository.save(tag);
        
        assertEquals(1, tag.getId().intValue());
        assertEquals(0, articleRepository.findAll().size());
    }
    
    @Test
    public void deleteTag_includeArticle_NotDeleteArticle() {
        String initSql = ""
            + "INSERT INTO `role` VALUES (1, 'user');\n"
                
            + "INSERT INTO `user` (id, username, password, email, is_active) VALUES (1, 'user1', 'password', 'email', true);\n"
                
            + "INSERT INTO `tag` VALUES (1, 'tag01');\n"
            + "INSERT INTO `tag` VALUES (2, 'tag02');\n"
            
            + "INSERT INTO `article` (id, title, content, created_time, last_edited, user_id)"
                + "VALUES (1, 'title1', 'content1', '2018-01-01', '2018-01-01', 1);\n"
            
            + "INSERT INTO `article_tag` (article_id, tag_id) VALUES (1, 1);\n"
            + "INSERT INTO `article_tag` (article_id, tag_id) VALUES (1, 2);\n"
            ;
        
        entityManager.createNativeQuery(initSql).executeUpdate();
        tagRepository.delete(1);
        
        assertNull(tagRepository.findOne(1));
        assertEquals(1, articleRepository.findAll().size());
    }
}
