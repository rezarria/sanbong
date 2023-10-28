package io.rezarria.sanbong.security.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class RegisterTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private boolean active;
    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Role> roles = new HashSet<>();
    @Temporal(TemporalType.TIMESTAMP)


    @CreatedDate
    private Date time;

    private Audit audit;
}
