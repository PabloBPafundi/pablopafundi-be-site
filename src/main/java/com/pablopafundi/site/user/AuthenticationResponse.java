package com.pablopafundi.site.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public record AuthenticationResponse(
        String token
)
{}
