package io.rezarria.sanbong.security.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterTemplate extends BaseEntity {
    private boolean active;
    @Builder.Default
    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Role> roles = new HashSet<>();
}
