package io.rezarria.sanbong.security.respository;

import io.rezarria.sanbong.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRespository extends JpaRepository<User, UUID> {

}