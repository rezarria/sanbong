package io.rezarria.sanbong.security.service;

import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    @Transactional
    public Stream<Role> getAll() {
        return repository.findAll().stream();
    }

    public Role add(String name) {
        Role role = new Role();
        role.setName(name);
        return repository.save(role);
    }
}
