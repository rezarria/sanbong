package io.rezarria.sanbong.api.system;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.rezarria.sanbong.security.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create() {
        return ResponseEntity.ok().build();
    }

    @PatchMapping(consumes = "application/json-patch+json", produces = "application/json")
    public ResponseEntity<?> update() {
        return ResponseEntity.ok().build();
    }

}
