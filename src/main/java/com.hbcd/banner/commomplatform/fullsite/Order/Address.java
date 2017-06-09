package com.hbcd.banner.commomplatform.fullsite.Order;

/**
 * Created by ephung on 9/21/16.
 */
public class Address {
    String _firstName = "Hello";
    String _lastName = "World";
    String _line1 = "";
    String _line2 = "";
    String _city = "";
    String _state = "";
    String _zipcode = "";

    public Address setLine1(String l1)
    {
        _line1 = l1;
        return this;
    }

    public Address setLine2(String l2)
    {
        _line2 = l2;
        return this;
    }

    public Address setCity(String c)
    {
        _city = c;
        return this;
    }

    public Address setState(String s)
    {
        _state = s;
        return this;
    }

    public Address setZipCode(String zc)
    {
        _zipcode = zc;
        return this;
    }

    public String getLine1()
    {
        return _line1;
    }

    public String getLine2()
    {
        return _line2;
    }

    public String getCity()
    {
        return _city;
    }

    public String getState()
    {
        return _state;
    }

    public String getZipCode()
    {
        return _zipcode;
    }
}
