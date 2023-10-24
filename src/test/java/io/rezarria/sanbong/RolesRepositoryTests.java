package io.rezarria.sanbong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.RoleRepository;

@SpringBootTest
public class RolesRepositoryTests {

    @Autowired
    private RoleRepository repository;

    private List<String> names = new ArrayList<>();

    Collection<Role> gen() {
        Collection<Role> roles = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Role role = new Role();
            role.setName("ROLE_TEST" + i);
            names.add("ROLE_TEST" + i);
            roles.add(role);
        }
        return roles;
    }

    @Test
    void add() {
        Collection<Role> roles = gen();

        roles = repository.saveAll(roles);
        Assertions.assertTrue(names.containsAll(roles.stream().map(Role::getName).distinct().sorted().toList()));
    }

    @Test

    void delete() {
        Collection<Role> roles = gen();
        repository.saveAll(roles);
        repository.deleteAll(repository.findAllByNameIn(names));
    }

    @AfterEach
    void clean() {
        repository.deleteAll(repository.findAllByNameIn(names));
    }

}
