package io.rezarria.sanbong.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class FieldPrice {
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
