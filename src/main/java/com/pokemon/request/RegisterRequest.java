package com.pokemon.request;

public class RegisterRequest
{
    private String email;
    private String password;
    private String passwordRepeat;

    public RegisterRequest(String email, String password, String passwordRepeat)
    {
        this.email = email;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }

    public RegisterRequest()
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

    public String getPasswordRepeat()
    {
        return passwordRepeat;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setPasswordRepeat(String passwordRepeat)
    {
        this.passwordRepeat = passwordRepeat;
    }
}
