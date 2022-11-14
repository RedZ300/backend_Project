package com.emse.spring.faircorp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";

    @Bean
    public UserDetailsService userDetailsService() {
        // We create a password encoder
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("Admin").password(encoder.encode("adminpwd")).roles(ROLE_ADMIN).build()
        );
        manager.createUser(
                User.withUsername("User").password(encoder.encode("userpwd")).roles(ROLE_USER).build()
        );
        return manager;
    }

    @Bean
    @Order(3)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated()) // (1)
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf().disable()
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain AdminfilterChain(HttpSecurity http) throws Exception {
        return http
                .antMatcher("/api/**") // (2)
                .authorizeRequests(authorize -> authorize.anyRequest().hasAnyRole(ROLE_ADMIN,ROLE_USER)) // (3)
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf().disable()
                .build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain SecurefilterChain(HttpSecurity http) throws Exception {
        return http
                .antMatcher("/secure")
                .authorizeRequests(authorize -> authorize.anyRequest().hasAnyRole(ROLE_ADMIN)) // (3)
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf().disable()
                .build();
    }
}

