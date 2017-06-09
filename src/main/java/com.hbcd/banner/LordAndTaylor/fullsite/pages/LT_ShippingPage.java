package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_AddressOverlay_OLD;
import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_QASOverlay;
import com.hbcd.banner.commomplatform.fullsite.pages.ShippingPage;
import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.overlays.QASOverlay;
import com.hbcd.scripting.core.Assert;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.utility.helper.Common;

/**
 * Created by 461967 on 6/7/2016.
 */
public class LT_ShippingPage extends ShippingPage {

    @Override
    public void SelectShippingMethodFor(String upc, ShipMethod shipMethod) throws Exception {
        if (Find.Object("ltBagPageShippingMethods_AAF").isPresent()) {
            Report.pass("User selects Shipping method with " + shipMethod);
            Find.Object("ltBagPageShippingMethods_AAF").changeContainsText(upc).select(shipMethod.value());
            Find.Object("ltBagZipCode_AAF").input("10281");
            Thread.sleep(2000);//Although tried to put userSetTme in the Object Repo, However, still it required to add Thread.sleep()
        }else{
            Report.fail("Shipping Method is NOT Selected");
        }
    }

    @Override
    public QASOverlay ClickCheckoutOptionalAddressConfirmation() throws Exception {
        super.ClickCheckoutOptionalAddressConfirmation();
        return new LT_QASOverlay();
    }

    @Override
    public AddressOverlay ClickEditShippingAddress() throws Exception {
        super.ClickEditShippingAddress();
        return new LT_AddressOverlay_OLD();
    }

    @Override
    public void AddInternationalShippingAddress(String address, String province, String city, String zip, boolean makeDefault) throws Exception {
        Storage.save("email", "checkoutenhancements" + Common.getUniqueNumber() + "@saks.com");
        Storage.save("shippingAddress",address);
        setFormCredentials("Shipping", address, province, city, zip);
        setDefaultAddress(makeDefault);
        setContactInformation(Storage.get("email"));
        clickShippingApply();
    }

    private void setFormCredentials(String prefix, String address, String province, String city, String zip) throws Exception{
        Report.info("User Enters ShippingAndBilling information");
        Find.Object("rs" + prefix + "firstNameTxt").input("Hello");
        Find.Object("rs" + prefix + "lastNameTxt").input("world");
        Find.Object("rs" + prefix + "AddressTxt").input(address);
        Find.Object("rs" + prefix + "CityTxt").input(city);
        Find.Object("ltProvinceIntl_AAF").select(province);
        Find.Object("rs" + prefix + "ZipCodeTxt").input(zip);
        Find.Object("rs" + prefix + "PhoneTxt").input("2122222222");
    }

    private void setDefaultAddress(boolean makeDefault) throws Exception{
        if(makeDefault)
            if(!Find.Object("rsShippindAddressDefaultchkbox").isEnabled())
                Find.Object("rsShippindAddressDefaultchkbox").click();
    }

    public void setContactInformation(String email) throws Exception{
        Find.Object("shippingBillingEmailTxt_wk").clear();
        Find.Object("shippingBillingEmailTxt_wk").input(email);
    }

    private void clickShippingApply() throws Exception{
        if(Find.Object("rsShippingAddressApplyBtn").isPresent()){
            Report.pass("User Clicks on Continue Checkout");
            Find.Object("rsShippingAddressApplyBtn").click();
        }else{
            Report.fail("Continue Checkout Button is NOT Present");
        }
    }
}


