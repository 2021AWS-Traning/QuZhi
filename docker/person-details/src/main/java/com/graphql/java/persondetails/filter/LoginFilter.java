package com.graphql.java.persondetails.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class LoginFilter implements Filter {
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Optional<String> optionalAuth = Optional.ofNullable(httpServletRequest.getHeader(AUTHORIZATION));
        optionalAuth.ifPresent(auth-> {
            try {
                chain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                log.error("filter execute failed");
            }
        });
    }
}
