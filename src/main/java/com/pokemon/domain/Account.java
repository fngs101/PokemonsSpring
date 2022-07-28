package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account
{
    @Id
    private String email;
    private String password;

    public Account(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    Account()
    {

    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
