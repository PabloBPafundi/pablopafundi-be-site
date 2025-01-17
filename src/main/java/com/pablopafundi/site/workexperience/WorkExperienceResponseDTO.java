package com.pablopafundi.site.workexperience;

import com.fasterxml.jackson.annotation.JsonProperty;



import java.time.LocalDate;

public record WorkExperienceResponseDTO(


        @JsonProperty("Name")
        String name,

        @JsonProperty("Description")
        String description,

        @JsonProperty("DateStarted")
        LocalDate dateStart,

        @JsonProperty("DateEnd")
        LocalDate dateEnd,

        @JsonProperty("SiteURL")
        String siteURL


) {
}
