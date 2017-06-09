package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.EditShippingAddrOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import gherkin.lexer.Fi;

/**
 * Created by 461967 on 4/15/2016.
 */
public class EditShippingAddrOverlay extends EditShippingAddrOverlayBase {
    @Override
    public void IsShippingAddrOverlay() throws Exception {
        if (Find.Object("editShp_Title").isPresent()) {
            Report.pass("User is on Edit Shipping Address Overlay");
        } else {
            Report.fail("User is not on Edit Shipping Address Overlay");
        }
    }

    @Override
    public void ClickSubmit() throws Exception {
        if (Find.Object("editShp_Submit").isPresent()) {
            Find.Object("editShp_Submit").click();
        }
    }

    @Override
    public void ClickCancel() throws Exception {
        if (Find.Object("editShp_Cancel").isPresent()) {
            Find.Object("editShp_Cancel").click();
        }
    }

    @Override
    public void ClickX() throws Exception {
        if (Find.Object("editShp_Xbtn").isPresent()) {
            Find.Object("editShp_Xbtn").click();
        }
    }

    @Override
    public void EditAddr(String country, String fName, String lName, String comp, String addr1, String addr2, String city, String state, String zip, String phone, boolean isDefaultAddr) throws Exception {
        if(Find.Object("editShp_Country").isPresent()){
            Find.Object("editShp_Country").select(country);
        }
        if(Find.Object("editShp_fName").isPresent()){
            Find.Object("editShp_fName").clear();
            Find.Object("editShp_fName").input(fName);
        }
        if(Find.Object("editShp_lName").isPresent()){
            Find.Object("editShp_lName").clear();
            Find.Object("editShp_lName").input(lName);
        }
        if(Find.Object("editShp_Comp").isPresent()){
            Find.Object("editShp_Comp").clear();
            Find.Object("editShp_Comp").input(comp);
        }
        if(Find.Object("editShp_Addr1").isPresent()){
            Find.Object("editShp_Addr1").clear();
            Find.Object("editShp_Addr1").input(addr1);
        }
        if(Find.Object("editShp_Addr2").isPresent()){
            Find.Object("editShp_Addr2").clear();
            Find.Object("editShp_Addr2").input(addr2);
        }
        if(Find.Object("editShp_City").isPresent()){
            Find.Object("editShp_City").clear();
            Find.Object("editShp_City").input(city);
        }
        if(Find.Object("editShp_State").isPresent()){
            Find.Object("editShp_State").select(state);
        }
        if(Find.Object("editShp_Zip").isPresent()){
            Find.Object("editShp_Zip").clear();
            Find.Object("editShp_Zip").input(zip);
        }
        if(Find.Object("editShp_Phone").isPresent()){
            Find.Object("editShp_Phone").clear();
            Find.Object("editShp_Phone").input(phone);
        }
        if(Find.Object("editShp_isDefault").isPresent()){
            Find.Object("editShp_isDefault").click();
        }
        ClickSubmit();
    }

    @Override
    public void ClickIsDefault(Boolean isDefault) throws Exception {
        if(Find.Object("editShp_isDefault").isPresent()){
            Find.Object("editShp_isDefault").click();
        }
    }
}
