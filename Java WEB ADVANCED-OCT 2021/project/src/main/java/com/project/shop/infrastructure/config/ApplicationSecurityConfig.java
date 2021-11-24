package com.project.shop.infrastructure.config;


import com.project.shop.infrastructure.config.filter.JwtTokenFilter;
import com.project.shop.infrastructure.identity.service.IdentityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenFilter jwtTokenFilter;
   // private final UserDetailsService userDetailsService;
    private final IdentityService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationSecurityConfig(
            JwtTokenFilter jwtTokenFilter,
         //   UserDetailsService userDetailsService,
            IdentityService userDetailsService,
            BCryptPasswordEncoder bCryptPasswordEncoder){
        this.jwtTokenFilter = jwtTokenFilter;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors()
                .and()
                .csrf().disable()
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
               // .and()

                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest().permitAll()
        //           .antMatchers(HttpMethod.GET,"/api/*")

//               .antMatchers(HttpMethod.GET,"/students/*")
//                .hasAnyRole(STUDENT.name(),TEACHER.name())
//                .hasAuthority(STUDENT_READ.getPermission())
//                .anyRequest()
//                .authenticated()
//
//                .and()
//                .formLogin()
//                //  .loginPage("/login").permitAll()

//                .and()
//                .rememberMe()
//                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//                .key("somethingverystrong")
//                .and()
//                  .exceptionHandling().accessDeniedPage("/accessDenied.jsp")
        ;

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.
//                userDetailsService(userDetailsService).
//                passwordEncoder(bCryptPasswordEncoder);
//    }
//    @Override @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
//        dao.setPasswordEncoder(this.bCryptPasswordEncoder);
//        dao.setUserDetailsService(this.identityService);
//        return dao;
//    }
}
