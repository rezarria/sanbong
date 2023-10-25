package io.rezarria.sanbong.security.repository;

import io.rezarria.sanbong.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findAllByNameIn(Collection<String> names);
}
