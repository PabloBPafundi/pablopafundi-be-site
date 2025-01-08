package com.pablopafundi.site.achivement;


import org.springframework.stereotype.Service;

@Service
public class AchievementMapper {

    public Achievement toAchievement(AchievementDTO achievementDTO) {
        return new Achievement(achievementDTO.name(), achievementDTO.description());
    }

    public AchievementResponseDTO toAchievementResponseDTO(Achievement achievement) {
        return new AchievementResponseDTO(achievement.getName(), achievement.getDescription());
    }

}
