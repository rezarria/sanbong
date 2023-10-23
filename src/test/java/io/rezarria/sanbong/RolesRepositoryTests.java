package io.rezarria.sanbong;

import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.repository.RoleRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;

@SpringBootTest
public class RolesRepositoryTests {

    @Autowired
    private RoleRepository repository;

    @Test
    void add() {
        Collection<Role> roles = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Role role = new Role();
            role.setName("ROLE_TEST" + i);
            roles.add(role);
        }
        roles = repository.saveAll(roles);
        Assertions.assertEquals(5, roles.stream().map(Role::getId).distinct().count());
    }

    @AfterAll
    void clean() {
    }

}
