package io.rezarria.sanbong.security.model;

import com.fasterxml.jackson.databind.JsonNode;
import io.rezarria.sanbong.converter.JsonNodeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String name;
    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @OneToOne(optional = true)
    private Account account;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode data;
}
