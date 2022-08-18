package com.example.demo.SecurityPackage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/account").hasAnyAuthority("manager")
                .antMatchers(HttpMethod.GET, "/account/**").hasAnyAuthority("manager", "user1")
                .antMatchers(HttpMethod.POST, "/account/").permitAll()
                .antMatchers(HttpMethod.PUT, "/account/edit/**").hasAnyAuthority("manager", "user1")
                .antMatchers(HttpMethod.DELETE, "/account/delete/**").hasAnyAuthority("manager", "user1")
                .antMatchers(HttpMethod.GET, "/product/all").hasAnyAuthority("manager", "user1")
                .antMatchers(HttpMethod.GET, "/product/**").hasAnyAuthority("manager", "user1")
                .antMatchers(HttpMethod.POST, "/product/").hasAuthority("manager")
                .antMatchers(HttpMethod.PUT, "/product/edit/**").hasAuthority("manager")
                .antMatchers(HttpMethod.DELETE, "/product/delete/**").hasAuthority("manager")
                .anyRequest().authenticated()
                .and().formLogin();
    }
    }