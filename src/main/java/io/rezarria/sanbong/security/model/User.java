package io.rezarria.sanbong.security.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

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
}
