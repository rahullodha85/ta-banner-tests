package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.SignInPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 1/21/2016.
 * * This page is for Common Platform Accounts project only, these functions will not work with old saks fifth UI
 */
public class SignInPage extends SignInPageBase {
    @Override
    public void LoginWith(String uname, String passwd)
            throws Exception {
        if (Find.Object("sip_Email").isPresent()) {
            Find.Object("sip_Email").input(uname);
        } else {
            Report.fail("Email textbox not present on sign-in page");
        }
        if (Find.Object("sip_Password").isPresent()) {
            Find.Object("sip_Password").input(passwd);
        } else {
            Report.fail("Password textbox not present on sign-in page");
        }
        if (Find.Object("sip_SignInBtn").isPresent()) {
            Find.Object("sip_SignInBtn").click();
        } else {
            Report.fail("Sign-in button not present on sign-in page");
        }
    }

    @Override
    public void ClickCreateAccountBtn() throws Exception {
        if (Find.Object("sip_CreateAccountBtn").isPresent()) {
            Report.pass("Create Account button found and clicked");
            Find.Object("sip_CreateAccountBtn").click();
        } else {
            Report.fail("Create Account button is not present on Sign-In Page");
        }
    }

    @Override
    public void ClickForgotPwdLink() throws Exception {
        if (Find.Object("sip_ForgotPwd").isPresent()) {
            Report.pass("Forgot password link found and clicked");
            Find.Object("sip_ForgotPwd").click();
        } else {
            Report.fail("Forgot password link is not present on Sign-In page");
        }
    }

    @Override
    public  void IsSignInPage() throws Exception {
        if (Find.Object("sip_Title").isPresent()) {
            Report.pass("User is on sign-in page");
        } else {
            Report.fail("User is not on sign-in page");
        }
    }

    @Override
    public  void IsSignInSectionPresent() throws Exception {
        if (Find.Object("sip_SignInSection").isPresent()) {
            Report.pass("Sign-in section is present on Sign-In page");
        } else {
            Report.fail("Sign-in section is not present on Sign-In page");
        }
    }

    @Override
    public  void IsCreateAccountSectionPresent() throws Exception {
        if (Find.Object("sip_CreateAccountSection").isPresent()) {
            Report.pass("Create Account section is present on Sign-In page");
        } else {
            Report.fail("Create Account section is not present on Sign-In page");
        }
    }

    @Override
    public  void IsErrorTextPresent(String text) throws Exception {
        if (Find.Object("sip_Error").isPresent()) {
            if (Find.Object("sip_Error").getText().value().contains(text)) {
                Report.pass("Error message displayed with expected text " + text);
            } else {
                Report.fail("Error message text does not match expected text " + text);
            }
        } else {
            Report.fail("Error message not present on Sign-In Page");
        }
    }

    @Override
    public  void IsEmailErrorTextPresent(String text) throws Exception {
        if (Find.Object("sip_EmailError").isPresent()) {
            if (Find.Object("sip_EmailError").getText().value().contains(text)) {
                Report.pass("Email textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("Email textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("Email textbox is required field error message is not present on Sign-In Page");
        }
    }

    @Override
    public  void IsPwdErrorTextPresent(String text) throws Exception {
        if (Find.Object("sip_PwdError").isPresent()) {
            if (Find.Object("sip_PwdError").getText().value().contains(text)) {
                Report.pass("Password textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("Password textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("Password textbox is required field error message is not present on Sign-In Page");
        }
    }

    @Override
    public  void IsCreateAccountBtnPresent() throws Exception {
        if (Find.Object("sip_CreateAccountBtn").isPresent()) {
            Report.pass("Create Account button is present on Sign-In page");
        } else {
            Report.fail("Create Account button is not present on Sign-In page");
        }
    }

    @Override
    public void CheckOrderStatus(String orderNum, String zip) throws Exception {
        if(Find.Object("sip_OrderNum").isPresent()){
            Find.Object("sip_OrderNum").clear();
            Find.Object("sip_OrderNum").input(orderNum);
        }
        if(Find.Object("sip_OrderZip").isPresent()){
            Find.Object("sip_OrderZip").clear();
            Find.Object("sip_OrderZip").input(zip);
        }
        ClickSubmit();
    }

    @Override
    public void IsOrderNumErrorTextPresent(String text) throws Exception {
        if(Find.Object("sip_OrderNumError").isPresent()) {
            if(Find.Object("sip_OrderNumError").getText().value().contains(text)) {
                Report.pass("Order Number field validation error text is present");
            } else {
                Report.fail("Order Number field validation error text: "
                        + Find.Object("sip_OrderNumError").getText().value() +
                " Expected Error text: " + text);
            }
        } else {
            Report.fail("Order Number field validation error text is not present");
        }
    }

    @Override
    public void IsBillingZipErrorTextPresent(String text) throws Exception {
        if(Find.Object("sip_OrderZipError").isPresent()) {
            if(Find.Object("sip_OrderZipError").getText().value().contains(text)) {
                Report.pass("Order Zip field validation error text is present");
            } else {
                Report.fail("Order Zip field validation error text: "
                        + Find.Object("sip_OrderNumError").getText().value() +
                        " Expected Error text: " + text);
            }
        } else {
            Report.fail("Order Zip field validation error text is not present");
        }
    }

    @Override
    public void ClickSubmit() throws Exception {
        if(Find.Object("sip_SubmitBtn").isPresent()){
            Find.Object("sip_SubmitBtn").click();
        }
    }
}