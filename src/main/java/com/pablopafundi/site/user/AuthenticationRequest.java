package com.pablopafundi.site.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record AuthenticationRequest (
        @JsonProperty("UserName")
        @NotBlank(message = "Username must have a valid value")
        String userName,

        @JsonProperty("Password")
        @NotBlank(message = "Password must have a valid value")
        String password
){}
