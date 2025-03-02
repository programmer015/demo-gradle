package com.thinkinnovative.demo_gradle.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("InSecurityFilterChain");
        http
                .csrf(csrf -> csrf.disable())
                // ❌ Disable CSRF (important for API)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 🛑 Prevent session-based auth
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/auth/register").permitAll()// ✅ Allow public access to /auth
                        .requestMatchers("/member/addMember").permitAll()
                        .requestMatchers("/member/member/upload-excel").permitAll()
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
