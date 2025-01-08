package com.pablopafundi.site.keygeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class KeyGenerationController {

    private final KeyGenerationService keyGenerationService;

    public KeyGenerationController(KeyGenerationService keyGenerationService) {
        this.keyGenerationService = keyGenerationService;
    }

    @GetMapping("/keys/generate")
    public ResponseEntity<String> generateKey(@RequestParam KeySize keySize) {
        String generatedKey = keyGenerationService.generateKey(keySize);
        return ResponseEntity.ok(generatedKey);
    }
}