package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import io.rezarria.sanbong.converter.JsonNodeConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @OneToOne(optional = true)
    private Account account;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode data;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Audit audit;
}
