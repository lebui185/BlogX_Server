package lebui.blogx.shared.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lebui.blogx.shared.entity.Account;
import lebui.blogx.shared.repository.AccountRepository;

//@Component
public class DatabaseUserDetailsService implements UserDetailsService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        
        SecurityAccount securityAccount = mapAccount(account);
        return securityAccount;
    }

    public SecurityAccount mapAccount(Account account) {
        Collection<GrantedAuthority> authorities = account
            .getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
            .collect(Collectors.toList())
            ;
        
        SecurityAccount securityAccount = new SecurityAccount(
            account.getId(),
            account.getUsername(),
            account.getPassword(),
            account.getEmail(),
            authorities
        );
        
        return securityAccount;
    }
}
