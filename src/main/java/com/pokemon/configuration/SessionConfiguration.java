package com.pokemon.configuration;

import com.pokemon.state.SessionState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SessionConfiguration
{
    @Bean
    @SessionScope
    public SessionState getSessionState()
    {
        return new SessionState();
    }
}
