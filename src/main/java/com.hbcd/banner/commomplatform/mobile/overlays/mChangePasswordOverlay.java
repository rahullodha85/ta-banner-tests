package com.hbcd.banner.commomplatform.mobile.overlays;

import com.hbcd.commonbanner.base.overlays.ChangePasswordOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 3/22/2016.
 */
public class mChangePasswordOverlay extends ChangePasswordOverlayBase {
    @Override
    public void ChangePwd(String oldPwd, String newPwd, String confPwd) throws Exception {
        Find.Object("chngPwd_OldPwd").input(oldPwd);
        Find.Object("chngPwd_NewPwd").input(newPwd);
        Find.Object("chngPwd_ConfPwd").input(confPwd);
        Find.Object("chngPwd_Submit").click();
    }

    @Override
    public void ClickCancel() throws Exception {
        Find.Object("chngPwd_Cancel").click();
    }

    @Override
    public void ClickSubmit() throws Exception {
        Find.Object("chngPwd_Submit").click();
    }

    @Override
    public void IsChangePwdOverlay(String text) throws Exception {
        if (Find.Object("chngPwd_Title").getText().value().contains(text)) {
            Report.pass("User is on change password overlay");
        } else {
            Report.fail("User is not on change password overlay");
        }
    }

    @Override
    public void VerifyOldPasswordError(String text) throws Exception {
        if (Find.Object("chngPwd_OldError").isPresent()) {
            if (Find.Object("chngPwd_OldError").getText().value().contains(text)) {
                Report.pass("Error text: " + text + " displayed as expected");
            } else {
                Report.fail("Old password error field text: " + Find.Object("chngPwd_OldError").getText().value() +
                        " does not match expected error text: " + text);
            }
        } else {
            Report.fail("No error message displayed for old password field error");
        }
    }

    @Override
    public void VerifyNewPasswordError(String text) throws Exception {
        if (Find.Object("chngPwd_NewError").isPresent()) {
            if (Find.Object("chngPwd_NewError").getText().value().contains(text)) {
                Report.pass("Error text: " + text + " displayed as expected");
            } else {
                Report.fail("New password error field text: " + Find.Object("chngPwd_NewError").getText().value() +
                        " does not match expected error text: " + text);
            }
        } else {
            Report.fail("No error message displayed for New password field error");
        }
    }

    @Override
    public void VerifyConfPasswordError(String text) throws Exception {
        if (Find.Object("chngPwd_ConfError").isPresent()) {
            if (Find.Object("chngPwd_ConfError").getText().value().contains(text)) {
                Report.pass("Error text: " + text + " displayed as expected");
            } else {
                Report.fail("Confirm password error field text: " + Find.Object("chngPwd_ConfError").getText().value() +
                        " does not match expected error text: " + text);
            }
        } else {
            Report.fail("No error message displayed for Confirm password field error");
        }
    }
}
