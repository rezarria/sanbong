package io.rezarria.sanbong.security.model;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private boolean active;
    @OneToOne(optional = true, mappedBy = "account", fetch = FetchType.LAZY)
    private User user;
    @ManyToMany()
    private Set<Role> roles = new HashSet<>();
}
