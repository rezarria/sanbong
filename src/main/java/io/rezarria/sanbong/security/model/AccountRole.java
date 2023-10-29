package io.rezarria.sanbong.security.model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
public class AccountRole {

    public AccountRole() {}

    /**
     * @param id
     * @param account
     * @param role
     */
    public AccountRole(AccountRoleKey id, Account account, Role role) {
        this.id = id;
        this.account = account;
        this.role = role;
    }

    @EmbeddedId
    private AccountRoleKey id;

    @MapsId("accountId")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Account account;

    @MapsId("roleId")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Role role;

    

    @Override
    public int hashCode() {
        return Objects.hash(id, account, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountRole)) {
            return false;
        }
        AccountRole other = (AccountRole) obj;
        return Objects.equals(id, other.id) && Objects.equals(account, other.account)
                && Objects.equals(role, other.role);
    }

    /**
     * @return the id
     */
    public AccountRoleKey getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(AccountRoleKey id) {
        this.id = id;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    
}
