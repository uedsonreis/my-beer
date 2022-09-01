package com.uedsonreis.mybeer.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    private Long id;
    private String username;
    private String password;
    @Builder.Default
    private Boolean valid = true;

    @Builder.Default
    private Collection<GrantedAuthority> authorities = new ArrayList<>();

    @Builder.Default
    private boolean accountNonExpired = true;

    @Builder.Default
    private boolean accountNonLocked = true;

    @Builder.Default
    private boolean credentialsNonExpired = true;

    @Override
    public boolean isEnabled() {
        return this.valid;
    }
}
