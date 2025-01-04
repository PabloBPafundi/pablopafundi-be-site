package com.pablopafundi.site.achivement;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AchievementController {

    private final AchievementService achievementService;


    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("public/{lang}/achievements")
    public ResponseEntity<List<AchievementResponseDTO>> getAchievements(@PathVariable("lang") LanguageEnum lang){
        return ResponseEntity.ok(achievementService.getAchievements(lang));
    }

    @PostMapping("/{lang}/achievements")
    public ResponseEntity<AchievementResponseDTO> saveAchievement(@PathVariable("lang") LanguageEnum lang,@Valid @RequestBody AchievementDTO achievementDTO){
        return ResponseEntity.ok(achievementService.saveAchievement(lang, achievementDTO));
    }



}
