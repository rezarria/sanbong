package io.rezarria.sanbong.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.rezarria.sanbong.security.model.RegisterTemplate;
import io.rezarria.sanbong.security.repository.RegisterTemplateRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterTemplateService {
    private final RegisterTemplateRepository repository;

    public Optional<RegisterTemplate> add(RegisterTemplate template) {
        try {
            repository.save(template);
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.of(template);
    }

    public Optional<RegisterTemplate> getNewest() {
        return repository.findFirstByOrderByTimeDesc();
    }
}
