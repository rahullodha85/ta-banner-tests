package com.hbcd.banner.mobile.s5a.pages.redesign;

import com.hbcd.banner.mobile.saks.pages.mLogin;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mRedesignLogin extends mLogin implements LoginOverlay {

	@Override
	public void LoginWith(String email) throws Exception {
		Thread.sleep(2000L);
		if(Find.Object("loginOverlayCheckoutAsGuestBtn_wk").isPresent()){
			Report.pass("Login Overlay Displayed", BrowserAction.screenshot());
			Find.Object("loginOverlayCheckoutAsGuestBtn_wk").click();
		}else Report.systemFail("Login Overlay Not Displayed", BrowserAction.screenshot());
		Thread.sleep(3000L);
	}



	@Override
	public void LoginWith(String username, String password) throws Exception {

		if (Find.Object("homePageNavLinksSec_WS").isPresent()) {

			Report.systemFail("Home Page is displayed instead of Login Page",
					BrowserAction.screenshot());
		}

		if (!(Find.Object("shpNextBtn_WS").isPresent() || Find.Object(
				"rsPlaceOrderBtn").isPresent())) {
			StepLogger.validate(Check.ObjectPresent,"bagLoginEmailTxt");
			Find.Object("bagLoginEmailTxt").input(username);
			StepLogger.validate(Check.ObjectPresent, "bagLoginPassTxt");
			Find.Object("bagLoginPassTxt").input(password);

			StepLogger.validate(Check.ObjectPresent, "loginSignCheckOutBtn_wk");

			Find.Object("loginSignCheckOutBtn_wk").click();

			if (Find.Object("saksBagAdditionalItemError_WS").isPresent()
					&& Find.Object("saksBagAdditionalItemError_WS")
							.validateWithPresetData()) {

				if (Find.Object("bagCheckoutLoggedInBtn_WS").isPresent()) {

					StepLogger.validate(Check.ObjectPresent,
							"bagCheckoutLoggedInBtn_WS");
					Find.Object("bagCheckoutLoggedInBtn_WS").click();
				}

			}

		}
		if(Find.Object("shippingBillingError_WS").isPresent())
			Report.systemFail("Unable to Access Saks Bag", BrowserAction.screenshot());
		Thread.sleep(9000L);//Waseem: To counter instability in O5M env
		if (Find.Object("shpNextBtn_WS").isPresent()) {

			Find.Object("shpNextBtn_WS").click();
		}

	}

	public void EnterCredentials(String email,String pwd) throws  Exception{

		if (Find.Object("homePageNavLinksSec_WS").isPresent()) {

			Report.systemFail("Home Page is displayed instead of Login Page",
					BrowserAction.screenshot());
		}

		StepLogger.validate(Check.ObjectPresent, "bagLoginEmailTxt");
		Find.Object("bagLoginEmailTxt").input(email);
		StepLogger.validate(Check.ObjectPresent, "bagLoginPassTxt");
		Find.Object("bagLoginPassTxt").input(pwd);
		if (Find.Object("loginSignCheckOutBtn_wk").isPresent()){
			Report.pass("Signin Button is Enabled",BrowserAction.screenshot());
		}else{
			Report.fail("Signin Button is Disabled",BrowserAction.screenshot());

		}
		Find.Object("loginSignCheckOutBtn_wk").click();

	}

}
