package io.rezarria.sanbong.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.rezarria.sanbong.security.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Field extends BaseEntity {
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
    @JsonUnwrapped
    private Set<FieldUseHistory> FieldUseHistories;

}
