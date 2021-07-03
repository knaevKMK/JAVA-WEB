package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ApplicationUserPermission.*;
import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
//aa
//USE with @PreAuthorised
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                // Cross-Site Request Forgery:
                // enabled - for browser clients
                // disbled - for NON browser clients
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index", "/css/","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())

                //replace with @PreAuthorised in StudentManagementController.java

//                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(),MODERATOR.name())

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
               // .roles("ADMIN")
                .authorities(ADMIN.getGrantedAuthority())
                .build();

        UserDetails  studentAna = User.builder()
                .username("ana")
                .password(passwordEncoder.encode("123"))
          //      .roles("STUDENT")
                .authorities(STUDENT.getGrantedAuthority())
                .build();

        UserDetails  moderator = User.builder()
                .username("mode")
                .password(passwordEncoder.encode("123"))
   //             .roles("MODERATOR")
                .authorities(MODERATOR.getGrantedAuthority())
                .build();
        return new InMemoryUserDetailsManager(studentAna,admin,moderator);
    }
}
