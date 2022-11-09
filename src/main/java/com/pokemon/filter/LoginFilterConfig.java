package com.pokemon.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginFilterConfig
{

    @Bean
    public FilterRegistrationBean<LoginFilter> loggingFilter(final LoginFilter loginFilter)
    {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(loginFilter);
        registrationBean.addUrlPatterns("/app/*");

        return registrationBean;
    }
}
