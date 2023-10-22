package io.rezarria.sanbong.security.respository;

import io.rezarria.sanbong.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRespository extends JpaRepository<Role, UUID> {

}
