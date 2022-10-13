package com.pokemon.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
@Component
@Order(1)
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
                return "/hello";
            }
        };
        filterChain.doFilter(redirectedRequest,servletResponse);
    }
}
