package io.rezarria.sanbong.api.system;

import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountRepository repository;

    @GetMapping
    public ResponseEntity<?> find(@RequestParam String username) {
        Account account = repository.findByUsername(username).orElseThrow();
        Map<String, String> map = new HashMap<>();
        account.getRoles().forEach(i -> {
            map.put(i.getName(), i.getName());
        });
        return ResponseEntity.ok(repository.findAll());
    }
}
