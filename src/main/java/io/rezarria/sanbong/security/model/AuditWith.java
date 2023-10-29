package io.rezarria.sanbong.security.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class AuditWith<T> {
    // @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, orphanRemoval = false)
    // private List<T> creates;
    // @OneToMany(mappedBy = "lastModifiedBy", fetch = FetchType.LAZY, orphanRemoval = false)
    // private List<T> modifies;
}
