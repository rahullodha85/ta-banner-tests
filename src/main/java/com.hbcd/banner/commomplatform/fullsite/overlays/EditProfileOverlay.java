package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.EditProfileOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 3/23/2016.
 */
public class EditProfileOverlay extends EditProfileOverlayBase {
    @Override
    public void EditProfile(String fName, String lName, String email) throws Exception {
        if (Find.Object("editPro_fName").isPresent()) {
            Find.Object("editPro_fName").clear();
            Find.Object("editPro_fName").input(fName);
        }
        if (Find.Object("editPro_lName").isPresent()) {
            Find.Object("editPro_lName").clear();
            Find.Object("editPro_lName").input(lName);
        }
        if (Find.Object("editPro_Email").isPresent()) {
            Find.Object("editPro_Email").clear();
            Find.Object("editPro_Email").input(email);
        }
        Find.Object("editPro_Submit").click();
    }

    @Override
    public void ClickCancel() throws Exception {
        if (Find.Object("editPro_Cancel").isPresent()) {
            Find.Object("editPro_Cancel").click();
            Report.pass("Cancel button found and clicked");
        } else {
            Report.fail("Cancel button is not present on Edit Profile Overlay");
        }
    }

    @Override
    public void ClickX() throws Exception {
        if (Find.Object("editPro_Xbutton").isPresent()) {
            Find.Object("editPro_Xbutton").click();
            Report.pass("X button found and clicked");
        } else {
            Report.fail("X button is not present on Edit Profile Overlay");
        }
    }

    @Override
    public void IsEditProfile(String text) throws Exception {
        if (Find.Object("editPro_Title").getText().value().contains(text)) {
            Report.pass("User is on Edit profile overlay");
        } else {
            Report.fail("User is not on Edit profile overlay");
        }
    }
}
