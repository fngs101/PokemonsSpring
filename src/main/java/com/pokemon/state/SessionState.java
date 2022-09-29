package com.pokemon.state;

import com.pokemon.domain.Account;

import java.time.LocalDateTime;

public class SessionState
{
    private Account account;
    private LocalDateTime dateTime;

    public void login(Account account)
    {
        this.account = account;
        dateTime = LocalDateTime.now();
    }

    @Override
    public String toString()
    {
        return "SessionState{" +
                "account=" + account +
                ", dateTime=" + dateTime +
                '}';
    }

    public Account getAccount()
    {
        return account;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }
}
