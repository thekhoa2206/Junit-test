package com.sapo.controllers;


import com.sapo.config.sercurity.jwt.JwtProvider;
import com.sapo.dto.sercurity.JwtResponse;
import com.sapo.dto.sercurity.LoginForm;
import com.sapo.services.UserService;
import com.sapo.validate.LoginValidate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth/login")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;

    public LoginController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) throws LoginException {
        LoginValidate.loginNotNull(loginRequest);
        LoginValidate.loginNotSpecialCharacters(loginRequest);
        LoginValidate.loginInvalid(loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
