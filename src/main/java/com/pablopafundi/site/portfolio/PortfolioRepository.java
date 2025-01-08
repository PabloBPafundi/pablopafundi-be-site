package com.pablopafundi.site.portfolio;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

    List<Portfolio> findByIsActiveTrueAndLang(LanguageEnum lang);
}
