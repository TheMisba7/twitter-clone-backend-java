package org.mansar.twitterjava.config;

import lombok.RequiredArgsConstructor;
import org.mansar.twitterjava.security.filter.JwtAuthorizationFilter;
import org.mansar.twitterjava.security.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    public static final String [] ALLOWED_REQUEST = {"/login", "/register", "/swagger-ui/**", "/v3/**"};
    private final LoginFilter loginFilter;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
        https.addFilter(loginFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        https.csrf(AbstractHttpConfigurer::disable);
        https.cors(crs -> crs.configurationSource(corsConfig()));
        https.authorizeHttpRequests(
                cst ->
                        cst.requestMatchers(ALLOWED_REQUEST).permitAll()
                        .requestMatchers("/api/users", HttpMethod.POST.name())
                        .permitAll()
                        .anyRequest().authenticated()
        );
        https.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return https.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    private CorsConfigurationSource corsConfig() {
        return request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("*"));
                config.setAllowedMethods(List.of("*"));
                config.setAllowedHeaders(List.of("*"));
                return config;
            };
    }
}
