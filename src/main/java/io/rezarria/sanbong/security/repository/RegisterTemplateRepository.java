package io.rezarria.sanbong.security.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rezarria.sanbong.security.model.RegisterTemplate;


public interface RegisterTemplateRepository extends JpaRepository<RegisterTemplate, UUID> {
    Optional<RegisterTemplate> findFirstByOrderByTimeDesc();
}
