package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.LinkYourSaksFirstOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 11/2/2016.
 */
public class LinkYourSaksFirstOverlay extends LinkYourSaksFirstOverlayBase {
    @Override
    public void IsLinkYourSaksFirstOverlay() throws Exception {
        if(Find.Object("saksFirstTitle_RL").isPresent()) {
            Report.pass("User is on Link Your Saks First Overlay");
        } else {
            Report.fail("User is not on Link Your Saks First Overlay");
        }
    }

    @Override
    public void ClickCancel() throws Exception {
        if(Find.Object("saksFirstCancel_RL").isPresent()) {
            Find.Object("saksFirstCancel_RL").click();
            Report.pass("Cancel button found and clicked");
        } else {
            Report.fail("Cancel button is not present on Link Your Saks First overlay");
        }
    }

    @Override
    public void ClickX() throws Exception {
        if(Find.Object("saksFirstX_RL").isPresent()) {
            Find.Object("saksFirstX_RL").click();
            Report.pass("X button found and clicked");
        } else {
            Report.fail("X button is not present on Link Your Saks First overlay");
        }
    }

    @Override
    public void ClickSubmit() throws Exception {
        if(Find.Object("saksFirstSubmit_RL").isPresent()) {
            Find.Object("saksFirstSubmit_RL").click();
            Report.pass("Submit button found and clicked");
        } else {
            Report.fail("Submit button is not present on Link Your Saks First overlay");
        }
    }

    @Override
    public void IsFirstNameErrorPresent() throws Exception {
        if(Find.Object("saksFirstFNameError_RL").isPresent()) {
            Report.pass("First Name field validation error is displayed " +
                    "on Link Your Saks First overlay");
        } else {
            Report.fail("First Name field validation error is not present " +
                    "on Link Your Saks First overlay");
        }
    }

    @Override
    public void IsLastNameErrorPresent() throws Exception {
        if(Find.Object("saksFirstLNameError_RL").isPresent()) {
            Report.pass("Last Name field validation error is displayed " +
                    "on Link Your Saks First overlay");
        } else {
            Report.fail("Last Name field validation error is not present " +
                    "on Link Your Saks First overlay");
        }
    }

    @Override
    public void IsZipCodeErrorPresent() throws Exception {
        if(Find.Object("saksFirstZipCodeError_RL").isPresent()) {
            Report.pass("Billing Zip Code field validation error is displayed " +
                    "on Link Your Saks First overlay");
        } else {
            Report.fail("Billing Zip Code field validation error is not present " +
                    "on Link Your Saks First overlay");
        }
    }

    @Override
    public void IsAccNumErrorPresent() throws Exception {
        if(Find.Object("saksFirstAccNumError_RL").isPresent()) {
            Report.pass("Account Number field validation error is displayed " +
                    "on Link Your Saks First overlay");
        } else {
            Report.fail("Account Number field validation error is not present " +
                    "on Link Your Saks First overlay");
        }
    }

    @Override
    public void ClickSubmit(String fName, String lName, String zip, String accNum) throws Exception {
        Find.Object("saksFirstFName_RL").clear();
        Find.Object("saksFirstFName_RL").input(fName);
        Find.Object("saksFirstLName_RL").clear();
        Find.Object("saksFirstLName_RL").input(lName);
        Find.Object("saksFirstZipCode_RL").clear();
        Find.Object("saksFirstZipCode_RL").input(zip);
        Find.Object("saksFirstAccNum_RL").clear();
        Find.Object("saksFirstAccNum_RL").input(accNum);
        ClickSubmit();
    }
}
