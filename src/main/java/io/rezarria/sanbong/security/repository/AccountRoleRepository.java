package io.rezarria.sanbong.security.repository;

import io.rezarria.sanbong.security.model.AccountRole;
import io.rezarria.sanbong.security.model.AccountRoleKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRoleKey> {
}
