package com.uedsonreis.mybeer.service;

import com.uedsonreis.mybeer.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final User admin = User.builder()
            .id(1l)
            .username("uedsonreis")
            .password(this.passwordEncoder().encode("123456"))
            .valid(true)
            .build();

    public UserService() {
        this.admin.getAuthorities().add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "GENERAL_ROLE";
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (this.admin.getUsername().equals(username)) return this.admin;
        throw new UsernameNotFoundException("Username "+ username +" was not found");
    }
}
