package com.pablopafundi.site.achivement;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AchievementDTO(


        @JsonProperty("Name")
        String name,

        @JsonProperty("Description")
        String description


) {
}
