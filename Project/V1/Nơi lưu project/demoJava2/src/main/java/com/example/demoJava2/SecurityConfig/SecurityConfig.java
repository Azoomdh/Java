package com.example.demoJava2.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(this.userDetailsService() );
        authProvider.setPasswordEncoder(this.passwordEncoder());

        return authProvider;
    }

    // phân quyền URL theo vai trò (xem sau)
    // https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                auth-> auth
                    .requestMatchers("/register", "/css/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(
                login-> login.permitAll()
            )
            .logout(
                logout-> logout.permitAll()
            )
        ;

        return http.build();
    }
}
