package io.rezarria.sanbong.api.system;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import io.rezarria.sanbong.security.model.AccountRole;
import io.rezarria.sanbong.security.model.AccountRoleKey;
import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.AccountRepository;
import io.rezarria.sanbong.security.repository.AccountRoleRepository;
import io.rezarria.sanbong.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountRoleRepository accountRoleRepository;
    private final RoleRepository roleRepository;
    private final AccountRepository repository;
    @Qualifier("jsonPatchObjectMapper")
    private final ObjectMapper objectMapper;

    @GetMapping(produces = "application/json")
    @Transactional
    public ResponseEntity<Collection<Account>> find() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Account> create(@RequestBody CreateDTO dto) {
        Account account = Account.builder().username(dto.username).password(dto.password).build();
        account = repository.save(account);

        for (UUID roleId : dto.roles) {
            var role = roleRepository.findById(roleId).orElseThrow();
            account.getRoles().add(AccountRole.builder()
                    .id(AccountRoleKey.builder()
                            .accountId(account.getId())
                            .roleId(role.getId())
                            .build())
                    .account(account)
                    .role(role)
                    .build());
        }

        return ResponseEntity.ok(account);
    }

    @SneakyThrows
    @PatchMapping(consumes = "application/json-patch+json", produces = "application/json")
    @Transactional()
    public ResponseEntity<Account> update(@RequestParam UUID id, @RequestBody JsonPatch patch) {
        Account account = repository.getReferenceById(id);
        JsonNode nodePatched = patch.apply(objectMapper.convertValue(account, JsonNode.class));
        Account accountPatched = objectMapper.treeToValue(nodePatched, Account.class);
        accountPatched = repository.save(accountPatched);
        return ResponseEntity.ok(accountPatched);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Collection<UUID> ids) {
        repository.deleteAllById(ids);
        return ResponseEntity.ok().build();
    }

    public record CreateDTO(String username, String password, Collection<UUID> roles) {
    }

}
