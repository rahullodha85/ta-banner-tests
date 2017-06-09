package com.hbcd.banner.commomplatform.fullsite.Order;

/**
 * Created by ephung on 9/21/16.
 */
public class Item {
    String _upc = "";
    int _colorSwatchIndex = 0;
    int _sizeSwatchIndex = 0;
    int _quantity = 1;

    public Item()
    {

    }

    public Item (String upc)
    {
        _upc = upc;
    }

    public Item setUPC(String upc)
    {
        _upc = upc;
        return this;
    }

    public Item setColorSwatchIndex(int idx)
    {
        _colorSwatchIndex = idx;
        return this;
    }

    public Item setSizeOrDenominationSwatchIndex(int idx)
    {
        _sizeSwatchIndex = idx;
        return this;
    }

    public Item setQuantity (int q)
    {
        _quantity = q;
        return this;
    }

    public String getUPC ()
    {
        return _upc;
    }

    public int getColorSwatchIndex()
    {
        return _colorSwatchIndex;
    }

    public int getSizeOrDenominationSwatchIndex()
    {
        return _sizeSwatchIndex;
    }

    public int getQuantity()
    {
        return _quantity;
    }
}
