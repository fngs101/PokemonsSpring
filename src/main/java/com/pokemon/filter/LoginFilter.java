package com.pokemon.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
@Component
public class LoginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("FILTER DLA:     " + request.getRequestURI() + " " + request.getMethod());
        HttpServletRequestWrapper redirectedRequest = new HttpServletRequestWrapper( request){
            @Override
            public String getRequestURI()
            {
                return "/";
            }
        };
        System.out.println(redirectedRequest.getRequestURI());
        filterChain.doFilter(redirectedRequest,servletResponse);
    }

}
