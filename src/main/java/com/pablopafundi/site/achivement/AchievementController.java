package com.pablopafundi.site.achivement;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class AchievementController {

    private final AchievementService achievementService;


    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("public/{lang}/achievements")
    public CompletableFuture<ResponseEntity<List<AchievementResponseDTO>>> getAchievements(@PathVariable("lang") LanguageEnum lang) {
        return achievementService.getAchievements(lang)
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping("/{lang}/achievements")
    public ResponseEntity<AchievementResponseDTO> saveAchievement(@PathVariable("lang") LanguageEnum lang,@Valid @RequestBody AchievementDTO achievementDTO){
        return ResponseEntity.ok(achievementService.saveAchievement(lang, achievementDTO));
    }



}
