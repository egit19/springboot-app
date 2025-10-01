package com.consistech.springboot_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/home","/api/greetings").permitAll()  // bebas diakses
                .anyRequest().authenticated()              // sisanya butuh login
            )
            .formLogin(login -> login.permitAll())         // aktifkan halaman login
            .httpBasic(basic -> {});                       // aktifkan Basic Auth

        return http.build();
    }
}

