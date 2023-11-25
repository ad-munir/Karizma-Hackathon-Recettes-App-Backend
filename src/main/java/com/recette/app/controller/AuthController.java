package com.recette.app.controller;

import com.recette.app.dto.AuthResponse;
import com.recette.app.dto.AuthRequest;
import com.recette.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

//    @PostMapping("/register")
//    private ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest request) {
//
//        return ResponseEntity.ok(service.register(request));
//    }
//
//    @PostMapping("/authenticate")
//    private ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
//
//        return ResponseEntity.ok(service.authenticate(request));
//    }


}