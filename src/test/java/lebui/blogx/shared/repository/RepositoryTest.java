package lebui.blogx.shared.repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import lebui.blogx.config.PersistenceTestConfig;

@ContextConfiguration(classes = { PersistenceTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringRunner.class)
@Transactional
public class RepositoryTest {

    @Resource
    private ParentRepository parentRepository;

    @Resource
    private EntityManager entityManager;

    @Test
    public void deleteUser_SoftDelete() {
        // String initSql = ""
        // + "INSERT INTO `parent` (id, `name`) VALUES (1, 'parent1');\n"
        // + "INSERT INTO `parent` (id, `name`) VALUES (2, 'parent2');\n"
        // + "INSERT INTO `child` (id, `name`, parent_id) VALUES (1, 'child1', 1);\n"
        // + "INSERT INTO `child` (id, `name`, parent_id) VALUES (2, 'child2', 1);\n"
        // ;

        // entityManager.createNativeQuery(initSql).executeUpdate();

        // Parent parent = entityManager.find(Parent.class, 1);
        // parent.setName("lebui");
        // entityManager.flush();
        // entityManager.detach(parent);
        // parent.addChild(new Child("childdddddddddddd"));

        // entityManager.flush();

        // System.out.println(parentRepository.findAll());
    }

}
