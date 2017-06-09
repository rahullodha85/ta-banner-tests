package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.banner.validations.common.ValidateBagPage;
import com.hbcd.commonbanner.base.overlays.LoginOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by 461967 on 6/6/2016.
 */
public class LoginOverlay extends LoginOverlayBase {
    @Override
    public void LoginWith(String username, String password) throws Exception{
        Find.Object("bagLoginEmailTxt").clear();
        Find.Object("bagLoginEmailTxt").input(username);
        Find.Object("bagLoginPassTxt").clear();
        Find.Object("bagLoginPassTxt").input(password);

        StepLogger.validate(Check.ObjectPresent, "bagSignInBtn");

        Find.Object("bagSignInBtn").click();

        if (Find.Object("saksBagAdditionalItemError_wk").isPresent()
                &&
                Find.Object("saksBagAdditionalItemError_wk").validateWithPresetData())
        {
            if (Find.Object("bagCheckoutLoggedInBtn").isPresent())
            {
                Find.Object("bagCheckoutLoggedInBtn").click();
            }
        }
    }

    @Override
    public void LoginWith(String email) throws Exception{
        Thread.sleep(5000);
        if(email.contains("newcheckout")){ //after checkout enhancement
            StepLogger.validate(Check.ObjectPresent, "loginOverlayCheckoutAsGuestBtn_wk");
            Find.Object("loginOverlayCheckoutAsGuestBtn_wk").click();
        } else { //old checkout
            Find.Object("bagEmailSigninTxt").input(email);
            Find.Object("bagEmailSigninBtn").click();
        }
    }
    @Override
    public void ClickForgotPassword() throws Exception{
        Find.Object("bagoForgotPasswordBtn_wk").click();
    }
    @Override
    public void IsInvalidEmail() {
        StepLogger.validate(Check.TextPresent, "bagEmailInvalidMessage", "valid email address");
    }

    public void IsInvalidPassword() {
        StepLogger.validate(Check.TextPresent, "bagPasswordInvalidMessage", "Password error message displayed");
    }
    @Override
    public void forgotPassword(String email) throws Exception {
        Find.Object("lgnForgotPasswordBtn").click();
        Find.Object("lgnEmailTxt").input(email);
        StepLogger.validate(Check.ObjectPresent, "fogotPwdContinueBtn_WS");
        Find.Object("fogotPwdContinueBtn_WS").click();

    }
    @Override
    public void LoginWithPassword(String password) {

    }
    @Override
    public void LoginWithPaypal(String username, String password) {

    }
    @Override
    public void LoginThruCC(String email) throws Exception {
        Find.Object("bagLoginEmailTxt").input(email);
        StepLogger.validate(Check.ObjectPresent, "bagSignInBtn");

        Find.Object("bagSignInBtn").click();
        if(Find.Object("saksBagAdditionalItemError_wk").isPresent() &&
                Find.Object("saksBagAdditionalItemError_wk").validateWithPresetData()){
            if(Find.Object("bagCheckoutLoggedInBtn").isPresent())
                Find.Object("bagCheckoutLoggedInBtn").click();

        }

        ValidateBagPage.soldOutStatus("bagItemsTable_WS");
    }
    @Override
    public void LoginLock(String email, String password) throws Exception {
        for(int i=0;i<10;i++){
            LoginWith(email, password);
            if(Find.Object("loAccountLocked").isPresent() &&
                    Find.Object("loAccountLocked").getText().value().toLowerCase().indexOf("locked")>=0)
                break;
        }
    }

    @Override
    public void ClickGuestCheckout() throws Exception {
        if (Find.Object("loginOverlayCheckoutAsGuestBtn_wk").isPresent()) {
            Report.pass("Guest checkout button found and clicked");
            Find.Object("loginOverlayCheckoutAsGuestBtn_wk").click();
        } else {
            Report.fail("Guest checkout button is not present on login overlay");
        }
    }
}
