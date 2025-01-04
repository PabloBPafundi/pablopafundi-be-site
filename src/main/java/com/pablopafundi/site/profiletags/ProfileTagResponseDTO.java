package com.pablopafundi.site.profiletags;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProfileTagResponseDTO(

        @JsonProperty("ProfileTagName")
        String profileTag,

        @JsonProperty("ProfileTagId")
        Integer profileTagId,

        @JsonProperty("ProfileId")
        Integer profileID

) {
}
