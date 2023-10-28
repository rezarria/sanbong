package io.rezarria.sanbong.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rezarria.sanbong.model.FieldDetail;

public interface FieldDetailRepository extends JpaRepository<FieldDetail, UUID> {

}
