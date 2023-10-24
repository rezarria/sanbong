package io.rezarria.sanbong.security.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity()
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH }, mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Account> accounts = new HashSet<>();
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH }, mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RegisterTemplate> registerTemplates = new HashSet<>();
}
