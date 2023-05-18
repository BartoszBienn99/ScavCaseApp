package com.tarkov.ScavCaseApp.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        InitializingBean bean = () -> {
            UserDetails bb = User
                    .builder()
                    .passwordEncoder(password -> PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password))
                    .password("11217")
                    .roles("User")
                    .username("bb")
                    .build();
            userDetailsManager.createUser(bb);
        };
        return bean;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic();
        httpSecurity
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        return httpSecurity.build();
    }

}

