package com.example.springboot.Exercise1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuongiornoController {
    @GetMapping("/info")
    ResponseEntity<String> responseInfo(){
        return ResponseEntity.ok("200 - OK");
    }
}
