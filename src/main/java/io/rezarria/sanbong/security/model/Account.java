package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.rezarria.sanbong.model.Field;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String password;
    private boolean active;

    @OneToOne(optional = true, mappedBy = "account")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    @Builder.Default
    private Set<AccountRole> roles = new HashSet<>();

    public void addRole(UUID id) {
        roles.add(AccountRole.builder().role(
                Role.builder().id(id).build()).build());
    }

    // @ToString.Exclude
    // @EqualsAndHashCode.Exclude
    // @JsonIgnore
    // private AuditWith<Account> auditWithAccounts;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonIgnore
//    private AuditWith<Role> auditWithRoles;
//
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonIgnore
//    private AuditWith<User> auditWithUsers;
//
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonIgnore
//    private AuditWith<Field> auditWithFields;
//
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonIgnore
//    private AuditWith<RegisterTemplate> auditWithRegisterTemplates;
}
