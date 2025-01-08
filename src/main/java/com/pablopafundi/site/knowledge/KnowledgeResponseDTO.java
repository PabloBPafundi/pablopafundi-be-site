package com.pablopafundi.site.knowledge;

import com.fasterxml.jackson.annotation.JsonProperty;


public record KnowledgeResponseDTO(


        @JsonProperty("KnowledgeId") Integer knowledgeId,


        @JsonProperty("Name") String name,


        @JsonProperty("SkillType") SkillType skillType,


        @JsonProperty("SkillLevel") SkillLevel skillLevel

) {
}
