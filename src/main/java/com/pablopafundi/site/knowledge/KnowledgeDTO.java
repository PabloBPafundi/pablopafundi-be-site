package com.pablopafundi.site.knowledge;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record KnowledgeDTO(


        @JsonProperty("Name") @NotBlank(message = "Name must be a valid value") String name,


        @JsonProperty("SkillType") @NotNull(message = "SkillType must be a valid value") SkillType skillType,


        @JsonProperty("SkillLevel") @NotNull(message = "SkillLevel must be a valid value") SkillLevel skillLevel) {


}
