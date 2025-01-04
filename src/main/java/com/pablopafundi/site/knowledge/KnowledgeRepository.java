package com.pablopafundi.site.knowledge;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Integer> {


    List<Knowledge> findByIsActiveTrueAndLang(LanguageEnum lang);

}
