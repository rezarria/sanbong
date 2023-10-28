package io.rezarria.sanbong.model;

import io.rezarria.sanbong.security.model.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldPrice {
    Audit audit;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double price;
    private Date time;
    private String description;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Field field;
    @OneToMany(mappedBy = "fieldPrice", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldUseHistory> FieldUseHistories;
}
