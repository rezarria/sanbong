package io.rezarria.sanbong.model;

import io.rezarria.sanbong.security.model.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Field {
    Audit audit;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String picture;
    private String description;
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldPrice> FieldPrices;
    @OneToOne
    private FieldPrice fieldPrice;
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldDetail> fieldDetails;
    @OneToOne
    private FieldDetail fieldDetail;
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldUseHistory> FieldUseHistories;
}
