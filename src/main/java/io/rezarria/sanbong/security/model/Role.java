package io.rezarria.sanbong.security.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

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
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "roles")
    private Set<Account> accounts = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "roles")
    private Set<RegisterTemplate> registerTemplates = new HashSet<>();
}
