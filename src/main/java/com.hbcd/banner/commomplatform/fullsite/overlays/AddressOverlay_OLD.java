package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.AddressOverlayBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by 461967 on 6/6/2016.
 */
public class AddressOverlay_OLD extends AddressOverlayBase {
    @Override
    public void fillNewBillingAddress(String address, String city,
                                      String state, String zipcode) {


    }
    @Override
    public void editShippingAddress(String address) {

    }

    @Override
    public void editBillingAddress(String address) {

    }

    @Override
    public void fillNewProfileBillingAddress(String country, String address,
                                             String city, String state, String zipcode) throws Exception {
        String prefix = "proBilling";
        insertCredentials(prefix, address, state, city,
                zipcode,country);

    }
    @Override
    public void fillNewProfileShippingAddress(String country, String address,
                                              String city, String state, String zipcode) throws Exception {
        String prefix = "proShipping";
        insertCredentials(prefix, address, state, city,
                zipcode,"");

    }

    @Override
    public void editProfileAddress(String address) {

    }

    @Override
    public void removeProfileAddress(String address) {

    }

    @Override
    public void ClickCancel(String address) throws Exception{

    }
    @Override
    public void ClickCancel() throws Exception{
        Find.Object("cancelModalShippingAddress_vm").click();
    }
    @Override
    public void ClickEnterNewAddress() throws Exception{
        Find.Object("rsEnterNewShipAddressRdBtn").click();
    }
    @Override
    public void ClickApply() throws Exception{
        Find.Object("rsShippingAddressApplyBtn").click();
    }

    @Override
    public void fillNewShippingAddress(String address, String city, String state, String zipcode) throws Exception {
        Find.Object("rsEnterNewShipAddressRdBtn").click();
        String prefix = "proShipping";
        insertCredentials(prefix, address, state, city,zipcode,"");
    }

    @Override
    public void fillNewBillingAddress(String address, String city,
                                      String state, String zipcode, String country) {

    }
    @Override
    public void editZipCode(String zipCode) throws Exception {
        Find.Object("proShippingZipCodeTxt").clear();
        if(!zipCode.isEmpty()){
            Find.Object("proShippingZipCodeTxt").input(zipCode);
        }
        Find.Object("rsShippingAddressApplyBtn").javascriptClick();
    }
    @Override
    public void ClickExistingAddress() throws Exception{

    }

    public void insertCredentials(
            String prefix, String address, String state, String city,
            String zipcode,String country) throws Exception {
        boolean international=false;
        Find.Object(prefix+"Title").select("Mr.");
        Find.Object(prefix + "FirstNameTxt").input("James");
        Find.Object(prefix + "LastNameTxt").input("Altucher");
        Find.Object(prefix + "Address1Txt").input(address);
        Find.Object(prefix + "cityTxt").input(city);

        Find.Object(prefix + "ZipCodeTxt").input(zipcode);
        Find.Object(prefix + "PhoneTxt").input("213-304-6788");
        international=(boolean)(BrowserAction.javascriptExecuteScript("return Order.isInternational()"));
        String countryCookie=(String) (BrowserAction.javascriptExecuteScript("return getCookie('E4X_COUNTRY')"));
        if(international && !countryCookie.equalsIgnoreCase("CA")){

            Find.Object(prefix + "StateBtn").input(state);
        }
        else{
            Find.Object(prefix + "StateBtn").select(state);
        }

        if (!country.isEmpty()) {
            Find.Object(prefix + "CountryTxt").select(country);

        }

		/*if(country.isEmpty())
		{
			Find.Object(prefix + "StateBtn").click();
			Find.LinkWithText(true, addressHelper.getState(), state).click();
		}	*/
        // not clicking the address book button
        //Find.Object(prefix + "CheckBoxTxt").click();

        StepLogger.validate(Check.ObjectPresent, prefix + "SaveBtn");
        Thread.sleep(2000);
        Find.Object(prefix + "SaveBtn").click();
        if(Find.Object("yapQASCountinueBtn").isPresent())
        {
            Find.Object("yapQASCountinueBtn").click();
        }

    }
}
