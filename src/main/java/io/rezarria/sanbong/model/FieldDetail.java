package io.rezarria.sanbong.model;

import com.fasterxml.jackson.databind.JsonNode;
import io.rezarria.sanbong.security.model.Audit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldDetail {
    Audit audit;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode data;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Field field;
    @OneToMany(mappedBy = "fieldDetail", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FieldUseHistory> FieldUseHistories;
}
