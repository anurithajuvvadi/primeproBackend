package com.example.demo.config;

import com.example.demo.exceptionHandler.CustomAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    CustomAuthenticationFailureHandler authenticationFailureHandler;
    @Bean
    public UserDetailsService getUserDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()).cors().and().authorizeHttpRequests((auth) ->
                        auth
//                                .requestMatchers("/admin/**", "/courses/**","/trainers/**")
                                .requestMatchers( "/courses/**","/trainers/**").hasRole("ADMIN")
                                .requestMatchers("/user/**").hasRole("USER")
                                .requestMatchers("/home/**","/auth/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin((login) ->
                        login.loginPage("/login")
                                .loginProcessingUrl("/auth/login")
                                .usernameParameter("email")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/home/")
                                .failureUrl("/auth/login?error=true")
                                .failureHandler(authenticationFailureHandler) // Add this line
                                .permitAll()) // Add this line for error handling)
                .httpBasic().and()
                .logout((logout) ->
                        logout.permitAll());
        return http.build();
    }


}
