package com.project.shop.config.security;


import com.project.shop.config.filter.JwtTokenFilter;
import com.project.shop.identityArea.service.IdentityService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenFilter jwtTokenFilter;
    private final IdentityService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationSecurityConfig(
            JwtTokenFilter jwtTokenFilter,
            IdentityService userDetailsService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtTokenFilter = jwtTokenFilter;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http  .csrf().disable();
        http.httpBasic().disable();
        http    .cors()  .configurationSource(corsConfigurationSource())// We need to add CORS support to Spring Security (see https://stackoverflow.com/a/67583232/4964553)
//                .and()
//                .authorizeRequests()
//
//                .antMatchers("/api/**").permitAll()
//                .antMatchers("/usr/**").permitAll() // allow every URI, that begins with '/api/user/'
//                .antMatchers("/listing/**").permitAll() // allow every URI, that begins with '/api/user/'
//                .antMatchers("/orders/**").permitAll()
//                .anyRequest().permitAll()
//               ;
        ; // disable cross site request forgery, as we don't use cookies - otherwise ALL PUT, POST, DELETE will get HTTP 403!
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(List.of(
                HttpMethod.GET.name(),
                HttpMethod.PUT.name(),
                HttpMethod.POST.name(),
                HttpMethod.DELETE.name()
        ));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
        return source;
    }
}