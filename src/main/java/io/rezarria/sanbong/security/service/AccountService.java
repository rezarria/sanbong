package io.rezarria.sanbong.security.service;

import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountService {
    @Lazy
    private final PasswordEncoder passwordEncoder;
    @Lazy
    private final AccountRepository respository;

    public Optional<Account> getAccountByUsername(String username) {
        return respository.findByUsername(username);
    }

    public Optional<Account> register(String username, String password, Set<Role> roles) {
        try {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(passwordEncoder.encode(password));
            if (roles != null && !roles.isEmpty()) {
                account.getRoles().addAll(roles);
            }
            respository.save(account);
            return Optional.of(account);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
