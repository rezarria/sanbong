package io.rezarria.sanbong.security.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
public class RegisterTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private boolean active;
    private Set<Role> roles;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date time;
}
