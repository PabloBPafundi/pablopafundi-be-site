package com.pablopafundi.site.user;


import com.pablopafundi.site.common.exception.UserNotFoundException;
import com.pablopafundi.site.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( request.userName(), request.password() ));


        var user =
                userRepository
                .findByUserName(request.userName())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado: " + request.userName()));

        var jwtToken = jwtService.generateToken(user);


        return AuthenticationResponse.builder().token(jwtToken).build();

    }






}
