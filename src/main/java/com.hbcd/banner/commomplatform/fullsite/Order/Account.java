package com.hbcd.banner.commomplatform.fullsite.Order;

/**
 * Created by ephung on 9/21/16.
 */
public class Account {
    String _login = "";
    String _password = "";

    public Account setLogin (String l)
    {
        _login = l;
        return this;
    }

    public Account setPassword(String p)
    {
        _password = p;
        return this;
    }

    public String getLogin()
    {
        return _login;
    }

    public String getPassword()
    {
        return _password;
    }

}
