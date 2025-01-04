package com.pablopafundi.site.portfolio;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PortfolioResponseDTO(
        @JsonProperty("Name")
        @NotBlank(message = "Name must have a valid value")
        String name,

        @JsonProperty("Description")
        @NotBlank(message = "Description must have a valid value")
        String description,

        @JsonProperty("DateCompleted")
        @NotBlank(message = "DateCompleted must have a valid value")
        LocalDate dateCompleted,

        @JsonProperty("URLRepository")
        @NotBlank(message = "URLRepository must have a valid value")
        String urlRepository


) {
}
