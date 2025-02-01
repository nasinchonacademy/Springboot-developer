package org.zerock.springbootdeveloper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExTestController {

    @GetMapping("/extest")
    public ResponseEntity<String> Extest(@RequestParam("code") int code) {
        switch (code) {
            case 1:
            return ResponseEntity.created(null).body("Created!");
            case 2:
            return ResponseEntity.badRequest().body("Bad Request!");
            default:
            return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/extest")
    public ResponseEntity<String> Extest2(@RequestBody Code code) {

        switch (code.value()) {
            case 1:
            return ResponseEntity.status(403).body("Forbidden!");
            default:
            return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value) {}