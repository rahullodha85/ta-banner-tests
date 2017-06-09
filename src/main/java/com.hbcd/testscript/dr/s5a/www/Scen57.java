package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.banner.lazyCalls.Home;
import com.hbcd.base.ScenarioSaks;

public class Scen57 extends ScenarioSaks{
    /*
    "User is returning user on the same machine and browser but not signed into any secure page including checkout
Go to the website Bring mouse on Welcome, Name In in the top nav "

"* ""Welcome, [Name]""  greetings displays in the top nav
* Sign In dropdown displays the following links :
Your Account, Order History, Account and Email Settings, Shipping Address Book, Billing Address Book, Payment Method, Saks First and Online Billing, 'Not [Name] ? Sign Out'
* Verify when user clicks on any links in Sign dropdown that user will be redirected to Account Sign-In link. Only * exception click on SaksFirst and Online Billing link  User redirected to the SaksFirst Home page                   "

     */
    @Override
    public void executeScript() throws Exception {
        nav.HoverOverSignIn();
        ValidateNav.hasLinks("youraccount_vm");
        ValidateNav.hasLinks("orderHistory_vm");
        ValidateNav.hasLinks("accountemailSettings_vm");
        ValidateNav.hasLinks("shippingaddress_book_vm");
        ValidateNav.hasLinks("billingaddress_vm");
        ValidateNav.hasLinks("paymentmethod_vm");
        ValidateNav.hasLinks("saksfirst_onlinebilling");
    }
}
