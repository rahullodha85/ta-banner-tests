package com.hbcd.banner.commomplatform.fullsite.Order;

/**
 * Created by ephung on 9/21/16.
 */
public class Tender {
    String _tenderType = "Master";
    String _cardHolderName = "";
    String _firstName = "Hello";
    String _lastName = "World";
    String _cardNumber = "";
    String _expiredMonth = "";
    String _expiredDay="";
    String _expiredYear = "";
    String _securityCode = "";
    String _cardPinNumber = "";
    int _priority = 1;

    public Tender()
    {

    }

    public Tender(String chn)
    {
        _cardHolderName = chn;
    }

    public Tender setType(String type)
    {
        _tenderType = type;
        switch (type.toUpperCase())
        {
            case "MASTER" :
            case "VISA":
                _priority = 3;
                break;
            case "HOUSECARD":
                _priority = 2;
                break;
            case "GIFTCARD":
                _priority = 1;
                break;
        }
        return this;
    }

    public Tender setFirstName(String fn)
    {
        _firstName = fn;
        return this;
    }

    public Tender setLastName(String ln)
    {
        _lastName = ln;
        return this;
    }

    public Tender setCardNumber(String cn)
    {
        _cardNumber = cn;
        return this;
    }

    public Tender setCardPinNumber(String p)
    {
        _cardPinNumber = p;
        return this;
    }

    public Tender setExpireMonth(String m)
    {
        _expiredMonth = m;
        return this;
    }

    public Tender setExpireDay(String d)
    {
        _expiredDay = d;
        return this;
    }

    public Tender setExpireYear(String y)
    {
        _expiredYear = y;
        return this;
    }

    public Tender setCardSecurityCode(String sc)
    {
        _securityCode = sc;
        return this;
    }

    public Tender setCardHolderName(String chn)
    {
        _cardHolderName = chn;
        return this;
    }

    public String getFirstName()
    {
        return _firstName;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public String getCardNumber()
    {
        return _cardNumber;
    }

    public String getCardPinNumber() { return _cardPinNumber; }

    public String getExpireMonth()
    {
        return _expiredMonth;
    }

    public String getExpireDay()
    {
        return _expiredDay;
    }

    public String getExpireYear()
    {
        return _expiredYear;
    }

    public String getCardSecurityCode()
    {
        return _securityCode;
    }

    public String getTenderType()
    {
        return _tenderType;
    }

    public int getPriority()
    {
        return _priority;
    }

    public String getCardHolderName ()
    {
        return _cardHolderName;
    }
}
