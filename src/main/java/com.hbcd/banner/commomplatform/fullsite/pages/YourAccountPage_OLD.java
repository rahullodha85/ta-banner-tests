package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.overlays.AddressOverlay_OLD;
import com.hbcd.banner.s5a.overlays.s5a_AddressOverlay;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.commonbanner.base.pages.YourAccountPageBase;
import com.hbcd.commonbanner.overlays.AddPaymentOverlay;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.pages.ManageShippingPage;
import com.hbcd.commonbanner.pages.YourAccountPage;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import static com.hbcd.utility.helper.Common.getUniqueNumber;

/**
 * Created by 461967 on 6/1/2016.
 */
public class YourAccountPage_OLD extends YourAccountPageBase {
    @Override
    public void CancelOrder(String orderNumber, String zip) throws Exception {
        StepLogger.validate(Check.ObjectPresent, "glpYourAccountBtn");
        Find.Object("glpYourAccountBtn").click();
        Find.Object("yaOrderNumberTxt").input(orderNumber);
        Find.Object("yaOrderZipTxt").input(zip);

        StepLogger.validate(Check.ObjectPresent, "yaViewOrderStatus");
        Find.Object("yaViewOrderStatus").click();
        StepLogger.validate(Check.ObjectPresent, "yaCancelOrder");
        Find.Object("yaCancelOrder").click();

        if (ValidateYourAcc.setAlertPopup()) {
            Alert.Confirm();
            Alert.Confirm();
        }


    }

    @Override
    public void Go() throws Exception {
        Thread.sleep(2000L);
        StepLogger.validate(Check.ObjectPresent, "conMyAccountBtn");
        Find.Object("conMyAccountBtn").click();
    }

    @Override
    public void Login(String email, String pwd) throws Exception {

        Find.Object("glpYourAccountBtn").click();
        if(Find.Object("yapLoginEmail").isPresent()) {
            Report.pass("SignIn Page email textbox found and user email entered",
                    BrowserAction.screenshot());
//            Find.Object("yapLoginEmail").clear();
            Find.Object("yapLoginEmail").input(email);
        }else{
            Report.fail("SignIn Page email textbox not found",
                    BrowserAction.screenshot());
        }
        if(Find.Object("yapLoginPwd").isPresent()) {
            Report.pass("SignIn Page password textbox found and user password entered",
                    BrowserAction.screenshot());
//            Find.Object("yapLoginPwd").clear();
            Find.Object("yapLoginPwd").input(pwd);
        }else{
            Report.fail("SignIn Page password textbox not found",
                    BrowserAction.screenshot());
        }
        if(Find.Object("yapSignInBtn").isPresent()) {
            Report.pass("SignIn Page signIn button found and clicked",
                    BrowserAction.screenshot());
            Find.Object("yapSignInBtn").click();
        }else{
            Report.fail("SignIn Page signIn button not found",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public void Login(String email) throws Exception {

        StepLogger.validate(Check.ObjectPresent, "glpYourAccountBtn");
        Find.Object("glpYourAccountBtn").click();
        Find.Object("yapLoginEmail").input(email);

        StepLogger.validate(Check.ObjectPresent, "yapSignInCCBtn");

        Find.Object("yapSignInCCBtn").click();
    }

    @Override
    public void ClickPaymentInformation() throws Exception {
        Find.Object("yapPaymentMethodBtn").click();
    }

    @Override
    public void RemoveCreditCard() throws Exception {
        Find.Object("yapRemoveCCBtn").click();
    }

    @Override
    public void AddCreditCard(String card, String cardNumber, String cardholderName, String cardMonth, String cardYear) throws Exception {
        Find.Object("yapCreditCardDropdown").select(card);
        Find.Object("yapCreditCardNumber").input(cardNumber);
        Find.Object("yapCreditCardName").input(cardholderName);
        Find.Object("yapCreditCardMonth").select(cardMonth);
        Find.Object("yapCreditCardYear").select(cardYear);
        Find.Object("yapCreditCardSaveBtn").click();
    }

    @Override
    public void VerifyShippingAddressBook(String address) throws Exception {
        Find.Object("yapShippingAddressBookBtn").click();
        this.AddressValidation(address);
    }

    @Override
    public void VerifyBillingAddressBook(String address) throws Exception {
        Find.Object("yapBillingAddressBookBtn").click();
        this.AddressValidation(address);
    }

    public static void AddressValidation(String address) throws Exception {
        StepLogger.validate(Check.TextPresent, "yapPaymentMethodForm", address);
    }

    @Override
    public AddressOverlay ClickAddBilling() throws Exception {
        Find.Object("proEditBilling").click();
        return new AddressOverlay_OLD();
    }

    @Override
    public AddressOverlay ClickAddShipping() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "proEditShipping");
        Find.Object("proEditShipping").click();
        return new AddressOverlay_OLD();
    }

    @Override
    public void CreateAccount(String email) throws Exception {
        Find.Object("yapCreateAccountBtn").click();
        Find.Object("yapSelectTItle").select("Ms.");
        Find.Object("yapFirstName").input("Hello");
        Find.Object("yapLastName").input("World");
        Find.Object("yapPassword").input("test@123");
        Find.Object("yapConfirmPassword").input("test@123");
        Find.Object("yapSaveBtn").click();
    }

    @Override
    public void CreateRandomAccount(String email) throws Exception {
        Thread.sleep(1000);
        int n = getUniqueNumber();
        email = email.split("@")[0] + n + "@" + email.split("@")[1];
        StepLogger.validate(Check.ObjectPresent, "yapCreateAccountBtn");
        if(Find.Object("yapCreateAccountBtn").isPresent()) {
            Report.pass("Create Account button found and clicked",
                    BrowserAction.screenshot());
            Find.Object("yapCreateAccountBtn").click();
            if(Find.Object("yapEmailId").isPresent()) {
                Report.pass("User on account creation page and filling data-form to create account",
                        BrowserAction.screenshot());
                Find.Object("yapSelectTItle").select("Ms.");
                Find.Object("yapFirstName").input("Hello");
                Find.Object("yapLastName").input("World");
                Find.Object("yapPassword").input("test123");
                Find.Object("yapConfirmPassword").input("test123");
                Find.Object("yapEmailId").input(email);
                Find.Object("accountSaveButton_RL").click();
                Storage.save("emailAddress2", email);
            }else{
                Report.fail("User is not on account creation page",
                        BrowserAction.screenshot());
            }
        }else{
            Report.fail("Create Account button not found",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public void clickSave() throws Exception {

        StepLogger.validate(Check.ObjectPresent, "yapSaveBtn");

        Find.Object("yapSaveBtn").click();
    }

    @Override
    public void Signout() throws Exception {
        Find.Object("accountbtn").hover();
        /*Find.Object("yapLogOutBtn").isPresent();
        Find.Object("yapLogOutBtn").click();*/
        if (Find.Object("yapLogOutBtn").isPresent()) {
            Find.Object("yapLogOutBtn").click();
        }
    }

    @Override
    public void AccessOrderStatus(String orderNumber, String zipCode) throws Exception {
        Find.Object("yapOrderNumberTxt").input(orderNumber);
        Find.Object("yapBillingZipCodeTxt").input(zipCode);
        Find.Object("yapAccessDetailsBtn").click();
    }

    @Override
    public void ClickShippingAddressBook() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "yapShippingAddressBookBtn");
        Find.Object("yapShippingAddressBookBtn").click();
        if (ValidateYourAcc.setAlertPopup()) {
            Alert.Confirm();
        }
    }

    @Override
    public void ClickBillingAddressBook() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "yapBillingAddressBookBtn");
        Find.Object("yapBillingAddressBookBtn").click();
        if (ValidateYourAcc.setAlertPopup()) {
            Alert.Confirm();
        }
    }

    @Override
    public void removeFromShippingAddressBook(String address) throws Exception {
        Find.Object("yapRemoveSelectedAddress").changeContainsText(address).click();
    }

    @Override
    public void removeFromBillingAddressBook(String address) throws Exception {
        Find.Object("yapRemoveSelectedBAddress").changeContainsText(address).click();
    }

    @Override
    public void clickSaksFifthLogo() throws Exception {
        if(Find.Object("saksfifthHomePageLogo_AAF").isDisplayed()){
            Find.Object("saksfifthHomePageLogo_AAF").click();
        }
    }

    @Override
    public void AddNewAddress(String firstName, String lastName,
                              String streetaddress,String streetaddress2,
                              String city, String country,
                              String province, String postalCard,
                              String phonenumber1,String phonenumber2,
                              String phonenumber3,String phoneextension) throws Exception {
        if(Find.Object("htmlPage").getText().value().toLowerCase().contains("add a new shipping address")){
            Report.pass("User is on shipping address page",
                    BrowserAction.screenshot());
            Find.Object("proShippingFirstNameTxt").clear();
            Find.Object("proShippingFirstNameTxt").input(firstName);
            Find.Object("proShippingLastNameTxt").clear();
            Find.Object("proShippingLastNameTxt").input(lastName);
            Find.Object("proShippingAddress1Txt").clear();
            Find.Object("proShippingAddress1Txt").input(streetaddress);
            Find.Object("proShippingcityTxt").clear();
            Find.Object("proShippingcityTxt").input(city);
            Find.Object("proShippingStateBtn").select(province);
            Find.Object("proShippingZipCodeTxt").clear();
            Find.Object("proShippingZipCodeTxt").input(postalCard);
            Find.Object("proShippingPhoneTxt").clear();
            Find.Object("proShippingPhoneTxt").input(phonenumber1+phonenumber2+phonenumber3);
            if(Find.Object("proShippingSaveBtn").isPresent()){
                Report.pass("Save button is present",
                        BrowserAction.screenshot());
                Find.Object("proShippingSaveBtn").click();
                if(Find.Object("confirmAddress_RL").isPresent()){
                    Find.Object("confirmAddress_RL").click();
                }
            }
        }else if(Find.Object("htmlPage").getText().value().toLowerCase().contains("add a new billing address")){
            Report.pass("User is on shipping address page",
                    BrowserAction.screenshot());
            Find.Object("rsBillingfirstNameTxt").clear();
            Find.Object("rsBillingfirstNameTxt").input(firstName);
            Find.Object("rsBillinglastNameTxt").clear();
            Find.Object("rsBillinglastNameTxt").input(lastName);
            Find.Object("rsBillingAddressTxt").clear();
            Find.Object("rsBillingAddressTxt").input(streetaddress);
            Find.Object("rsBillingCityTxt").clear();
            Find.Object("rsBillingCityTxt").input(city);
            Find.Object("rsBillingStateDrpDwn").select(province);
            Find.Object("rsBillingZipCodeTxt").clear();
            Find.Object("rsBillingZipCodeTxt").input(postalCard);
            Find.Object("rsBillingAddressCntryDrpDwn").select(country);
            Find.Object("rsBillingPhoneTxt").clear();
            Find.Object("rsBillingPhoneTxt").input(phonenumber1 + phonenumber2 + phonenumber3);
            if(Find.Object("rsBillingAddressApplyBtn").isPresent()){
                Report.pass("Save button found and clicked",
                        BrowserAction.screenshot());
                Find.Object("rsBillingAddressApplyBtn").click();
                if(Find.Object("confirmAddress_RL").isPresent()){
                    Find.Object("confirmAddress_RL").click();
                }
            }
        }
        else{
            Report.fail("User is not on any address page",
                    BrowserAction.screenshot());
        }
    }

    public ManageShippingPage ClickManageShipping() {
        return null;
    }

    public AddressOverlay ClickEditProfileAddress() {
        return null;
    }

    public AddPaymentOverlay ClickAddPayment() {
        return null;
    }


    public YourAccountPage GoToMyAcccount() throws Exception {
        Go();
        return new YourAccountPage_OLD();
    }

    public void ClickRemovePayment(String cardName) {
    }

    public void CancelMostRecentOrder() {
    }

    public void ClickRemoveAddress() {
    }

    public void ChangePassword(String current, String password) {
    }
}
