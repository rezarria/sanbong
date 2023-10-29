package io.rezarria.sanbong.api.system;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.fge.jsonpatch.JsonPatch;
import io.rezarria.sanbong.security.model.Account;
import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountRepository repository;
    @Qualifier("jsonPatchObjectMapper")
    private final ObjectMapper objectMapper;

    @GetMapping
    @Transactional
    public ResponseEntity<?> find() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateDTO dto) {
        return ResponseEntity.ok(repository.save(Account.builder().username(dto.username).password(dto.password).roles(dto.roles.stream().map(id -> Role.builder().id(id).build()).collect(Collectors.toSet())).build()));
    }

    @SneakyThrows
    @PatchMapping(consumes = "application/json-patch+json")
    @Transactional()
    public ResponseEntity<?> update(@RequestParam UUID id, @RequestBody JsonPatch patch) {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        Account account = repository.getReferenceById(id);
        JsonNode nodePatched = patch.apply(objectMapper.convertValue(account, JsonNode.class));
        Account accountPatched = objectMapper.treeToValue(nodePatched, Account.class);
        accountPatched = repository.save(accountPatched);
        return ResponseEntity.ok(accountPatched);
    }

    public record CreateDTO(String username, String password, Collection<UUID> roles) {
    }

}
