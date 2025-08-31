package com.example.demoJava4.Login;

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
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(this.userDetailsService());
        authProvider.setPasswordEncoder(this.passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            auth-> auth
                .requestMatchers("/register").anonymous()
                .requestMatchers("/").authenticated()
                .requestMatchers("/create/**", "/edit/**").hasAnyAuthority("NHANVIEN", "ADMIN")
                .requestMatchers("/delete/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
        );
        
        http.formLogin(
            login-> login.permitAll()
        );
        
        http.logout(
            logout-> logout.permitAll()
        );

        http.exceptionHandling(
            eh-> eh.accessDeniedPage("/403")
        );
        
        return http.build();
    }
}
