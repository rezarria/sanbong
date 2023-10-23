package io.rezarria.sanbong.security.model;

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
    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Account> accounts = new HashSet<>();
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "roles")
    private Set<RegisterTemplate> registerTemplates = new HashSet<>();
}
