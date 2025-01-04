package com.pablopafundi.site.portfolio;

import com.pablopafundi.site.achivement.AchievementDTO;
import com.pablopafundi.site.achivement.AchievementResponseDTO;
import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("public/{lang}/portfolio")
    public ResponseEntity<List<PortfolioResponseDTO>> getPortfolio(@PathVariable("lang") LanguageEnum lang){
        return ResponseEntity.ok(portfolioService.getPortfolio(lang));
    }

    @PostMapping("/{lang}/portfolio")
    public ResponseEntity<PortfolioResponseDTO> savePortfolio(@PathVariable("lang") LanguageEnum lang,@Valid @RequestBody PortfolioDTO portfolioDTO){
        return ResponseEntity.ok(portfolioService.savePortfolio(lang, portfolioDTO));
    }

}
