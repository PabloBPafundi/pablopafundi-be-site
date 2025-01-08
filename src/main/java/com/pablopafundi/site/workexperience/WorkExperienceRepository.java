package com.pablopafundi.site.workexperience;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {

    List<WorkExperience> findTop4ByIsActiveAndLangOrderByDateStartDesc(Boolean isActive, LanguageEnum lang);

}
