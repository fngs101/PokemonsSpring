package com.pokemon.service;

import com.pokemon.exception.RegisterServiceException;
import com.pokemon.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class RegisterService
{
    public void register(RegisterRequest registerRequest) throws RegisterServiceException
    {
        validatePassword(registerRequest);
        validateEmail(registerRequest);

    }
    private void validatePassword(RegisterRequest registerRequest) throws RegisterServiceException
    {
        if(!registerRequest.getPassword().equals(registerRequest.getPasswordRepeat()))
        {
            throw new RegisterServiceException("Passwords are not equal");
        }
    }

    private void validateEmail(RegisterRequest registerRequest) throws RegisterServiceException
    {
        if(!registerRequest.getEmail().matches("^(.+)@(.+)$"))
        {
            throw new RegisterServiceException("E-mail is not valid");
        }
    }
}
