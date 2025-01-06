package com.pablopafundi.site.portfolio;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    /*
    @GetMapping("public/{lang}/portfolio")
    public ResponseEntity<List<PortfolioResponseDTO>> getPortfolio(@PathVariable("lang") LanguageEnum lang){
        return ResponseEntity.ok(portfolioService.getPortfolio(lang));
    }*/

    @GetMapping("public/{lang}/portfolio")
    public CompletableFuture<ResponseEntity<List<PortfolioResponseDTO>>> getAchievements(@PathVariable("lang") LanguageEnum lang) {
        return portfolioService.getPortfolio(lang)
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping("/{lang}/portfolio")
    public ResponseEntity<PortfolioResponseDTO> savePortfolio(@PathVariable("lang") LanguageEnum lang,@Valid @RequestBody PortfolioDTO portfolioDTO){
        return ResponseEntity.ok(portfolioService.savePortfolio(lang, portfolioDTO));
    }

}
