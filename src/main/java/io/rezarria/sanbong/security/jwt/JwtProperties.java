package io.rezarria.sanbong.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("jwt")
@Component
public class JwtProperties {
    @Getter
    @Setter
    private String secretKey;

    @Getter
    @Setter
    private long validityInMS;

    @Getter
    @Setter
    private long refreshInMS;
}
