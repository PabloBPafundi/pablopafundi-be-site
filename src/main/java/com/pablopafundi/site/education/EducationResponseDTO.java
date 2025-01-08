package com.pablopafundi.site.education;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record EducationResponseDTO(

        @JsonProperty("Name") String name,

        @JsonProperty("Description") String description,

        @JsonProperty("DateStart") LocalDate dateStart,

        @JsonProperty("DateEnd") LocalDate dateEnd,

        @JsonProperty("SiteURL") String siteURL

) {
}
