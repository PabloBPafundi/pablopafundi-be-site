package com.pablopafundi.site.knowledge;


import org.springframework.stereotype.Service;

@Service
public class KnowledgeMapper {


    public KnowledgeResponseDTO toKnowledgeResponseDTO(Knowledge kl){

       return new KnowledgeResponseDTO(kl.getId(), kl.getName(), kl.getSkillType(), kl.getSkillLevel());


    }

    public Knowledge toKnowledge(KnowledgeDTO klDTO){

      return new Knowledge(klDTO.name(), klDTO.skillType(), klDTO.skillLevel());



    }

}
