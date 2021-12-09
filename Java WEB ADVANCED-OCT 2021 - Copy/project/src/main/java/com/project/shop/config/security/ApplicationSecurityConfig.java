package com.project.shop.config.security;


import com.project.shop.config.JWT.JwtAuthenticationEntryPoint;
import com.project.shop.config.JWT.JwtTokenFilter;
import com.project.shop.identityArea.service.IdentityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenFilter jwtTokenFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final IdentityService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationSecurityConfig(
            JwtTokenFilter jwtTokenFilter,
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, IdentityService userDetailsService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtTokenFilter = jwtTokenFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        //   http.httpBasic().disable();
        http
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAfter(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)

                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/*","/listing/**","/orders/**","/usr/**","/help").permitAll()
              //  .antMatchers(HttpMethod.POST, "/usr/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/identity/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/identity/login", "/api/identity/register").permitAll()
                .antMatchers(HttpMethod.GET, "/api/categories/all", "/api/condition/all", "/api/delivery/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/feedback/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/payments/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/listings/listing/*", "/api/listings/all").permitAll()
                .antMatchers(HttpMethod.POST, "/api/listings/adv-search").permitAll()
                .antMatchers(HttpMethod.GET, "/api/selling-format/all").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
        ;
    }




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}