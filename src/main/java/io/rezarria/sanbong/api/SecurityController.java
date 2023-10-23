package io.rezarria.sanbong.api;

import io.rezarria.sanbong.security.service.SecurityService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/security")
@RequiredArgsConstructor
public class SecurityController {
    private final SecurityService securityService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(securityService.getAllAccount().stream().map(i -> (long) i.getRoles().size()));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        Map<String, String> json = new HashMap<>();
        json.put("jwt", securityService.login(dto.getUsername(), dto.getPassword()));
        return ResponseEntity.ok(json);
    }


    @GetMapping("/checkInfo")
    public ResponseEntity<?> check() {
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        return ResponseEntity.ok(securityService.register(dto.getUsername(), dto.getPassword()));
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class RegisterDTO {
        private String username;
        private String password;
    }
}
