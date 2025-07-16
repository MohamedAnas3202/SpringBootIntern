package com.training.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
public class SpringConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){          //BCryptPasswordEncoder hashes passwords for secure storage.
        return new BCryptPasswordEncoder();
    }

    @Bean//This class will define beans (objects managed by Spring).
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.
                csrf((csrf)->csrf.disable()) //lambda functon->disable the csrf to disable sign in form
//                .authorizeHttpRequests(auth-> {
//                    auth.requestMatchers(HttpMethod.POST,"/employee/createEmployee").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.PUT,"/employee").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.DELETE,"/employee/deleteEmployee").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN","USER");
//                    auth.anyRequest().authenticated();
//                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetails(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails Arun = User.builder()
                .username("Arun")
                .password(passwordEncoder().encode("Arun"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,Arun);

    }
}