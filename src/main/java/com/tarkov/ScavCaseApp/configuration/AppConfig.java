package com.tarkov.ScavCaseApp.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public UserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager();
    }

    @Bean
    InitializingBean initializingBean(UserDetailsManager userDetailsManager) {
        return  () -> {
            UserDetails admin = User
                    .builder()
                    .passwordEncoder(password -> PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password))
                    .password("11217")
                    .roles("Admin")
                    .username("admin")
                    .build();
            userDetailsManager.createUser(admin);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout();

        httpSecurity
                .csrf()
                .disable();

        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/login")
                .hasRole("Admin")
                .anyRequest()
                .authenticated();
        return httpSecurity.build();
    }

}

