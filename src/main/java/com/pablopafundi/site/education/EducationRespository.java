package com.pablopafundi.site.education;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRespository extends JpaRepository<Education, Integer> {

    List<Education> findTop4ByIsActiveAndLangOrderByDateStartDesc(Boolean isActive, LanguageEnum lang);

}
