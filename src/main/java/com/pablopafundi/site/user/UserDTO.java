package com.pablopafundi.site.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(

        @JsonProperty("UserName") @NotBlank(message = "UserName must have a valid value") String userName,

        @JsonProperty("Password") @NotBlank(message = "Password must have a valid value") String password,


        @JsonProperty("Role") @NotBlank(message = "Role must have a valid value") Role role

) {
}
