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
                .antMatchers(HttpMethod.GET, "/account").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.GET, "/account/**").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.POST, "/user/").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.PUT, "/user/edit/**").hasAnyAuthority("admin", "writeEdit")
                .antMatchers(HttpMethod.DELETE, "/user/delete/**").hasAuthority("admin")
                .antMatchers(HttpMethod.GET, "/countries").hasAnyAuthority("admin", "readWrite", "writeEdit", "justview")
                .antMatchers(HttpMethod.GET, "/countries/**").hasAnyAuthority("admin", "readWrite", "writeEdit", "justview")
                .antMatchers(HttpMethod.POST, "/countries/").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.PUT, "/countries/edit/**").hasAnyAuthority("admin", "writeEdit")
                .antMatchers(HttpMethod.DELETE, "/countries/delete/**").hasAuthority("admin")
                .antMatchers(HttpMethod.GET, "/adresses").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.GET, "/adresses/**").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.POST, "/adresses/").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.PUT, "/adresses/edit/**").hasAnyAuthority("admin", "writeEdit")
                .antMatchers(HttpMethod.DELETE, "/adresses/delete/**").hasAuthority("admin")
                .antMatchers(HttpMethod.GET, "/shipping").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.GET, "/shipping/**").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.POST, "/shipping/").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.PUT, "/shipping/edit/**").hasAnyAuthority("admin", "writeEdit")
                .antMatchers(HttpMethod.DELETE, "/shipping/delete/**").hasAuthority("admin")
                .antMatchers(HttpMethod.GET, "/city").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.GET, "/city/**").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.POST, "/city/").hasAnyAuthority("admin", "readWrite", "writeEdit")
                .antMatchers(HttpMethod.PUT, "/city/edit/**").hasAnyAuthority("admin", "writeEdit")
                .antMatchers(HttpMethod.DELETE, "/city/delete/**").hasAuthority("admin")
                .anyRequest().authenticated()
                .and().formLogin();
    }
    }