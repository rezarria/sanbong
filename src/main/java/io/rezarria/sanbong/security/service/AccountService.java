package io.rezarria.sanbong.security.service;

import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.AccountRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

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

    public Account add(Account account) {
        return respository.save(account);
    }

    @Nullable
    public Account register(String username, String password, Stream<Role> roles) {
        try {
            return respository.save(make(username, password, roles));
        } catch (Exception e) {
            return null;
        }
    }

    public Account make(String username, String password, Stream<Role> roles) {
        return make(username, password, roles.toList());
    }

    public Account make(String username, String password, Collection<Role> roles) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.getRoles().addAll(roles);
        return account;
    }

}
