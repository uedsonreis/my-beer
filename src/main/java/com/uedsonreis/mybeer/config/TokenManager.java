package com.uedsonreis.mybeer.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.uedsonreis.mybeer.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenManager {

    public static final long VALIDITY = 60 * 60 * 1000; // 1 hour

    @Value("${app.api.security.jwt.secret}")
    private String secret;

    public String generateToken(User user, String url) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret.getBytes());

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + VALIDITY))
                .withIssuer(url)
                .withClaim("roles", user
                        .getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(algorithm);
    }

    public String getLoggedUsername(String token) {
        if (JWT.decode(token).getExpiresAt().before(new Date())) {
            throw new RuntimeException("Token has expired");
        }
        return JWT.decode(token).getSubject();
    }

}
