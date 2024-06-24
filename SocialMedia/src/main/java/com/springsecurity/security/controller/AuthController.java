package com.springsecurity.security.controller;

import com.springsecurity.security.auth.AuthenticationRequest;
import com.springsecurity.security.auth.AuthenticationResponse;
import com.springsecurity.security.jwt.JwtUtils;
import com.springsecurity.security.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    private MyUserDetailServiceImpl userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, MyUserDetailServiceImpl userService){
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            System.out.println("Attempting to authenticate user: " + authenticationRequest.getUsername());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            System.out.println("Authentication failed for user: " + authenticationRequest.getUsername());
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails);
        System.out.println("User authenticated successfully, JWT generated");

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
