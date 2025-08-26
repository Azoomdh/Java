package com.example.demoJava3.Login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    
    @Bean
    UserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider 
            = new DaoAuthenticationProvider(this.userDetailsService() );
        authProvider.setPasswordEncoder(this.passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                auth -> auth
                    .requestMatchers("/register").permitAll()
                    .requestMatchers("/").hasAnyAuthority("CLIENT", "STAFF", "ADMIN")
                    .requestMatchers("/create/**", "/edit/**").hasAnyAuthority("STAFF", "ADMIN")
                    .requestMatchers("/delete/**").hasAnyAuthority("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(login-> login.permitAll())
            .logout(logout-> logout.permitAll())
            .exceptionHandling(eh-> eh.accessDeniedPage("/403"))
            ;
        return http.build();
    }
}
