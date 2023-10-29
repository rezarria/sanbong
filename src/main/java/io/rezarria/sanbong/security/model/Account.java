package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.rezarria.sanbong.model.Field;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private boolean active;

    @OneToOne(optional = true, mappedBy = "account")
    private User user;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("accounts")
    private Set<Role> roles = new HashSet<>();

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
    private AuditWith<Field> auditWithFields;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private AuditWith<RegisterTemplate> auditWithRegisterTemplates;
}
