package io.rezarria.sanbong.security.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import io.rezarria.sanbong.model.FieldUseHistory;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String avatar;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @OneToOne(optional = true)
    private Account account;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldUseHistory> FieldUseHistories;
}
