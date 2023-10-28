package com.ilacad.employeeapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class EmployeeSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager () {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);

    }


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer -> {
            configurer
                    .requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "employees/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN");

        });
        
        httpSecurity.httpBasic(Customizer.withDefaults());


        return httpSecurity.build();

    }

}
