package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private boolean active;
    @OneToOne(optional = true, mappedBy = "account")
    private User user;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Audit audit;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private AuditWith<Account> auditWithAccounts;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private AuditWith<Role> auditWithRoles;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private AuditWith<User> auditWithUsers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private AuditWith<RegisterTemplate> auditWithRegisterTemplates;
}
