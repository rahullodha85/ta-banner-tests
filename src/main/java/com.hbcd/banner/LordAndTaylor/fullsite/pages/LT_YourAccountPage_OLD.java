package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_AddressOverlay_OLD;
import com.hbcd.banner.commomplatform.fullsite.pages.YourAccountPage_OLD;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.pages.YourAccountPage;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import static com.hbcd.utility.helper.Common.getUniqueNumber;

/**
 * Created by 461967 on 6/1/2016.
 */
public class LT_YourAccountPage_OLD extends YourAccountPage_OLD {
    @Override
    public void CreateRandomAccount(String email) throws Exception {
        Thread.sleep(1000);
        int n = getUniqueNumber();
        email = email.split("@")[0] + n + "@" + email.split("@")[1];
        StepLogger.validate(Check.ObjectPresent, "yapCreateAccountBtn");
        if(Find.Object("yapCreateAccountBtn").isPresent()) {
            Report.pass("Create Account button found and clicked",
                    BrowserAction.screenshot());
            Find.Object("yapCreateAccountBtn").click();
            if(Find.Object("yapEmailId").isPresent()) {
                Report.pass("User on account creation page and filling data-form to create account",
                        BrowserAction.screenshot());

                Find.Object("yapFirstName").input("Hello");
                Find.Object("yapLastName").input("World");
                Find.Object("yapPassword").input("test123");
                Find.Object("yapConfirmPassword").input("test123");
                Find.Object("yapEmailId").input(email);
                Find.Object("accountSaveButton_RL").click();
                Storage.save("emailAddress2", email);
            }else{
                Report.fail("User is not on account creation page",
                        BrowserAction.screenshot());
            }
        }else{
            Report.fail("Create Account button not found",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public void AccessOrderStatus(String orderNumber, String zipCode) throws Exception {
        Find.Object("yapOrderNumberTxt").input(orderNumber);
        Find.Object("yapBillingZipCodeTxt").input(zipCode);
        Find.Object("yapAccessDetailsBtn").click();
    }

    @Override
    public AddressOverlay ClickAddBilling() throws Exception {
        super.ClickAddBilling();
        return new LT_AddressOverlay_OLD();
    }

    @Override
    public AddressOverlay ClickAddShipping() throws Exception {
        super.ClickAddShipping();
        return new LT_AddressOverlay_OLD();
    }

    public YourAccountPage GoToMyAcccount() throws Exception {
        super.GoToMyAcccount();
        return new LT_YourAccountPage_OLD();
    }
}

