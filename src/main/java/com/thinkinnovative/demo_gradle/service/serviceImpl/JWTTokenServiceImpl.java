package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.AuthRequestDTO;
import com.thinkinnovative.demo_gradle.entity.User;
import com.thinkinnovative.demo_gradle.repository.UserRepository;
import com.thinkinnovative.demo_gradle.security.JWTUtil;
//import com.thinkinnovative.demo_gradle.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JWTTokenServiceImpl {

    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public JWTTokenServiceImpl(UserRepository userRepository, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(AuthRequestDTO authRequest) {
        Optional<User> userOptional = userRepository.findByUsername(authRequest.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                return jwtUtil.generateToken(user.getUsername()); // Return JWT Token
            }
        }
        throw new RuntimeException("Invalid Credentials");
    }

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash Password
        userRepository.save(user);
    }
}
