package com.pablopafundi.site.profiletags;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfileTagDTO(

        @JsonProperty("ProfileTagName")
        @NotBlank(message = "ProfileTagName must be a valid value")
        String profileTag,

        @JsonProperty("ProfileId")
        @NotNull(message = "ProfileId must be a valid value")
        Integer profileID

) {
}
