package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.AuthRequestDTO;
import com.thinkinnovative.demo_gradle.entity.User;
import com.thinkinnovative.demo_gradle.security.JWTUtil;
import com.thinkinnovative.demo_gradle.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceImpl userService;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

//    public AuthController(UserServiceImpl userService, JWTUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.jwtUtil = jwtUtil;
//        this.passwordEncoder = passwordEncoder;
//    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequestDTO request) {
        userService.registerUser(request);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        Optional<User> user = userService.findByUsername(request.get("username"));

        if (user.isPresent() && passwordEncoder.matches(request.get("password"), user.get().getPassword())) {
            return jwtUtil.generateToken(request.get("username"));
        }

        return "Invalid username or password!";
    }
}

