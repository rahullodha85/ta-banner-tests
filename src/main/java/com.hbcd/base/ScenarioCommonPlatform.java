package com.hbcd.base;

import com.hbcd.banner.LordAndTaylor.fullsite.overlays.*;
import com.hbcd.banner.LordAndTaylor.fullsite.pages.*;
import com.hbcd.banner.Off5th.fullsite.overlays.*;
import com.hbcd.banner.Off5th.fullsite.pages.*;
import com.hbcd.banner.commomplatform.fullsite.overlays.*;
import com.hbcd.banner.commomplatform.fullsite.pages.*;
import com.hbcd.banner.commomplatform.mobile.overlays.*;
import com.hbcd.banner.commomplatform.mobile.pages.*;
import com.hbcd.banner.common.paypal.pInformationPage;
import com.hbcd.banner.factory.Factory;
import com.hbcd.banner.mobile.saks.overlays.mSmartSampleOverlay;
import com.hbcd.banner.mobile.saks.pages.*;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.s5a.overlays.*;
import com.hbcd.banner.s5a.pages.aemPdp.AemProductDetailPage;
import com.hbcd.banner.s5a.pages.*;
import com.hbcd.banner.validations.s5a.*;
import com.hbcd.banner.webservice.fedex.fedexAddressApiClient;
import com.hbcd.commonbanner.base.pages.BagPageBase;
import com.hbcd.commonbanner.base.pages.PDPPageBase;
import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.commonbanner.enums.ToggleType;
import com.hbcd.commonbanner.pages.ConfirmationPage;
import com.hbcd.commonbanner.pages.ShippingPage;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.ScriptData;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;

/**
 * Created by 461967 on 6/13/2016.
 */
public class ScenarioCommonPlatform extends ScenarioRetailDomain {

    @Override
    public void beforeExecuteScript() throws Exception {

        try {
            switch (ApplicationSetup.get(Setting.SITE)) {
                case "SAKS_FIFTH":
                    InitializeSaks();
                    break;
                case "LT":
                    InitializeLT();
                    break;
                case "OFF_FIFTH":
                    InitializeO5();
                    break;
                case "OFF_FIFTH_MOBILE":
                    InitializeO5Mobile();
                    break;
                case "SAKS_FIFTH_MOBILE":
                    InitializeSaksMobile();
                    break;
                default:
                    InitializeSaks();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.Error(e.getMessage());
        }
    }

    private void InitializeSaks() throws Exception {
        itemData = new ScriptData(dataObject);
        pdp = new s5a_ProductDetailPage();
        pdp = new AemProductDetailPage();
        bag = new s5a_BagPage();
        shp = new s5a_ShippingPage();
        pap = new s5a_PaymentPage();
        rsp = new s5a_ReviewSubmitPage();
        yap = new s5a_YourAccountPage();
        ccp = new s5a_ContactCenterPage();
        lno = new s5a_LoginOverlay();
        fdxRqst = new fedexAddressApiClient();
        nav = new s5a_Navigation();
        sec = new s5a_SectionPage();
        prp = new s5a_ProductArray();
        icp = new s5a_InternationalCheckout();
        slp = new s5a_StoreLocator();
        qlo = new s5a_QuickLookOverlay();
        fis = new s5a_FindInStore();
        shr= new s5a_ShopRunner();
        sip = new SignInPage();
        cap = new CreateAccountPage();
        fpp = new ForgotPasswordPage();
        accSum = new AccountSummaryPage();
        accSet = new AccountSettingsPage();
        chngPwd = new ChangePasswordOverlay();
        editPro = new EditProfileOverlay();
        ordHis = new OrderHistoryPage();
        accPay = new AccountPaymentPage();
        accShp = new AccountShippingAddressPage();
        accBill = new AccountBillingAddressPage();
        ordDet = new OrderDetailsPage();
        editPay = new EditPaymentMethodOverlay();
        editShp = new EditShippingAddrOverlay();
        emailPref = new EditEmailPrefOverlay();
        gcp = new s5a_GiftCardsPage();
        conf= new s5a_ConfirmationPage();
        sso = new s5a_SmartSampleOverlay();
        saksFirst = new LinkYourSaksFirstOverlay();
        miniBagOverlay= new s5a_MiniBagOverlay();

        super.beforeExecuteScript();

        ValidateConfirmation.setToggleStatus(Factory.isNew(ToggleType.CHECKOUT_CONFIRMATION));
        ValidateShippingBilling.setToggleStatus(Factory.isNew(ToggleType.CHECKOUT_SHIPPINGBILLING));
        ValidatePap.setToggleStatus(Factory.isNew(ToggleType.CHECKOUT_PAYMENT));
        ValidateBag.setToggleStatus(Factory.isNew(ToggleType.CHECKOUT_BAG));
        ValidateYourAcc.setToggleStatus(Factory.isNew(ToggleType.CHECKOUT_CONFIRMATION));
        ValidateRs.setToggleStatus(Factory.isNew(ToggleType.CHECKOUT_REVIEWSUBMIT));

        nav.CloseHomePagePopup();
    }

    private void InitializeLT() throws Exception {
        pdp = new LT_PdpPage();
        bag = new LT_BagePage();
        shp = new LT_ShippingPage();
        pap = new LT_PaymentPage();
        rsp = new LT_ReviewSubmitPage();
        yap = new LT_YourAccountPage_OLD();
        ccp = new LT_ContactCenterPage();
        lgn = new LT_LoginOverlay();
//        fdxRqst = new fedexAddressApiClient();
        nav = new LT_Navigation();
        sec = new LT_SectionPage();
        prp = new LT_ProductArrayPage();
        slp = new LT_StoreLocatorPage();
        qlo = new LT_QuickLookOverLay();
        fis = new LT_FindInStore();
        shr= new LT_ShopRunnerSigninOverlay();
        gcp = new LT_GiftCardsPage();
        conf= new LT_ConfirmationPage();
        miniBagOverlay=new LT_MiniBagOverlay();
        super.beforeExecuteScript();

        nav.CloseHomePagePopup();
    }

    private void InitializeO5() throws Exception {
        pdp = new o5_PdpPage();
        bag = new o5_BagPage();
        shp = new o5_ShippingPage();
        pap = new o5_PaymentPage();
        rsp = new o5_ReviewSubmitPage();
        yap = new o5_YourAccountPage_OLD();
        ccp = new o5_ContactCenterPage();
        lno = new o5_LoginOverlay();
//        fdxRqst = new fedexAddressApiClient();
        nav = new o5_Navigation();
        sec = new o5_SectionPage();
        prp = new o5_ProductArrayPage();
        slp = new o5_StoreLocatorPage();
        qlo = new o5_QuickLookOverLay();
        fis = new o5_FindInStore();
        shr= new o5_ShopRunnerSigninOverlay();
        gcp = new o5_GiftCardsPage();
        conf= new o5_ConfirmationPage();
        sip = new o5_SignInPage();
        cap = new o5_CreateAccountPage();
        fpp = new o5_ForgotPasswordPage();
        accSum = new o5_AccountSummaryPage();
        accSet = new o5_AccountSettingsPage();
        chngPwd = new o5_ChangePasswordOverlay();
        editPro = new o5_EditProfileOverlay();
        ordHis = new o5_OrderHistoryPage();
        accPay = new o5_AccountPaymentPage();
        accShp = new o5_AccountShippingAddressPage();
        accBill = new o5_AccountBillingAddressPage();
        ordDet = new o5_OrderDetailsPage();
        editPay = new o5_EditPaymentMethodOverlay();
        editShp = new o5_EditShippingAddrOverlay();
        emailPref = new o5_EditEmailPrefOverlay();
        miniBagOverlay = new MiniBagOverlay();
        super.beforeExecuteScript();

        nav.CloseHomePagePopup();
    }

    private void InitializeSaksMobile() throws Exception {
        itemData = new ScriptData(dataObject);
        prp = new mProductArray();
        cop = (ConfirmationPage) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_CONFIRMATION);
        pdp = new AemProductDetailPage();
        bag = (BagPageBase) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_BAG);
        shp = (ShippingPage) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_SHIPPINGBILLING);
        rsp = new mReviewSubmitPage();
        papl = new pInformationPage();
        nav = new mNavigation();
        pap = new mPaymentPage();
        sec = new mSectionPage();
        sip = new mSignInPage();
        fpp = new mForgotPasswordPage();
        cap = new mCreateAccountPage();
        accSum = new mAccountSummaryPage();
        accSet = new mAccountSettingsPage();
        chngPwd = new mChangePasswordOverlay();
        editPro = new mEditProfileOverlay();
        ordHis = new mOrderHistoryPage();
        accPay = new mAccountPaymentPage();
        accShp = new mAccountShippingAddressPage();
        accBill = new mAccountBillingAddressPage();
        ordDet = new mOrderDetailsPage();
        editPay = new mEditPaymentMethodOverlay();
        editShp = new mEditShippingAddrOverlay();
        emailPref = new mEditEmailPrefOverlay();
        sso = new mSmartSampleOverlay();
        miniBagOverlay = new mMiniBagOverlay();
        super.beforeExecuteScript();

        ValidateShipping.setToggleStatus(Factory
                .isNew(ToggleType.CHECKOUT_MOBILE_SHIPPINGBILLING));

        ValidateConfirmation.setToggleStatus(Factory
                .isNew(ToggleType.CHECKOUT_MOBILE_CONFIRMATION));

        ValidateYourAcc.setToggleStatus(Factory
                .isNew(ToggleType.CHECKOUT_MOBILE_CONFIRMATION));
    }

    private void InitializeO5Mobile() throws Exception {
        prp = new mProductArray();
        cop = (ConfirmationPage) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_CONFIRMATION);
        pdp = (PDPPageBase) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_PDP);
        bag = (BagPageBase) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_BAG);
        shp = (ShippingPage) Factory
                .getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_SHIPPINGBILLING);
        rsp = new mReviewSubmitPage();
        papl = new pInformationPage();
        nav = new mNavigation();
        pap = new mPaymentPage();
        sec = new mSectionPage();
        sip = new mSignInPage();
        fpp = new mForgotPasswordPage();
        cap = new mCreateAccountPage();
        accSum = new mAccountSummaryPage();
        accSet = new mAccountSettingsPage();
        chngPwd = new mChangePasswordOverlay();
        editPro = new mEditProfileOverlay();
        ordHis = new mOrderHistoryPage();
        accPay = new mAccountPaymentPage();
        accShp = new mAccountShippingAddressPage();
        accBill = new mAccountBillingAddressPage();
        ordDet = new mOrderDetailsPage();
        editPay = new mEditPaymentMethodOverlay();
        editShp = new mEditShippingAddrOverlay();
        emailPref = new mEditEmailPrefOverlay();
        sso = new mSmartSampleOverlay();
        miniBagOverlay = new mMiniBagOverlay();
        super.beforeExecuteScript();

        ValidateShipping.setToggleStatus(Factory
                .isNew(ToggleType.CHECKOUT_MOBILE_SHIPPINGBILLING));

        ValidateConfirmation.setToggleStatus(Factory
                .isNew(ToggleType.CHECKOUT_MOBILE_CONFIRMATION));

        ValidateYourAcc.setToggleStatus(Factory
                .isNew(ToggleType.CHECKOUT_MOBILE_CONFIRMATION));
    }
}
