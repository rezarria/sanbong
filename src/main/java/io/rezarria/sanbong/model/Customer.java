package io.rezarria.sanbong.model;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String picture;
    private JsonNode data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldUseHistory> FieldUseHistories;
}
