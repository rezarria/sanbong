package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity()
@SuperBuilder
public class Role extends BaseEntity {
    public Role() {
    }

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    @Builder.Default
    private Set<AccountRole> accounts = new HashSet<>();

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("role")
    @Builder.Default
    private Set<RegisterTemplate> registerTemplates = new HashSet<>();
}
