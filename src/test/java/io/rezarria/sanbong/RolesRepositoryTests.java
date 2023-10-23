package io.rezarria.sanbong;

import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.RoleRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class RolesRepositoryTests {

    @Autowired
    private RoleRepository repository;

    private List<String> names;

    @Test
    void add() {
        Collection<Role> roles = new HashSet<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Role role = new Role();
            role.setName("ROLE_TEST" + i);
            names.add("ROLE_TEST" + i);
            roles.add(role);
        }
        roles = repository.saveAll(roles);
        Assertions.assertTrue(names.containsAll(roles.stream().map(Role::getName).distinct().sorted().toList()));
    }


}
