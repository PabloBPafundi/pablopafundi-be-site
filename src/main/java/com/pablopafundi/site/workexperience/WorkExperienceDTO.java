package com.pablopafundi.site.workexperience;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record WorkExperienceDTO(


        @JsonProperty("Name")
        @NotBlank(message = "Must have a value")
        String name,

        @JsonProperty("Description")
        @NotBlank(message = "Must have a value")
        @Size(max = 400, message = "Description must not exceed 255 characters")
        String description,

        @JsonProperty("DateStarted")
        @NotNull(message = "Must have a value")
        LocalDate dateStart,

        @JsonProperty("DateEnd")
        LocalDate dateEnd,

        @JsonProperty("SiteURL")
        String siteURL






) {
}
