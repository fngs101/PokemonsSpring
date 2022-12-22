package com.pokemon.service;

import com.pokemon.domain.Account;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.exception.AuthorizationServiceException;
import com.pokemon.repository.AccountRepository;
import com.pokemon.repository.PokemonCollectorRepository;
import com.pokemon.request.LoginRequest;
import com.pokemon.request.RegisterRequest;
import com.pokemon.state.SessionState;
import groovy.util.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.function.Supplier;

@Service
public class AuthorizationService
{
    private AccountRepository accountRepository;
    private PokemonCollectorRepository pokemonCollectorRepository;
    @Resource(name = "getSessionState")
    private SessionState sessionState;

    public AuthorizationService(AccountRepository accountRepository, PokemonCollectorRepository pokemonCollectorRepository)
    {
        this.accountRepository = accountRepository;
        this.pokemonCollectorRepository = pokemonCollectorRepository;
    }


    public void register(RegisterRequest registerRequest) throws AuthorizationServiceException
    {
        validatePassword(registerRequest);
        validateEmail(registerRequest);

        PokemonCollector pokemonCollector = new PokemonCollector();
        pokemonCollectorRepository.save(pokemonCollector);

        Account account = new Account(registerRequest.getEmail(), registerRequest.getPassword(), pokemonCollector);
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
        sessionState.login(getAccountById(loginRequest.getEmail()));

    }

    private void validateLogin(LoginRequest loginRequest) throws AuthorizationServiceException
    {
        Account account = getAccountById(loginRequest.getEmail());
        if(!account.getPassword().equals(loginRequest.getPassword()))
        {
            throw new AuthorizationServiceException("Wrong email or password");
        }

    }

    private Account getAccountById(String id) throws AuthorizationServiceException
    {
        return accountRepository.findById(id).orElseThrow(()-> new AuthorizationServiceException("Wrong email or password"));
    }

    public int getPokemonCollectorId()
    {
        return sessionState.getAccount().getPokemonCollector().getId();
    }

    public boolean isUserLoggedIn()
    {
        return sessionState.getAccount() != null;
    }


}
