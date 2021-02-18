package com.bestapp.ordersapp.authentication.controller;

import com.bestapp.ordersapp.authentication.model.dto.JWTokenDTO;
import com.bestapp.ordersapp.authentication.model.dto.LoginRequest;
import com.bestapp.ordersapp.authentication.model.persitance.UserEntity;
import com.bestapp.ordersapp.authentication.service.UserService;
import com.bestapp.ordersapp.security.jwt.JWTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JWTokenProvider tokenProvider;
    private UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JWTokenProvider tokenProvider,
                                    UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider         = tokenProvider;
        this.userService           = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTokenDTO> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateJWToken(authentication);
        return ResponseEntity.ok(new JWTokenDTO(jwt));
    }
}
