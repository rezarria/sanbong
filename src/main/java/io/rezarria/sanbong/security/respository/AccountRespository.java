package io.rezarria.sanbong.security.respository;

import io.rezarria.sanbong.security.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRespository extends JpaRepository<Account, UUID> {
    Optional<Account> findByUsername(String username);
}
