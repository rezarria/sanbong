package io.rezarria.sanbong.security.config;

import io.rezarria.sanbong.security.jwt.JwtFilter;
import io.rezarria.sanbong.security.jwt.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity {
    @Bean
    public SecurityFilterChain webFilterChain(HttpSecurity http, DaoAuthenticationProvider authenticationProvider,
                                              JwtUtils jwtUtil) throws Exception {
        Object AbstractHttpConfigurer;
        return http
                .authorizeHttpRequests(cfg -> cfg.requestMatchers(HttpMethod.GET, "/api/**").permitAll())
                .csrf(cfg->cfg.disable())
                .cors(cfg->cfg.disable())
                .sessionManagement(cfg->cfg.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterAt(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
