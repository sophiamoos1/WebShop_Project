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
import org.springframework.web.cors.CorsConfiguration;

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
        CorsConfiguration cors = new CorsConfiguration().applyPermitDefaultValues();
        cors.addAllowedMethod("DELETE");
        cors.addAllowedMethod("POST");
        cors.addAllowedMethod("PUT");
        cors.addExposedHeader("token");
        cors.addAllowedHeader("Authorization");
        http.cors().configurationSource(request -> cors);
        http.csrf().disable().httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/account").hasAnyAuthority("all")
                .antMatchers(HttpMethod.GET, "/account/**").hasAnyAuthority("all", "user1")
                .antMatchers(HttpMethod.POST, "/account/").permitAll()
                .antMatchers(HttpMethod.PUT, "/account/edit/**").hasAnyAuthority("all", "user1")
                .antMatchers(HttpMethod.DELETE, "/account/delete/**").hasAnyAuthority("all", "user1")
                .antMatchers(HttpMethod.GET, "/product/all").hasAnyAuthority("all", "user1")
                .antMatchers(HttpMethod.GET, "/product/**").hasAnyAuthority("all", "user1")
                .antMatchers(HttpMethod.POST, "/product/").hasAuthority("all")
                .antMatchers(HttpMethod.PUT, "/product/edit/**").hasAuthority("all")
                .antMatchers(HttpMethod.DELETE, "/product/delete/**").hasAuthority("all")
                .anyRequest().authenticated()
                .and().formLogin();
    }
    }