package com.pablopafundi.site.education;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EducationDTO(


        @JsonProperty("Name")
        @NotBlank(message = "Must have a value")
        String name,

        @JsonProperty("Description")
        String description,

        @JsonProperty("DateStart")
        @NotNull(message = "Must have a value")
        LocalDate dateStart,

        @JsonProperty("DateEnd")
        LocalDate dateEnd,

        @JsonProperty("SiteURL")
        String siteURL

) {
}
