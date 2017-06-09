package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.banner.s5a.overlays.s5a_GiftOverlay;
import com.hbcd.banner.s5a.overlays.s5a_QuickLookOverlay;
import com.hbcd.banner.validations.common.ValidateBagPage;
import com.hbcd.commonbanner.base.pages.ReviewSubmitPageBase;
import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/7/2016.
 */
public class ReviewSubmitPage extends ReviewSubmitPageBase {
    boolean countryavailable = false;
    String country = "";

    @Override
    public GiftOverlay MakeGift(String sku) throws Exception {
        // Find.ObjectWith("jsItemRoot", "data-cartproductcode", sku,
        // "span[class='font-icon font-icon-gift']").click();

        // Find.Object("rspMakeGiftLink_WS").changeAttributeContainsValue("data-cartproductcode",
        // sku).click();

        IsReviewSubmitPage();
        New.Object("rspMakeGift_WS")
                .setProperty(Type.PropertyType.CSS_SELECTOR, "div[class='jsItemRoot widebag-item ']")
                .setProperty(Type.PropertyType.ATTRIBUTE_KEY1,
                        "data-cartproductcode")
                .setProperty(Type.PropertyType.ATTRIBUTE_VALUE1, sku)
                .setProperty(Type.PropertyIntType.iTH, 1)
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.TAG_NAME, "a")
                .setChildProperty(Type.PropertyType.CONTAINS_TEXT, "Make This a Gift")
                .click();


        return new com.hbcd.banner.commomplatform.fullsite.overlays.GiftOverlay();
    }

    @Override
    public void ClickPlaceOrder() throws Exception {
        if (Find.Object("rspCcReview").isPresent()) {
            Find.Object("rspCcReview").input("888");
        }
        // if(Find.Object("rspPaymentTab_wk").validateWithPresetData())
        if (Find.Object("pyCheckout").isPresent())
            Find.Object("pyCheckout").click();
        //This is unspecified exception handler NOT needed for any CommonPlatform Checkout Scripts
        /*if (Find.Object("bagItemsTable_WS").isPresent()){
            ValidateBagPage.soldOutStatus("bagItemsTable_WS");
        }*/
        if(Find.Object("rsPlaceOrderBtn").isPresent()){
            Report.pass("User Clicks on Place Order Button");
        }else{
            Report.fail("Place Order Button is NOT present");
        }
        Find.Object("rsPlaceOrderBtn").click();
//		StepLogger.validate(Check.TextPresent, "confOrderNumMsg", "Order #");
    }

    @Override
    public void ApplyGiftCard(String CardNumber, String pinNumber)
            throws Exception {
        Find.Object("rsGiftBtn").click();
        Find.Object("rsGiftText").input(CardNumber);
        Find.Object("rsPinText").input(pinNumber);
        StepLogger.validate(Check.ObjectPresent, "rsApplyGiftBtn");
        Find.Object("rsApplyGiftBtn").click();

        if (Find.Object("rsGiftOverlay_WS").isPresent()) {
            if (Find.Object("rsGiftOverlay_WS")
                    .getText()
                    .value()
                    .contains(
                            "The gift card you entered has no available balance"))
                Report.dataFail(
                        "The gift card you entered has no available balance",
                        BrowserAction.screenshot());
        }
    }

    @Override
    public void AddShippingAddress(String address, String city, String state,
                                   String zipcode, boolean makeDefaultAddress) throws Exception {

        if (!(Find.Object("navShpTo_ve").getAttribute("outerHTML").value()
                .toLowerCase().indexOf("us.gif") < 0)) {
        }
        if(Find.Object("rsEditShippingBtn").isPresent()){
            Report.pass("User Clicks on Edit Shipping");
        }else{
            Report.fail("Edit Shipping is NOT present");
        }
        Find.Object("rsEditShippingBtn").click();
        if(Find.Object("rsEnterNewShipAddressRdBtn").isPresent()){
            Report.pass("User Selects Enter New Shipping Address");
        }else {
            Report.fail("New Shipping Address is NOT selected");
        }
        Find.Object("rsEnterNewShipAddressRdBtn").click();
        insertCredentials(true, "Shipping", address, state, city, zipcode, "",
                makeDefaultAddress);

        this.enterCVV();
        // Find.Object("rsUseAddressBtn").click();
    }

    @Override
    public void AddShippingAddress(String address, String city, String state,
                                   String zipcode, String country, boolean makeDefaultAddress)
            throws Exception {
        this.country = country;
        countryavailable = true;
        AddShippingAddress(address, city, state, zipcode, country,
                makeDefaultAddress);
    }

    private void enterCVV() throws Exception {

        if (Find.Object("shconfirmAddressBody").getText().value()
                .contains("Security Code")) {
            Find.Object("rsCVV").input("491");
        }
    }

    @Override
    public void AddBillingAddress(String address, String city, String state,
                                  String zipcode, String cntry, boolean makeDefaultAddress)
            throws Exception {
        Find.Object("rsEditBillingBtn").click();
        Find.Object("rsEnterNewBillAddressRdBtn").click();
        insertCredentials(true, "Billing", address, state, city, zipcode,
                cntry, makeDefaultAddress);

    }

    @Override
    public void EditShippingAddress(String address) throws Exception {
        Find.Object("rsEditShippingBtn").click();
        editAddress("Shipping", address);
        if (Find.Object("rsUseAddressBtn").isPresent())
            Find.Object("rsUseAddressBtn").click();
    }

    @Override
    public void EditBillingAddress(String address) throws Exception {
        Find.Object("rsEditBillingBtn").click();
        editAddress("Billing", address);
        if (Find.Object("billingEditCheck_wk").isPresent())
            Find.Object("rsBillingStateDrpDwn").select("New York");
        if (Find.Object("rsUseAddressBtn").isPresent())
            Find.Object("rsUseAddressBtn").click();
        StepLogger.validate(Check.TextPresent, "rspBillingSummary", address);
    }

    @Override
    public void SelectShippingMethodInternational(String shippingMethod) throws Exception {

    }

    @Override
    public void ChangeShippingMethod(String shippingMethod) throws Exception {
//		Find.Object("rsEditShippingMethodBtn").click();

        if (shippingMethod.toLowerCase().equalsIgnoreCase("rush")) {
            Find.Object("rspShippingMethodRadio_RL").changeChildContainsText("Rush").click();
        }
        if (shippingMethod.toLowerCase().equalsIgnoreCase("standard")) {

            Find.Object("rspShippingMethodRadio_RL").changeChildContainsText("Standard").click();
        }
        if (shippingMethod.toLowerCase().equalsIgnoreCase("next bus. day")) {

            Find.Object("rspShippingMethodRadio_RL").changeChildContainsText("Next Bus. Day").click();
        }
        if (shippingMethod.toLowerCase().equalsIgnoreCase("saturday")) {

            Find.Object("rspShippingMethodRadio_RL").changeChildContainsText("Saturday").click();
        }
        Thread.sleep(5000);
//		Find.Object("rsShippingMethodApplyBtn").click();
    }

    @Override
    public void ToggleSignature(String sku) throws Exception {
        if (Find.Object("rspSignatureRequiredSelection").isPresent()) {
            Report.pass("Sign on delivery checkbox found and checked");
            Find.Object("rspSignatureRequiredSelection")
                    .click();
        } else {
            Report.fail("Sign on delivery checkbox is not present on review-submit page");
        }
    }

    @Override
    public void Remove(String upc) throws Exception {
//		Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
//				"span[class='font-icon font-icon-remove']").click();
        Thread.sleep(4000);
//		Find.Object("rspRemoveItem2_WS").changeAttributeContainsValue("data-cartproductcode", upc).click();
        Find.Object("rspRemoveItem2_RL").changeContainsText(upc).click();
        Thread.sleep(2000);
        if (Find.Object("rspRemoveItemConfirmPopup_WS").isPresent())
            Find.Object("rspRemoveItemConfirmPopup_WS").click();

    }

    @Override
    public void ClickShipToMultipleAddresses() throws Exception {
        if (Find.MultipleObjects("rsShToMulti_WS").selectItemContainText("Ship to Multiple Addresses").isPresent()) {
            Report.pass("User Clicks on Multiple Shipping Address in Review & Submit Page", BrowserAction.screenshot());
        } else {
            Report.fail("Multiple Shipping Address is NOT Present", BrowserAction.screenshot());
        }
        Find.MultipleObjects("rsShToMulti_WS").selectItemContainText("Ship to Multiple Addresses").click();
    }

    @Override
    public void EnterNewShippingAddress(String upc, String address,
                                        String city, String state, String zipcode,
                                        boolean makeDefaultAddress) throws Exception {
        Find.Object("shpShipToMulti_WS")
                .changeAttributeContainsValue("data-cartproductcode", upc)
                .click();
        // Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
        // "a[class='action-link jsEditSelectedShipAddress']").click();
        StepLogger.validate(Check.ObjectPresent, "rsEnterNewShipAddRadio");
        Find.Object("rsEnterNewShipAddRadio").click();
        insertCredentials(true, "Shipping", address, state, city, zipcode, "",
                makeDefaultAddress);
    }

    @Override
    public void ClickContinueCheckOut() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "rsContinueCheckOutBtn");
        Find.Object("rsContinueCheckOutBtn").click();
    }

    @Override
    public String GetShippingCharge() throws Exception {
        Storage.save("shippingCharge", Find.Object("rsShippingChargeLbl").getText().value());
        return Find.Object("rsShippingChargeLbl").getText().value();
    }

    public void insertCredentials(boolean onReviewSubmitPage,
                                  String prefix, String address, String state, String city,
                                  String zip, String cntry, boolean makeDefaultAddress)
            throws Exception {

        if(Find.Object("rs" + prefix + "TitleDrpDwn").isPresent()){
            Find.Object("rs" + prefix + "TitleDrpDwn").select(3);
        }
        //StepLogger.validate(Check.ObjectPresent, "rs" + prefix + "TitleDrpDwn");
        commonCredentials(prefix, address, state, city, zip);

        this.clickMakeDefaultAddress(makeDefaultAddress);
        this.clickApplyAddressButton(onReviewSubmitPage,
                prefix, cntry);
        if (Find.Object("bagSysError_WS").isPresent()) {

            if (Find.Object("bagSysError_WS")
                    .getText()
                    .value()
                    .contains("There has been an error in the checkout process")) {
                Report.systemFail(
                        "There has been an error in the checkout process. Please try to check out again. If this error persists, please contact us at 1.877.551.SAKS (7257).",
                        BrowserAction.screenshot());
            }
        }
        if (Find.Object("shipAddOverLay_WS").isPresent()) {
            if (Find.Object("shipAddOverLay_WS")
                    .getText()
                    .value()
                    .contains(
                            "We ask for your billing address in order to prevent against fraudulent use")) {
                Report.dataFail(
                        "We ask for your billing address in order to prevent against fraudulent use",
                        BrowserAction.screenshot());
            }
        }

    }

    public void commonCredentials(String prefix, String address,
                                  String state, String city, String zip) throws Exception {
        Find.Object("rs" + prefix + "firstNameTxt").clear();
        Find.Object("rs" + prefix + "firstNameTxt").input("Hello");
        Find.Object("rs" + prefix + "lastNameTxt").clear();
        Find.Object("rs" + prefix + "lastNameTxt").input("world");

        Find.Object("rs" + prefix + "AddressTxt").clear();
        Find.Object("rs" + prefix + "AddressTxt").input(address);

        Find.Object("rs" + prefix + "CityTxt").clear();
        Find.Object("rs" + prefix + "CityTxt").input(city);

        Find.Object("rs" + prefix + "StateDrpDwn").select(state);

        Find.Object("rs" + prefix + "ZipCodeTxt").clear();
        Find.Object("rs" + prefix + "ZipCodeTxt").input(zip);

        Find.Object("rs" + prefix + "PhoneTxt").clear();
        Find.Object("rs" + prefix + "PhoneTxt").input("2122222222");

    }

    private void clickApplyAddressButton(boolean onReviewSubmitPage,
                                         String prefix, String cntry) throws Exception {

        if (prefix.equals("Billing"))
            Find.Object("rsBillingAddressCntryDrpDwn").select(cntry);
        if (onReviewSubmitPage)
            Find.Object("rs" + prefix + "AddressApplyBtn").click();

        if ((Find.Object("shconfirmAddressBody")).getText().value()
                .contains("We have checked your address")) {
            Find.Object("rsUseAddressBtn").click();
        }
    }

    private void clickMakeDefaultAddress(boolean makeDefaultAddress)
            throws Exception {

        if (makeDefaultAddress) {
            Find.Object("rsShippindAddressDefaultchkbox").click();
        }
    }

    protected void insertEditCreditCardCredentials(String prefix,
                                                   String cardType, String ccNumber) throws Exception {

        Find.Object("rsEditCC" + prefix + "PayTypeDrpDwn").select(cardType);
        Find.Object("rsEditCC" + prefix + "Name").input("Hello");
        Find.Object("rsEditCC" + prefix + "Number").input(ccNumber);
        Find.Object("rsEditCC" + prefix + "Name").input("Hello");
        Find.Object("rsEditCC" + prefix + "ExpMonthDrpDwn").select(12);
        Find.Object("rsEditCC" + prefix + "ExpYearDrpDwn").select(5);
        Find.Object("rsEditCC" + prefix + "ExpYearDrpDwn").input("146");
    }

    private void editAddress(String prefix, String address) throws Exception {
//		Find.Object("rsEdit" + prefix + "Btn").click();
        Find.Object("rs" + prefix + "AddressTxt").clear();
        Find.Object("rs" + prefix + "AddressTxt").input(address);
        Find.Object("rs" + prefix + "AddressApplyBtn").click();
    }

    @Override
    public void ChangePaymentType(int index) throws Exception {
        Find.Object("rsPaymentTypeChange").select(index);
        Find.Object("rsDefaultPaymentBtn").click();
        clickApplyCreditCard();
    }

    @Override
    public void EditCreditCard(String name) throws Exception {

        Find.Object("rsPaymentTypeEditBtn").click();
        Find.Object("rsEditCCName").clear();
        Find.Object("rsEditCCName").input(name);
        Find.Object("rspEditCCccvTxt_wk").input("222");
        clickApplyCreditCard();
    }

    private void clickApplyCreditCard() throws Exception {
        Find.Object("rsEditCCCApplyBtn").click();
    }

    @Override
    public void ClickShippingAndBillingTab() throws Exception {
        Find.Object("rsShippingAndBillingTab").javascriptClick();

    }

    @Override
    public void RemoveGift(String sku) throws Exception {

        Thread.sleep(6000);
        Find.Object("rspRemoveGift_WS")
                .changeContainsText(sku)
                .click();
        // Find.ObjectWith("jsItemRoot", "data-cartproductcode", sku,
        // "a[class='action-link jsRemoveGifting']").click();
    }

    @Override
    public void EditCreditCard(String name, String paymentType, String ccNumber)
            throws Exception {

        StepLogger.validate(Check.ObjectPresent, "rsPaymentTypeEditBtn");

        Find.Object("rsPaymentTypeEditBtn").click();

        StepLogger.validate(Check.ObjectPresent, "rsEnterNewShipAddRadio");
        Find.Object("rsEnterNewShipAddRadio").click();
        Thread.sleep(5000);
        Find.Object("rsEditCCNewPayTypedropdown").select(paymentType);

        if (!(Find.Object("rspEditCCWindow").getText().value()
                .contains("CONTINUE TO PAYPAL"))) {

            Find.Object("pyCreditCardNumber").input(ccNumber);
            Find.Object("pyNameOnCard").input(name);
            Find.Object("pyMonth").select(12);
            Find.Object("pyYear").select(6);
            if (Find.Object("pySecurityCode").isPresent())
                Find.Object("pySecurityCode").input("213");
            Find.Object("rsEditNewPayTypeDefaultPaychkbox").click();

            StepLogger.validate(Check.ObjectPresent, "rsEditCCCApplyBtn");
            Find.Object("rsEditCCCApplyBtn").click();
            if (Find.Object("rspEditCCWindow").isPresent()) {
                if (Find.Object("rspEditCCWindow").getText().value()
                        .contains("Please check the error")
                        || Find.Object("rspEditCCWindow").getText().value()
                        .contains("You have already entered")) {

                    Report.dataFail(
                            "Card Number Already Present: You have already entered this card number. Please enter a different card number.",
                            BrowserAction.screenshot());
                }
            }

        } else {
            Find.Object("rsPayPalContinueBtn").click();
        }

    }

    @Override
    public void UpdateQuantity(String upc, String qty) throws Exception {
        Find.Object("rspItemQuantity").changeContainsText(upc).clear();
        Find.Object("rspItemQuantity").changeContainsText(upc).input(qty);
    }

    @Override
    public QuickLookOverLay ClickEditItem(String sku) throws Exception {
        New.Object("")
                .setProperty(Type.PropertyType.CSS_SELECTOR,
                        "div[class='jsItemRoot widebag-item ']")
                .setProperty(Type.PropertyType.CONTAINS_TEXT, sku)
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.TAG_NAME, "a")
                .setChildProperty(Type.PropertyType.CSS_SELECTOR,
                        "a[class='action-link jsEditItem']").click();
        return new com.hbcd.banner.commomplatform.fullsite.overlays.QuickLookOverLay();
    }

    @Override
    public void ChangeItemLevelShippingAddress(String upc, String address, String state, String city, String zipcode, Boolean makeDefaultAddress) throws Exception {
        Find.Object("rspItemLevelEditShipAdd_WS").changeContainsText(upc).click();
        StepLogger.validate(Check.ObjectPresent, "rsEnterNewShipAddRadio");
        Find.Object("rsEnterNewShipAddRadio").click();
        insertCredentials(true, "Shipping", address, state, city, zipcode, "",
                makeDefaultAddress);
    }

    @Override
    public void ClickSignatureRequiredDelivery(String upc) throws Exception {

        Find.Object("rspSignatureReqdItemLevel_WS").changeContainsText(upc).click();
    }

    @Override
    public void ClickEditShippingMethod(String upc, ShipMethod shipMethod) throws Exception {
        Find.Object("rspShippingMethodRadio_wk").changeContainsText(upc).changeChildContainsText(shipMethod.toString()).click();
        Thread.sleep(10000L);
        Find.Object("rspShippingMethodRushChoice_wk").changeContainsText(upc).click();
    }

    @Override
    public void ClickEditShippingMethod(ShipMethod shipMethod) throws Exception {
        Find.Object("rspSingleShippingMethodRadio_wk").changeChildContainsText(shipMethod.toString()).click();
        Thread.sleep(10000L);
    }

    private void UpdateShippingMethod(String shippingMethod, Boolean signReqd) throws Exception {

        StepLogger.validate(Check.ObjectPresent, "rsShippingMethodApply_WS");
        if (shippingMethod.toLowerCase().equalsIgnoreCase("rush")) {
            Find.Object("rsShippingMethodRushBtn_WS").click();
        }
        if (shippingMethod.toLowerCase().equalsIgnoreCase("standard")) {

            Find.Object("rsShippingMethodStandardBtn").click();
        }
        if (shippingMethod.toLowerCase().equalsIgnoreCase("next bus. day")) {

            Find.Object("rsShippingMethodNextBusDayBtn").click();
        }
        if (shippingMethod.toLowerCase().equalsIgnoreCase("saturday")) {

            Find.Object("rsShippingMethodSaturdayBtn").click();
        }

        if (signReqd)
            Find.Object("rsSignatureReqdOverlay_WS").click();
        Find.Object("rsShippingMethodApply_WS").click();
    }

    @Override
    public void ClickCloseShippingMethodOverlay() throws Exception {

        Find.Object("rsShippingMethodOverlayCancelBtn").click();
    }

    @Override
    public void ClearAllItemsInBag() throws Exception {

        while (!Find.Object("rspEmptyBag_WS").isPresent()) {

            if (!Find.Object("rspItemsZero_WS").getText().value().contains("(0)")) {
                Find.Object("rspRemoveFirstItem_WS").click();
                if (Find.Object("rspRemoveItemConfirmPopup_WS").isPresent())
                    Find.Object("rspRemoveItemConfirmPopup_WS").click();
            }
        }
    }

    @Override
    public void IsReviewSubmitPage() throws Exception {
        if(Find.Object("rsPlaceOrderBtn").isPresent()) {
            Report.pass("User is on Review Submit Order Page");
        } else {
            Report.fail("User is not on Reivew Submit Order Page");
        }
    }

    @Override
    public void ClickEditBillingAddress() throws Exception {

    }
}
