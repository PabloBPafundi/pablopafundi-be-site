package com.pablopafundi.site.myprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.constraints.NotBlank;

public record MyProfileDTO
        (


                @JsonProperty("Residency") @NotBlank(message = "Residency must be a valid value") String residency,

                @JsonProperty("AboutMe") @NotBlank(message = "AboutMe must be a valid value") String aboutMe,

                @JsonProperty("Language") LanguageEnum lang


        ) {
}
