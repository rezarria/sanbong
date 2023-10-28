package io.rezarria.sanbong.model;

import io.rezarria.sanbong.security.model.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldUseHistory {
    Audit audit;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Field field;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Staff staff;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FieldDetail fieldDetail;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FieldPrice fieldPrice;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private String description;
}
