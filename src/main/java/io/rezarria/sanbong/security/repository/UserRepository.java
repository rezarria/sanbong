package io.rezarria.sanbong.security.repository;

import io.rezarria.sanbong.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}