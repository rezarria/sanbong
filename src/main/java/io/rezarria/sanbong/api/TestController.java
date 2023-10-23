package io.rezarria.sanbong.api;

import io.jsonwebtoken.lang.Collections;
import io.rezarria.sanbong.test.CRepo;
import io.rezarria.sanbong.test.Category;
import io.rezarria.sanbong.test.PRepo;
import io.rezarria.sanbong.test.Product;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    private final CRepo cRepo;
    private final PRepo pRepo;
    private final EntityManager entityManager;

    @GetMapping()
    public ResponseEntity<?> test() throws Exception {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/create")
    public void create() {
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setName("p1");
        p2.setName("p2");
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("c1");
        category2.setName("c2");
        p1.getCategories().add(category1);
        p1.getCategories().add(category2);
        p2.getCategories().add(category2);
        pRepo.save(p1);
        pRepo.save(p2);
    }

    @GetMapping("/create2")
    public void create2() {
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setName("p1");
        p2.setName("p2");
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("c1");
        category2.setName("c2");
        category1.getProducts().add(p1);
        category1.getProducts().add(p2);
        category2.getProducts().add(p1);
        category2.getProducts().add(p2);
        cRepo.saveAll(Collections.of(category1, category2));
    }

    @GetMapping("/all")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(pRepo.findAll());
    }

}
