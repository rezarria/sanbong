package io.rezarria.sanbong.security.service;

import io.rezarria.sanbong.security.model.RegisterTemplate;
import io.rezarria.sanbong.security.repository.RegisterTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterTemplateService {
    private final RegisterTemplateRepository registerTemplateRepository;

    public Optional<RegisterTemplate> add(RegisterTemplate template) {
        try {
            registerTemplateRepository.save(template);
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.of(template);
    }

    public Optional<RegisterTemplate> getNewest() {
        return registerTemplateRepository.findFirstByOrderByCreatedDateDesc();
    }
}
