package com.pablopafundi.site.contact;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactResponseDTO(

        @JsonProperty("Channel")
        @NotNull(message = "Channel must have a value")
        ContactChannel channel,

        @JsonProperty("Contact")
        @NotBlank(message = "Contact must have a value")
        String contactDescription,


        @JsonProperty("URL")
        String url



) {
}
