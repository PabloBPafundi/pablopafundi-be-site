package com.pablopafundi.site.achivement;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchivementRespository extends JpaRepository<Achivement, Integer> {

    List<Achivement> findByIsActiveTrueAndLang(LanguageEnum languageEnum);
}
