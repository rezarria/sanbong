package io.rezarria.sanbong.model;

import java.util.Date;
import java.util.UUID;

import io.rezarria.sanbong.security.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldUseHistory {
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
    private User staff;

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
