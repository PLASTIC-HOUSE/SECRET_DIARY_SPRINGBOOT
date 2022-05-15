package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.response.ErrorResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GlobalExceptionHandlingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (GlobalException e) {
            response.setStatus(e.getStatus());
            response.setContentType("application/json");
            response.getWriter().println(new ErrorResponse(e.getStatus(), e.getMessage()));
        }
    }

}
