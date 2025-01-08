package com.pablopafundi.site.achivement;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AchievementResponseDTO(

        @JsonProperty("Name") String name,

        @JsonProperty("Description") String description

) {
}
