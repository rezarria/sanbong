package io.rezarria.sanbong.api.product;

import io.rezarria.sanbong.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/field")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(fieldService.getAll());
    }
}
