package io.rezarria.sanbong.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping()
    public ResponseEntity<?> test() throws Exception {
        if (true) {
            throw new Exception();
        }
        return ResponseEntity.badRequest().build();
    }
}
