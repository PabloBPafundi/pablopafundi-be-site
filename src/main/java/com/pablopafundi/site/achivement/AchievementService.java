package com.pablopafundi.site.achivement;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class AchievementService {

    private final AchievementMapper achievementMapper;
    private final AchievementRepository achievementRepository;

    public AchievementService(AchievementMapper achievementMapper, AchievementRepository achievementRepository) {
        this.achievementMapper = achievementMapper;
        this.achievementRepository = achievementRepository;
    }

    @Async
    public CompletableFuture<List<AchievementResponseDTO>> getAchievements(LanguageEnum lang) {
        List<AchievementResponseDTO> achievements = achievementRepository.findByIsActiveTrueAndLang(lang).stream().map(achievementMapper::toAchievementResponseDTO).collect(Collectors.toList());
        return CompletableFuture.completedFuture(achievements);
    }


    public AchievementResponseDTO saveAchievement(LanguageEnum lang, AchievementDTO achievementDTO) {
        var achievement = achievementMapper.toAchievement(achievementDTO);
        achievement.setLang(lang);
        return achievementMapper.toAchievementResponseDTO(achievementRepository.save(achievement));

    }


}
