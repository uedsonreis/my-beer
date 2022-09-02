package com.uedsonreis.mybeer.config;

import com.uedsonreis.mybeer.service.UserService;
import io.github.uedsonreis.libwscrud.api.config.security.AbstractWebConfig;
import io.github.uedsonreis.libwscrud.api.config.security.RequestFilter;
import io.github.uedsonreis.libwscrud.api.config.security.TokenManager;
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
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class WebConfig extends AbstractWebConfig {

    public WebConfig(UserService userService, TokenManager tokenManager, RequestFilter requestFilter) {
        super(userService, tokenManager, requestFilter);
    }

    @Override
    protected Set<String> getPermitedURLs() {
        Set<String> permited = new HashSet<>();
        permited.add("/login");
        return permited;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.addFilter(new AuthenticationFilter(this.tokenManager, authenticationManagerBean()));
    }

}
