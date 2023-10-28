package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity()
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String name;
        @ManyToMany(mappedBy = "roles", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
                        CascadeType.REFRESH }, fetch = FetchType.LAZY)
        @JsonIgnore
        private Set<Account> accounts = new HashSet<>();
        @ManyToMany(mappedBy = "roles", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
                        CascadeType.REFRESH }, fetch = FetchType.LAZY)
        @JsonIgnore
        private Set<RegisterTemplate> registerTemplates = new HashSet<>();
}
