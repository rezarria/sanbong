package io.rezarria.sanbong.security.config;

import io.rezarria.sanbong.security.model.AccountRole;
import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.AccountRepository;
import io.rezarria.sanbong.security.repository.RoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetails {
    @Bean
    public UserDetailsService userDetailsService(AccountRepository repository, RoleRepository roleDB) {
        return username -> {
            Account account = repository.findByUsername(username).orElseThrow();
            return User
                    .withUsername(account.getUsername())
                    .password(account.getPassword())
                    .roles(account.getRoles().stream().map(AccountRole::getRole).map(Role::getName).toList()
                            .toArray(new String[0]))
                    .accountExpired(!account.isActive())
                    .credentialsExpired(!account.isActive())
                    .disabled(!account.isActive())
                    .accountLocked(!account.isActive())
                    .build();
        };
    }
}
