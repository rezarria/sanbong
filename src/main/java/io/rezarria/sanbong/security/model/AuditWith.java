package io.rezarria.sanbong.security.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class AuditWith<T> {
    @OneToMany(mappedBy = "audit.createdBy", fetch = FetchType.LAZY)
    private List<T> creates;
    @OneToMany(mappedBy = "audit.lastModifiedBy", fetch = FetchType.LAZY)
    private List<T> modifies;
}
