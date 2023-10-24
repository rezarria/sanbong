package io.rezarria.sanbong.security.repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rezarria.sanbong.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findAllByNameIn(Collection<String> names);
}
