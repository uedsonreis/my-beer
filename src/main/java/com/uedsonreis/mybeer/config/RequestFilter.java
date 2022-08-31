package com.uedsonreis.mybeer.config;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uedsonreis.mybeer.entity.User;
import com.uedsonreis.mybeer.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class RequestFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final TokenManager tokenManager;

    public RequestFilter(UserService userService, TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {

            String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
                jwtToken = jwtToken.substring(7);
                User user = null;

                try {
                    String username = this.tokenManager.getLoggedUsername(jwtToken);
                    user = (User) this.userService.loadUserByUsername(username);
                } catch (Exception e) {
                    System.err.println("Bad request: "+ e.getMessage());
                }

                if (user != null) {
                    UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(userToken);
                }
            }
        }
        chain.doFilter(request, response);
    }

}