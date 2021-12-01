package com.project.shop.config.security;


import com.project.shop.config.filter.JwtTokenFilter;
import com.project.shop.identityArea.service.IdentityService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenFilter jwtTokenFilter;
    private final IdentityService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationSecurityConfig(
            JwtTokenFilter jwtTokenFilter,
            IdentityService userDetailsService,
            BCryptPasswordEncoder bCryptPasswordEncoder){
        this.jwtTokenFilter = jwtTokenFilter;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/*","/**","/api/**").permitAll()
                .anyRequest().permitAll()
                .and()

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
