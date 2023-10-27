package io.rezarria.sanbong.service;

import io.rezarria.sanbong.model.Field;
import io.rezarria.sanbong.repository.FieldRepository;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class FieldServiceTests {

    @Autowired
    private FieldService service;

    @Autowired
    private FieldRepository repository;

    private void gen(int n) {
        List<Field> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Field.builder().name("test" + i).build());
        }
        repository.saveAll(list);
    }

    private void del(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add("test" + i);
        }
        repository.deleteAllByNameIn(list);
    }

    @BeforeEach
    private void setupAdd() {

    }

    @Test
    @Order(1)
    @DisplayName("add")
    public void add() {
        Assertions.assertDoesNotThrow(() -> {
            for (int i = 0; i < 5; i++) {
                service.create("test" + i, "", "");
            }
        });
    }

    @AfterEach
    private void cleanUpAdd() {
        del(5);
    }

    @BeforeEach
    private void setupGet() {
        gen(6);
    }

    @Test
    @Order(2)
    @DisplayName("get")
    public void get() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("test" + i);
        }
        Assertions.assertEquals(5, service.getManyByName(list).size());
    }

    @AfterEach
    private void cleanUpGet() {
        del(6);
    }

    @BeforeEach
    private void setUpDelete() {
        gen(7);
    }

    @Test
    @Order(3)
    @DisplayName("delete")
    public void delete() {
        for (int i = 0; i < 7; i++)
            service.remove("test" + i);
    }

    @AfterEach
    private void cleanUpDelete() {
        del(7);
    }
}
