package lebui.blogx.shared.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import lebui.blogx.config.PersistenceTestConfig;
import lebui.blogx.shared.entity.Account;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PersistenceTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class UserRepositoryTest {

    @Resource
    private AccountRepository userRepository;

    @Resource
    private EntityManager entityManager;

    @Test
    public void deleteUser_SoftDelete() {
        String initSql = ""
            + "INSERT INTO `role` VALUES (1, 'user');\n"
            + "INSERT INTO `user` (id, username, password, email, is_active) VALUES (1, 'user1', 'password', 'email', true);\n";

        entityManager.createNativeQuery(initSql).executeUpdate();
        Account user = userRepository.getOne(1);
        user.setActive(false);
        user = userRepository.save(user);
        
        user = userRepository.findOne(1);
        assertNotNull(user);
        assertEquals(false, user.isActive());
    }

}
