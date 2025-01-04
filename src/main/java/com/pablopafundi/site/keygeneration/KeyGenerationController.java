package com.pablopafundi.site.keygeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class KeyGenerationController {

    private final KeyGenerationService keyGenerationService;

    @Autowired
    public KeyGenerationController(KeyGenerationService keyGenerationService) {
        this.keyGenerationService = keyGenerationService;
    }

    /*
    *
    * GET /public/keys/generate?keySize=BITS_256
    *
    * */

    @GetMapping("/keys/generate")
    public ResponseEntity<String> generateKey(@RequestParam KeySize keySize) {
        String generatedKey = keyGenerationService.generateKey(keySize);
        return ResponseEntity.ok(generatedKey);
    }
}