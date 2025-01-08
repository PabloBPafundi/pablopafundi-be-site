package com.pablopafundi.site.knowledge;


import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;
    private final KnowledgeMapper knowledgeMapper;

    public KnowledgeService(KnowledgeRepository knowledgeRepository, KnowledgeMapper knowledgeMapper) {
        this.knowledgeRepository = knowledgeRepository;
        this.knowledgeMapper = knowledgeMapper;
    }


    public KnowledgeResponseDTO saveKnowledge(KnowledgeDTO klDTO, LanguageEnum lang) {
        var knowledge = knowledgeMapper.toKnowledge(klDTO);
        knowledge.setLang(lang);
        var savedKnowledge = knowledgeRepository.save(knowledge);
        return knowledgeMapper.toKnowledgeResponseDTO(savedKnowledge);

    }


    @Async
    public CompletableFuture<List<KnowledgeResponseDTO>> findByIsActiveTrue(LanguageEnum lang) {
        List<KnowledgeResponseDTO> knowledge = knowledgeRepository.findByIsActiveTrueAndLang(lang).stream().map(knowledgeMapper::toKnowledgeResponseDTO).collect(Collectors.toList());

        return CompletableFuture.completedFuture(knowledge);
    }


}
