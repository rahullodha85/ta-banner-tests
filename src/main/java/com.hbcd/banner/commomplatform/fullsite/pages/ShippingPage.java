package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.overlays.AddressOverlay_OLD;
import com.hbcd.banner.s5a.overlays.s5a_AddressOverlay;
import com.hbcd.banner.s5a.pages.s5a_ReviewSubmitPage;
import com.hbcd.commonbanner.base.pages.ShippingPageBase;
import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.overlays.QASOverlay;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.common.Type;
import com.hbcd.utility.helper.Common;

/**
 * Created by 461967 on 6/7/2016.
 */
public class ShippingPage extends ShippingPageBase {
    @Override
    public QASOverlay ClickCheckoutOptionalAddressConfirmation() throws Exception {

        if(Find.Object("shChkOutBtn").isPresent())
            Find.Object("shChkOutBtn").click();

        else if(Find.Object("shUnregChkOutBtn").isPresent())
            Find.Object("shUnregChkOutBtn").click();

        else if(Find.Object("shpContinueCheckout_wk").isPresent())
            Find.Object("shpContinueCheckout_wk").click();

        else if(Find.Object("pyCheckout").isPresent())
            Find.Object("pyCheckout").click();
		/*if (Find.Object("shconfirmAddressBody")
				.getText()
				.value()
				.contains(
						"We have checked your address against the US Postal Service database and found the address to be incomplete or inaccurate")) {
			Find.Object("shUseAddressAsEnteredBtn").click();


		if(Find.Object("shconfirmAddressBody").isPresentDisplayedEnabled()){
			if (Find.Object("shconfirmAddressBody").getText().value()
					.contains("We have checked your address against the US Postal Service database and found the address to be incomplete or inaccurate"))
				Find.Object("shUseAddressAsEnteredBtn").click();

		}*/
        return new com.hbcd.banner.commomplatform.fullsite.overlays.QASOverlay();
    }

    private void ClickApply() throws Exception {

        if(Find.Object("shChkOutBtn").isPresent())
            Find.Object("shChkOutBtn").click();
        else if(Find.Object("shUnregChkOutBtn").isPresent())
            Find.Object("shUnregChkOutBtn").click();
        if((Find.Object("shconfirmAddressBody")).getText().value().contains("We have checked your address"))
            Find.Object("rsUseAddressBtn").click();
        if(Find.Object("rsBillingAddressApplyBtn").isPresent())
            Find.Object("rsBillingAddressApplyBtn").click();

    }

    public void setContactInformation(String email) throws Exception{
        Find.Object("shippingBillingEmailTxt_wk").clear();
        Find.Object("shippingBillingEmailTxt_wk").input(email);
    }

    @Override
    public void AddShippingAddress(Boolean shipToMultiple, String address, String state, String city,
                                   String zip,boolean makeDefault) throws Exception {
        Storage.save("email", "checkoutenhancements" + Common.getUniqueNumber() + "@saks.com");
        Storage.save("shippingAddress",address);
        setFormCredentials("Shipping", address, state, city, zip);
        setDefaultAddress(makeDefault);
        setContactInformation(Storage.get("email"));
        clickShippingApply();
        //		Thread.sleep(5000);
    }

    /** Method used only when Email or Phone Number needs to be entered through script*/
    @Override
    public void AddShippingAddress(Boolean shipToMultiple, String address, String state, String city,
                                   String zip,boolean makeDefault,String email,String phone) throws Exception {

        setFormCredentials("Shipping", address,	state, city, zip);
        setDefaultAddress(makeDefault);

        Storage.save("email", email);
        Storage.save("shippingAddress",address);
        setContactInformation(email);
        setContactInformation(Storage.get("email"));
        Find.Object("rs" + "Shipping" + "PhoneTxt").input(phone);
        clickShippingApply();
    }

    @Override
    public void SelectShippingMethodFor(String upc, ShipMethod shipMethod) throws Exception{
        Find.Object("shpEditShippingMethod_wk").changeContainsText(upc).select(shipMethod.value());
        Thread.sleep(10000L);
    }

    @Override
    public void SelectRequireSignatureFor(String upc) throws Exception{
        Find.Object("rspSignatureReqdItemLevel_WS").changeContainsText(upc).click();
        Thread.sleep(10000L);
    }

    @Override
    public AddressOverlay ClickEditShippingAddress() throws Exception {
        Thread.sleep(2000);
        Find.Object("shEditShippingAddressBtn").click();
        return new AddressOverlay_OLD();
    }

    @Override
    public AddressOverlay s5a_AddressOverlay() throws Exception {
        return new s5a_AddressOverlay();
    }

    @Override
    public void ClickContinueAfterMultiShip() throws Exception{
        Find.Object("shpContinueAfterMultiShip").click();
        Thread.sleep(10000L);
    }

    @Override
    public void EditShippingAddress(String firstName, String lastName,
                                    String streetaddress, String streetaddress2, String city,
                                    String country, String province, String postalCard,
                                    String phonenumber1, String phonenumber2, String phonenumber3,
                                    String phoneextension) throws Exception{
        setFormCredentials("Shipping", streetaddress, province, city, postalCard);
        setDefaultAddress(true);
        clickShippingApply();
    }

    @Override
    public void ClickEditBillingAddress() throws Exception {
        if (Find.Object("shEditBillingAddressBtn").isPresent()){
            Report.pass("User Clicks on Shippiung & Edit Billing Address Button", BrowserAction.screenshot());
        }else{
            Report.fail("Edit Shipping and Billing Address Button is NOT Present",BrowserAction.screenshot());
        }
        Find.Object("shEditBillingAddressBtn").click();
    }

    @Override
    public void AddBillingAddress(String address, String state, String city,
                                  String zip,boolean makeDefault) throws Exception {
        Storage.save("billingAddress",address);
        new s5a_ReviewSubmitPage().insertCredentials(false, "Billing", address,
                state, city, zip, "United States",makeDefault);
        //	ClickApply();
        if(Find.Object("rsBillingAddressApplyBtn").isPresent())
            Find.Object("rsBillingAddressApplyBtn").click();
        else if(Find.Object("shUnregChkOutBtn").isPresent())
            Find.Object("shUnregChkOutBtn").click();
        Thread.sleep(4000);
        if(Find.Object("rsUseAddressBtn").isPresent())
            Find.Object("rsUseAddressBtn").click();
    }

    @Override
    public void ClickDomesticShpAddClose() throws Exception {

        Find.Object("shPlsEnterDomesticCloseBtn").click();

    }

    @Override
    public void ClickInternationalShipping() throws Exception {

        Find.Object("shClickInternationalShippingBtn").click();

    }

    @Override
    public void ClickCheckoutWithPaypal() throws Exception {


        if(New.Object("").setProperty(Type.PropertyType.ID, "envoyId").isPresent()){
            Switch.toFrame("envoyId");

            Thread.sleep(6000);
            Find.Object("pplContinueWithPayPal_WS").click();
        }

    }

    private void clickShippingApply() throws Exception{
        if(Find.Object("rsShippingAddressApplyBtn").isPresent())
            Find.Object("rsShippingAddressApplyBtn").click();
		/*Object OrderType=BrowserAction.javascriptExecuteScript("return Order.isInternational()");
		Boolean orderStatus=(Boolean)OrderType;
		if(!orderStatus) {*/
        if (Find.Object("rsUseAddressBtn").isPresent())
            Find.Object("rsUseAddressBtn").javascriptClick();

    }

    private void setFormCredentials(String prefix, String address, String state, String city, String zip) throws Exception{
        if (Find.Object("rs" + prefix + "TitleDrpDwn").isPresent()){
            Find.Object("rs" + prefix + "TitleDrpDwn").select(3);
            //StepLogger.validate(Check.ObjectPresent, "rs" + prefix + "TitleDrpDwn");//Dont Need the Steplogger
        }
        Find.Object("rs" + prefix + "firstNameTxt").clear();
        Find.Object("rs" + prefix + "lastNameTxt").clear();
        Find.Object("rs" + prefix + "AddressTxt").clear();
        Find.Object("rs" + prefix + "CityTxt").clear();
        Find.Object("rs" + prefix + "ZipCodeTxt").clear();
        Find.Object("rs" + prefix + "PhoneTxt").clear();

        Find.Object("rs" + prefix + "firstNameTxt").input("Hello");
        Find.Object("rs" + prefix + "lastNameTxt").input("world");
        Find.Object("rs" + prefix + "AddressTxt").input(address);
        Find.Object("rs" + prefix + "CityTxt").input(city);
        String regionLabel= Find.Object("shipping_page_shipping_address_section_vm").getText().value();

        if(regionLabel.contains("Region / Province"))
            Find.Object("rs" + prefix + "State").input(state);
        else
            Find.Object("rs" + prefix + "StateDrpDwn").select(state);



        Find.Object("rs" + prefix + "ZipCodeTxt").input(zip);
        Find.Object("rs" + prefix + "PhoneTxt").input("2122222222");
    }

    private void setDefaultAddress(boolean makeDefault) throws Exception{
        if(makeDefault)
            if(!Find.Object("rsShippindAddressDefaultchkbox").isEnabled())
                Find.Object("rsShippindAddressDefaultchkbox").click();
    }

    @Override
    public void ClickMultipleAddress() throws Exception {

        Find.Object("shpClickMultipleAddress_zk").javascriptClick();
        //Find.Object("shSendToMultipleCheckBox").click();


    }

    @Override
    public void SelectShippingMethodInternational(String shippingMethod) throws Exception {
        if(shippingMethod.equalsIgnoreCase("express_unpaid")){
            Find.Object("shpexpressradiounpaid_vm").click();
        }
        else if(shippingMethod.equalsIgnoreCase("express_paid")){
            Find.Object("shpexpressradiopaid_vm").click();
        }
    }

    private void editBillingZipCode(String zipCode) throws Exception {
        Find.Object("proShippingZipCodeTxt").clear();
        if(!zipCode.isEmpty())
        {
            Find.Object("proShippingZipCodeTxt").input(zipCode);
        }
        Find.Object("proShippingZipCodeTxt").javascriptClick();
    }

    @Override
    public void AddInternationalShippingAddress(String address, String province, String city, String zip, boolean makeDefault) throws Exception {

    }
}
