package io.rezarria.sanbong.model;

import io.rezarria.sanbong.security.model.Audit;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FieldUseHistory extends Audit {
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
