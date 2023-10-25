package io.rezarria.sanbong.service;

import io.rezarria.sanbong.model.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FieldServiceTests {

    @Autowired
    private FieldService service;

    @Test
    @Order(1)
    public void add() {
        Assertions.assertDoesNotThrow(() -> {
            service.create("test0", null, null);
        });
        Assertions.assertDoesNotThrow(() -> {
            List<Field> fields = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                Field field = new Field();
                field.setName("test" + i);
                fields.add(field);
            }
        });
    }

    @Test
    @Order(2)
    public void get() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("test" + i);
        }
        Assertions.assertEquals(5, service.getManyByName(list).size());
    }

    @Test
    @Order(3)
    public void delete() {
        Assertions.assertDoesNotThrow(() -> {
            service.remove("test0");
        });
        Assertions.assertDoesNotThrow(() -> {
            List<String> lists = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                lists.add("test" + i);
            }
            service.remove(lists);
        });
    }
}
