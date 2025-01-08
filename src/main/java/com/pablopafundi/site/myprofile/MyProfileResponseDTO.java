package com.pablopafundi.site.myprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablopafundi.site.profiletags.ProfileTagResponseDTO;

import java.util.List;

public record MyProfileResponseDTO(


        @JsonProperty("ProfileId") Integer profileId,

        @JsonProperty("Residency") String residency,

        @JsonProperty("AboutMe") String aboutMe,

        @JsonProperty("ProfileImage") String profileImageUrl,

        @JsonProperty("ProfileTags") List<ProfileTagResponseDTO> profileTags


) {
}
