package com.pablopafundi.site.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public record AuthenticationRequest (
        @JsonProperty("UserName")
        @NotBlank(message = "Username must have a valid value")
        String userName,

        @JsonProperty("Password")
        @NotBlank(message = "Password must have a valid value")
        String password
){}
