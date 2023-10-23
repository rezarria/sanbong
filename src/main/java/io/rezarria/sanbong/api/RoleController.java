package io.rezarria.sanbong.api;

import io.rezarria.sanbong.security.model.Role;
import io.rezarria.sanbong.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;


@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public DeferredResult<?> getAll() throws Exception {
        DeferredResult<List<Role>> deferredResult = new DeferredResult<>();
        deferredResult.setResult(roleService.getAll().toList());
        return deferredResult;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestParam String name) {
        return ResponseEntity.ok(roleService.add(name));
    }
}
