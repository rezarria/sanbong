package io.rezarria.sanbong.security.config;

import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.respository.AccountRespository;
import io.rezarria.sanbong.security.respository.RoleRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;

import io.rezarria.sanbong.security.model.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetails {
    @Bean
    public UserDetailsService userDetailsService(AccountRespository accountDB, RoleRespository roleDB) {
        return username -> {
            Account account = accountDB.findByUsername(username).orElseThrow();
            return User
                    .withUsername(account.getUsername())
                    .password(account.getPassword())
                    .roles(account.getRoles().stream().map(Role::getName).toList()
                            .toArray(new String[0]))
                    .accountExpired(!account.isActive())
                    .credentialsExpired(!account.isActive())
                    .disabled(!account.isActive())
                    .accountLocked(!account.isActive())
                    .build();
        };
    }
}
