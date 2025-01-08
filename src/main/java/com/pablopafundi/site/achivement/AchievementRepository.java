package com.pablopafundi.site.achivement;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {

    List<Achievement> findByIsActiveTrueAndLang(LanguageEnum languageEnum);
}
