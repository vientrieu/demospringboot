package com.example.demospringboot.config;

import com.example.demospringboot.dto.UserAuthentication;
import com.example.demospringboot.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Component
public class JWTFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("Init jwt filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        try {
            String token = httpRequest.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");
            Map<String, Object> payload = jwtUtil.getPayloadJwt(token);
            UserAuthentication user = objectMapper.convertValue(payload.get("user"), UserAuthentication.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            // do nothing
        } finally {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("Destroy jwt filter");
    }
}
