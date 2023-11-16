package org.proggers.backend.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

// TODO: Figure out what is actually needed in this class and what isnt

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = false)
public class WebSecurityBasic {
    @Bean
    @Profile("basic-security")
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
                    .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout((logout) -> logout.permitAll())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
