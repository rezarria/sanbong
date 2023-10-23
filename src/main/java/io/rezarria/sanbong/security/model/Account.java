package io.rezarria.sanbong.security.model;

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
    private String username;
    private String password;
    private boolean active;
    @OneToOne(optional = true, mappedBy = "account", cascade = CascadeType.MERGE)
    private User user;
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "accounts")
    private Set<Role> roles = new HashSet<>();
}
