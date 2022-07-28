package com.pokemon.service;

import com.pokemon.domain.Account;
import com.pokemon.exception.AuthorizationServiceException;
import com.pokemon.repository.AccountRepository;
import com.pokemon.request.LoginRequest;
import com.pokemon.request.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class AuthorizationService
{
    private AccountRepository accountRepository;

    public AuthorizationService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public void register(RegisterRequest registerRequest) throws AuthorizationServiceException
    {
        validatePassword(registerRequest);
        validateEmail(registerRequest);

        Account account = new Account(registerRequest.getEmail(), registerRequest.getPassword());
        accountRepository.save(account);

    }
    private void validatePassword(RegisterRequest registerRequest) throws AuthorizationServiceException
    {
        if(!registerRequest.getPassword().equals(registerRequest.getPasswordRepeat()))
        {
            throw new AuthorizationServiceException("Passwords are not equal");
        }
    }

    private void validateEmail(RegisterRequest registerRequest) throws AuthorizationServiceException
    {
        if(!registerRequest.getEmail().matches("^(.+)@(.+)$"))
        {
            throw new AuthorizationServiceException("E-mail is not valid");
        }
        if(accountRepository.existsById(registerRequest.getEmail()))
        {
            throw new AuthorizationServiceException("E-mail already exists");
        }
    }

    public void login(LoginRequest loginRequest) throws AuthorizationServiceException
    {
        validateLogin(loginRequest);
    }

    private void validateLogin(LoginRequest loginRequest) throws AuthorizationServiceException
    {
        Account account = accountRepository.findById(loginRequest.getEmail()).orElseThrow(()-> new AuthorizationServiceException("Wrong email or password"));
        if(!account.getPassword().equals(loginRequest.getPassword()))
        {
            throw new AuthorizationServiceException("Wrong email or password");
        }

    }


}
