package com.pablopafundi.site.knowledge;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }


    @PostMapping("/{lang}/knowledges")
    public KnowledgeResponseDTO saveKnowledge(@Valid @RequestBody KnowledgeDTO klDTO, @Valid @PathVariable("lang") LanguageEnum lang){

        return this.knowledgeService.saveKnowledge(klDTO, lang);
    }

    /*
    @GetMapping("/public/{lang}/knowledges")
    public List<KnowledgeResponseDTO> findByIsActiveTrue(@Valid @PathVariable("lang") LanguageEnum lang) {
        return knowledgeService.findByIsActiveTrue(lang);
    }
    */

    @GetMapping("/public/{lang}/knowledges")
    public CompletableFuture<ResponseEntity<List<KnowledgeResponseDTO> >> findByIsActiveTrue(@PathVariable("lang") LanguageEnum lang) {
        return knowledgeService.findByIsActiveTrue(lang)
                .thenApply(ResponseEntity::ok);
    }




}
