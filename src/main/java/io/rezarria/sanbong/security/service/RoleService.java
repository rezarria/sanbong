package io.rezarria.sanbong.security.service;

import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Role add(String name) {
        Role role = new Role();
        role.setName(name);
        return repository.save(role);
    }
}
