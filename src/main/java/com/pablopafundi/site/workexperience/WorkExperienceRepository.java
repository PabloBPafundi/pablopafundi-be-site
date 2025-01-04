package com.pablopafundi.site.workexperience;

import java.util.List;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {

    List<WorkExperience> findTop4ByIsActiveAndLangOrderByDateStartDesc(Boolean isActive, LanguageEnum lang);


}
