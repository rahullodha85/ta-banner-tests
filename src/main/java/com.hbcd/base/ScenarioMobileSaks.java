package com.hbcd.base;

import com.hbcd.banner.commomplatform.mobile.overlays.*;
import com.hbcd.banner.commomplatform.mobile.pages.*;
import com.hbcd.banner.common.paypal.pInformationPage;
import com.hbcd.banner.common.paypal.pLogin;
import com.hbcd.banner.common.paypal.pReview;
import com.hbcd.banner.factory.Factory;
import com.hbcd.banner.mobile.saks.overlays.mSmartSampleOverlay;
import com.hbcd.banner.mobile.saks.pages.mBagPage;
import com.hbcd.banner.mobile.saks.pages.mNavigationPage;
import com.hbcd.banner.mobile.saks.pages.mPaymentPage;
import com.hbcd.banner.mobile.saks.pages.mProductArray;
import com.hbcd.banner.mobile.saks.pages.mReviewSubmitPage;
import com.hbcd.banner.mobile.saks.pages.mSectionPage;
import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.commonbanner.base.pages.BagPageBase;
import com.hbcd.commonbanner.base.pages.OrderDetailsPageBase;
import com.hbcd.commonbanner.base.pages.PDPPageBase;
import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.commonbanner.enums.ToggleType;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.commonbanner.pages.ConfirmationPage;
import com.hbcd.commonbanner.pages.ShippingPage;
import com.hbcd.scripting.core.ScriptData;

public class ScenarioMobileSaks extends ScenarioRetailDomain {

	protected pLogin plog;
	protected pInformationPage pinf;
	protected pReview prev;
	
	public ScenarioMobileSaks(){
		
	}
	
	@Override
	public void beforeExecuteScript() throws Exception
	{
//		itemData = new ScriptData(dataObject);
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
		lgn = (LoginOverlay) Factory
				.getPageUsingToggle(ToggleType.CHECKOUT_MOBILE_LOGIN);
		papl = new pInformationPage();
		nav = new mNavigationPage();
		pap = new mPaymentPage();
		plog = new pLogin();
		pinf = new pInformationPage();
		prev = new pReview();
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
		super.beforeExecuteScript();

		ValidateShipping.setToggleStatus(Factory
				.isNew(ToggleType.CHECKOUT_MOBILE_SHIPPINGBILLING));

		ValidateConfirmation.setToggleStatus(Factory
				.isNew(ToggleType.CHECKOUT_MOBILE_CONFIRMATION));

		ValidateYourAcc.setToggleStatus(Factory
				.isNew(ToggleType.CHECKOUT_MOBILE_CONFIRMATION));
	}
}
