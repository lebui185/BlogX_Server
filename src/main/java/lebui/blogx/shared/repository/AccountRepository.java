package lebui.blogx.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lebui.blogx.shared.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByUsername(String username);

}
