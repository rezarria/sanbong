package io.rezarria.sanbong.security.service;

import io.jsonwebtoken.Claims;
import io.rezarria.sanbong.security.Details;
import io.rezarria.sanbong.security.jwt.JwtUtils;
import io.rezarria.sanbong.security.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final AccountService accountService;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public String login(String username, String password) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        Optional<Account> result = accountService.getAccountByUsername(username);
        Account account = result.orElseThrow();
        Details details = new Details();
        if (account.getUser() != null) {
            details.setUserId(account.getUser().getId());
        }
        details.setAccountId(account.getId());
        ((AbstractAuthenticationToken) auth).setDetails(details);
        return jwtUtils.createToken(auth);
    }

    public Account register(String username, String password) {
        return accountService.register(username, password, new HashSet<>(roleService.getAll())).orElseThrow();
    }

    public void refresh(String token) {
        Claims claims = jwtUtils.refresh(token);
        Details details = Details.from(claims);
    }
}
