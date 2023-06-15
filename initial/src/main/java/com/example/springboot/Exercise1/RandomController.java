package com.example.springboot.Exercise1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

    @GetMapping("/random")
    public ResponseEntity<String> ResponseRandom(){
        boolean randomBoolean = Math.random() < 0.5;
            if (randomBoolean) {return ResponseEntity.status(200).body("OK - Tutto benone");}
            else {return ResponseEntity.status(400).body("Bad request - Male");}
        }
    }
