package com.pablopafundi.site.user;


import lombok.Builder;


@Builder
public record AuthenticationResponse(String token) {
}
