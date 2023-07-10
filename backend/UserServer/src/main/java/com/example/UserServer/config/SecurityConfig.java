package com.example.UserServer.config;

import com.example.UserServer.service.PrinciplalOauthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private PrinciplalOauthUserService principlalOauthUserService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.cors().and()
                .csrf().disable()
                .authorizeHttpRequests(auth -> {
                    auth.antMatchers("/").permitAll();
                    auth.antMatchers("/oauth2/**", "/login/**", "/logout/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login()
                    .defaultSuccessUrl("http://localhost:3000/main", true)
                    .userInfoEndpoint()
                        .userService(principlalOauthUserService)
                        .and()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("http://localhost:3000/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");

        return http.build();
    }
}