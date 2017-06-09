package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.ForgotPasswordPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 3/3/2016.
 */
public class ForgotPasswordPage extends ForgotPasswordPageBase {
    @Override
    public void ClickContinue(String email) throws Exception {
        if (Find.Object("fpp_Email").isPresent()) {
            Find.Object("fpp_Email").input(email);
        } else {
            Report.fail("Email textbox is not present on forgot password page");
        }
        if (Find.Object("fpp_ContinueBtn").isPresent()) {
            Report.pass("Continue button found and clicked");
            Find.Object("fpp_ContinueBtn").click();
        } else {
            Report.fail("Continue button is not present on forgot password page");
        }
    }

    @Override
    public void ClickBackToSigIn() throws Exception {
        if (Find.Object("fpp_BackToSignIn").isPresent()) {
            Report.pass("Back to Sign-In link found and clicked");
            Find.Object("fpp_BackToSignIn").click();
        } else {
            Report.fail("Back to Sign-In link is not present on forgot password page");
        }
    }

    @Override
    public void ClickContinueShopping() throws Exception {
        if (Find.Object("fpp_ContinueShoppingBtn").isPresent()) {
            Report.pass("Continue shopping button found and clicked");
        } else {
            Report.fail("Continue shopping button is not present");
        }
    }

    @Override
    public void IsForgotPasswordPage() throws Exception {
        if (Find.Object("fpp_Title").isPresent()) {
            Report.pass("User is on forgot password page");
        } else {
            Report.fail("User is not on forgot password page");
        }
    }

    @Override
    public void IsMessageTextPresent(String email) throws Exception {
        if (Find.Object("fpp_Message").isPresent()) {
            if (Find.Object("fpp_Message").getText().value().contains(email)) {
                Report.pass("Password reset email sent to " + email +
                        " text is present");
            } else {
                Report.fail("Password reset email message text does not" +
                        "contain entered email: " + email);
            }
        } else {
            Report.fail("Pasword reset email sent" +
                    " message text is not present on forgot password page");
        }
    }

    @Override
    public void EnterEmail(String email) throws Exception {
        if (Find.Object("fpp_Email").isPresent()) {
            Find.Object("fpp_Email").input(email);
        } else {
            Report.fail("Email textbox is not present on forgot password page");
        }
    }

    @Override
    public void ErrorTextPresent(String text) throws Exception {
        if (Find.Object("fpp_Error").isPresent()) {
            if (Find.Object("fpp_Error").getText().value().contains(text)) {
                Report.pass("Field validation error message text verified");
            } else {
                Report.fail("Field validation error message: " + Find.Object("fpp_Error").getText().value() +
                        " does not match expected error text: " + text);
            }
        } else {
            Report.fail("Field validation error message is not present on Forgot Password Page");
        }
    }
}
