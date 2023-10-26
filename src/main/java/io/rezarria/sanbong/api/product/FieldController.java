package io.rezarria.sanbong.api.product;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import io.rezarria.sanbong.api.product.FieldDTO.CreateDTO;
import io.rezarria.sanbong.api.product.FieldDTO.DeleteDTO;
import io.rezarria.sanbong.model.Field;
import io.rezarria.sanbong.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/field")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(fieldService.getAll());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody CreateDTO dto) {
        fieldService.create(dto.getName(), dto.getPicture(), dto.getDescription());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(consumes = "application/json")
    public ResponseEntity<?> delete(@RequestBody DeleteDTO dto) {
        fieldService.remove(dto.getId());
        return ResponseEntity.ok().build();
    }

    @PatchMapping(consumes = "application/json-patch+json")
    public ResponseEntity<?> update(@RequestParam UUID id, @RequestBody JsonPatch patch) {
        Field field = fieldService.get(id);
        JsonNode nodePatched = patch.apply(objectMapper.convertValue(field, JsonNode.class))
        return ResponseEntity.ok().build();
    }
}
