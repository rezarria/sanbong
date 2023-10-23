package io.rezarria.sanbong.security.repository;

import io.rezarria.sanbong.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.stream.Stream;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Stream<Role> streamFindAll();
}
