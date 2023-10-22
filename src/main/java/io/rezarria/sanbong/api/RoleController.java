package io.rezarria.sanbong.api;

import io.rezarria.sanbong.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAll() throws Exception {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestParam String name) {
        return ResponseEntity.ok(roleService.add(name));
    }
}
