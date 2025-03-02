package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.AuthRequestDTO;
import com.thinkinnovative.demo_gradle.dto.MemberListDTO;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import com.thinkinnovative.demo_gradle.entity.User;
import com.thinkinnovative.demo_gradle.repository.MemberRepository;
import com.thinkinnovative.demo_gradle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final PasswordHashServiceImpl passwordHashService;


    public User registerUser(AuthRequestDTO request) {

        MemberTable  memberTable = memberRepository.findMemberEntityByID(request.getMemberId());
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordHashService.encodePassword(request.getPassword()))
                .email(request.getEmail())
                .role(request.getRole())
                .member(memberTable).build();
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setEmail(request.getEmail());
//        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
