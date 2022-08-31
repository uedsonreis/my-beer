package com.uedsonreis.mybeer.config;

import com.uedsonreis.mybeer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final TokenManager tokenManager;
    private final RequestFilter requestFilter;

    public WebConfig(UserService userService, TokenManager tokenManager, RequestFilter requestFilter) {
        this.userService = userService;
        this.tokenManager = tokenManager;
        this.requestFilter = requestFilter;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers("/login", "/v1/users").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(this.requestFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilter(new AuthenticationFilter(this.tokenManager, authenticationManagerBean()));
    }

}