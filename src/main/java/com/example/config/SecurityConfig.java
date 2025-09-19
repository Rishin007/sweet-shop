package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for setting up Spring Security.
 * This class defines the security filter chain, user details service for authentication,
 * and the password encoder.
 * {@code @EnableMethodSecurity} allows for method-level security using annotations like @PreAuthorize.
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    /**
     * Defines the primary security configuration for all HTTP requests.
     * This bean configures URL-based authorization rules and the authentication mechanism.
     *
     * @param http The HttpSecurity object to configure.
     * @return The configured SecurityFilterChain object.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    SecurityFilterChain setSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable Cross-Site Request Forgery (CSRF) protection. This is common for stateless APIs.
                .csrf((csrf) -> csrf.disable())
                // Configure authorization rules for HTTP requests.
                .authorizeHttpRequests((authorize) -> authorize
                        // Allow anyone (authenticated or not) to make GET requests to endpoints starting with "/sweets/".
                        // This makes the "read" operations of the API public.
                        .requestMatchers(HttpMethod.GET, "/sweets/**").permitAll()
                        // Require authentication for any other request that hasn't been matched yet (e.g., POST, PUT, DELETE).
                        .anyRequest().authenticated())
                // Enable HTTP Basic Authentication, a simple username/password authentication scheme.
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /**
     * Creates an in-memory user database for authentication.
     * This is useful for development or simple applications without a full database-backed user system.
     *
     * @return A UserDetailsService that manages the in-memory users.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // Create a regular user with the role "USER".
        UserDetails userDetails = User.builder()
                .username("rishin")
                .password(passwordEncoder().encode("rishin_007"))
                .roles("USER")
                .build();

        // Create an administrative user with the role "ADMIN".
        UserDetails adminDetails = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin_007"))
                .roles("ADMIN")
                .build();

        // Return a manager that handles these two users.
        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }

    /**
     * Provides a password encoder bean to the Spring application context.
     * Using a password encoder is a security best practice to store passwords securely.
     * BCrypt is a strong, widely-used hashing algorithm.
     *
     * @return A BCryptPasswordEncoder instance.
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}