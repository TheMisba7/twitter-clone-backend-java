package org.mansar.twitterjava.config;

import lombok.RequiredArgsConstructor;
import org.mansar.twitterjava.security.filter.JwtAuthorizationFilter;
import org.mansar.twitterjava.security.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    public static final String [] ALLOWED_REQUEST = {"/login", "/register"};
    private final LoginFilter loginFilter;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
        https.addFilter(loginFilter).addFilter(jwtAuthorizationFilter);
        https.csrf(AbstractHttpConfigurer::disable);
        https.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return https.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
