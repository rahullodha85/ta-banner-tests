package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.EditEmailPrefOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by 461967 on 5/2/2016.
 */
public class EditEmailPrefOverlay extends EditEmailPrefOverlayBase {
    @Override
    public void IsEmailPrefOverlay() throws Exception {
        if (Find.Object("editEmailPref_Title").isPresent()) {
            Report.pass("User is on Edit Email Preferences Overlay");
        } else {
            Report.fail("User is not on Edit Email Preferences Overlay");
        }
    }

    @Override
    public void ClickSubmit() throws Exception {
        if (Find.Object("editEmailPref_Submit").isPresent()) {
            Report.pass("Submit button found and clicked");
            Find.Object("editEmailPref_Submit").click();
        } else {
            Report.fail("Submit button is not present on Edit Email Preferences Overlay");
        }
    }

    @Override
    public void ClickCancel() throws Exception {
        if (Find.Object("editEmailPref_Cancel").isPresent()) {
            Report.pass("Cancel button found and clicked");
            Find.Object("editEmailPref_Cancel").click();
        } else {
            Report.fail("Cancel button is not present on Edit Email Preferences Overlay");
        }
    }

    @Override
    public void ClickX() throws Exception {
        if (Find.Object("editEmailPref_Xbtn").isPresent()) {
            Report.pass("X button found and clicked");
            Find.Object("editEmailPref_Xbtn").click();
        } else {
            Report.fail("X button is not present on Edit Email Preferences Overlay");
        }
    }
}
