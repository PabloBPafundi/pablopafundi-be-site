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
    private final AchivementRespository achivementRespository;

    public AchievementService(AchievementMapper achievementMapper, AchivementRespository achivementRespository) {
        this.achievementMapper = achievementMapper;
        this.achivementRespository = achivementRespository;
    }

    @Async
    public CompletableFuture<List<AchievementResponseDTO>> getAchievements(LanguageEnum lang) {
        List<AchievementResponseDTO> achievements = achivementRespository.findByIsActiveTrueAndLang(lang)
                .stream()
                .map(achievementMapper::toAchievementResponseDTO)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(achievements);
    }




    public AchievementResponseDTO saveAchievement(LanguageEnum lang, AchievementDTO achievementDTO){
        var achievement = achievementMapper.toAchivement(achievementDTO);
        achievement.setLang(lang);
        return achievementMapper.toAchievementResponseDTO(achivementRespository.save(achievement));

    }



}
