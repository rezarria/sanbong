package io.rezarria.sanbong.security.repository;

import io.rezarria.sanbong.security.model.RegisterTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface RegisterTemplateRepository extends JpaRepository<RegisterTemplate, UUID> {
    Optional<RegisterTemplate> findFirstByOrderByTimeDesc();
}
