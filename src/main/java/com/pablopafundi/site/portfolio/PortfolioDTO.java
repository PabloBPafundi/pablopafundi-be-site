package com.pablopafundi.site.portfolio;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PortfolioDTO(

        @JsonProperty("Name") @NotBlank(message = "Name must have a valid value") String name,

        @JsonProperty("Description") @NotBlank(message = "Description must have a valid value") String description,

        @JsonProperty("DateCompleted") @NotNull(message = "DateCompleted must have a valid value") LocalDate dateCompleted,

        @JsonProperty("URLRepository") @NotBlank(message = "URLRepository must have a valid value") String urlRepository


) {
}
