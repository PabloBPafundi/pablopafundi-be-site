package com.pablopafundi.site.achivement;


import org.springframework.stereotype.Service;

@Service
public class AchievementMapper {

    public Achivement toAchivement(AchievementDTO achievementDTO){
        return new Achivement(achievementDTO.name(), achievementDTO.description());
    }


    public AchievementResponseDTO toAchievementResponseDTO(Achivement achivement){

        return new AchievementResponseDTO(achivement.getName(), achivement.getDescription());
    }

}
