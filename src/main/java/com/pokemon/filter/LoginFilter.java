package com.pokemon.filter;

import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;


@Component
public class LoginFilter implements Filter
{

    private final AuthorizationService authorizationService;

    public LoginFilter(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("FILTER DLA:     " + request.getRequestURI() + " " + request.getMethod());
        if(!authorizationService.isUserLoggedIn())
        {
            HttpServletRequestWrapper redirectedRequest = new HttpServletRequestWrapper(request)
            {
                @Override
                public String getRequestURI()
                {
                    return "/";
                }
            };
            System.out.println(redirectedRequest.getRequestURI());
            filterChain.doFilter(redirectedRequest, servletResponse);
        }
        else
        {
            filterChain.doFilter(request, servletResponse);
        }
    }

}
