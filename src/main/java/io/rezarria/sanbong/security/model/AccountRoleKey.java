package io.rezarria.sanbong.security.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRoleKey implements Serializable {
    @Getter
    @Setter
    UUID accountId;
    @Getter
    @Setter
    UUID roleId;
}
