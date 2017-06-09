package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.EditPaymentMethodOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 4/11/2016.
 */
public class EditPaymentMethodOverlay extends EditPaymentMethodOverlayBase {
    @Override
    public void IsEditPaymentOverlay() throws Exception {
        if (Find.Object("editPay_Title").isPresent()) {
            Report.pass("User is on Edit Payment Method Overlay");
        } else {
            Report.fail("User is not on Edit Payment Method Overlay");
        }
    }

    @Override
    public void IsPaymentNamePresent() throws Exception {
        if (Find.Object("editPay_Name").isPresent()) {
            Report.pass("Payment Method Name is present on Edit Payment Overlay");
        } else {
            Report.fail("Payment Method Name is not present on Edit Payment Overlay");
        }
    }

    @Override
    public void IsCardInfoPresent() throws Exception {
        if (Find.Object("editPay_CardInfo").isPresent()) {
            Report.pass("Card information is present on Edit Payment Overlay");
        } else {
            Report.fail("Card information is not present on Edit Payment Overlay");
        }
    }

    @Override
    public void ClickIsDefault() throws Exception {
        if (Find.Object("editPay_IsDefault").isPresent()) {
            Report.pass("Is_Default checkbox found and clicked");
            Find.Object("editPay_IsDefault").click();
        } else {
            Report.fail("Is_Default checkbox is not present on Edit Payment Method Overlay");
        }
    }

    @Override
    public void ClickSubmit() throws Exception {
        if (Find.Object("editPay_Submit").isPresent()) {
            Report.pass("Submit button found and clicked");
            Find.Object("editPay_Submit").click();
        } else {
            Report.fail("Submit button is not present on Edit Payment Method Overlay");
        }
    }

    @Override
    public void ClickCancel() throws Exception {
        if (Find.Object("editPay_Cancel").isPresent()) {
            Report.pass("Cancel button found and clicked");
            Find.Object("editPay_Cancel").click();
        } else {
            Report.fail("Cancel button is not present on Edit Payment Method Overlay");
        }
    }

    @Override
    public void ClickX() throws Exception {
        if (Find.Object("editPay_Xbtn").isPresent()) {
            Report.pass("Overlay close \"X\" button found and clicked");
            Find.Object("editPay_Xbtn").click();
        } else {
            Report.fail("Overlay close \"X\" button is nor present on Edit Payment Overlay");
        }
    }
}
