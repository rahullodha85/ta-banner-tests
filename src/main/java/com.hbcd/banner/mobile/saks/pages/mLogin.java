package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.commonbanner.base.overlays.LoginOverlayBase;
import com.hbcd.banner.common.paypal.pLogin;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;


public class mLogin extends LoginOverlayBase {

	private pLogin pLoginSaks;
	
	public mLogin(){
		pLoginSaks=new pLogin();
	}
	@Override
	public void LoginWith(String username, String password) throws Exception {
		
		if(Find.Object("homePageNavLinksSec_WS").isPresent()){
			

			Report.systemFail("Home Page is displayed instead of Login Page", BrowserAction.screenshot());
		}
		
		if(!(Find.Object("shpNextBtn_WS").isPresent()||Find.Object("rsPlaceOrderBtn").isPresent())){
			Find.Object("bagLoginEmailTxt").input(username);
			Find.Object("bagLoginPassTxt").input(password);
			
			StepLogger.validate(Check.ObjectPresent, "bagSignInBtn");
			
			Find.Object("bagSignInBtn").click();
			
			if(Find.Object("saksBagAdditionalItemError_WS").isPresent() && 
					Find.Object("saksBagAdditionalItemError_WS").validateWithPresetData()){
				
				
				if(Find.Object("bagCheckoutLoggedInBtn_WS").isPresent()){
					
					StepLogger.validate(Check.ObjectPresent, "bagCheckoutLoggedInBtn_WS");
					Find.Object("bagCheckoutLoggedInBtn_WS").click();
				}
					
			}

			if(Find.Object("shpNextBtn_WS").isPresent())
			{
				StepLogger.validate(Check.ObjectPresent,"shpNextBtn_WS");
				Find.Object("shpNextBtn_WS").click();
			}
		}
		else if(Find.Object("shpNextBtn_WS").isPresent()){
			
			Find.Object("shpNextBtn_WS").click();
		}
	}

	@Override
	public void LoginWith(String email) throws Exception {
		
		if(!Find.Object("shpNextBtn_WS").isPresent()){
		
			StepLogger.validate(Check.ObjectPresent, "lgnEmailIdUnregistered");
			Find.Object("lgnEmailIdUnregistered").input(email);
			StepLogger.validate(Check.ObjectPresent, "lgnGuestCheckoutBtn");
			Find.Object("lgnGuestCheckoutBtn").click();
			if(Find.Object("bagCheckoutLoggedInBtn_WS").isPresent()){
				
				StepLogger.validate(Check.ObjectPresent, "bagCheckoutLoggedInBtn_WS");
				Find.Object("bagCheckoutLoggedInBtn_WS").click();
			}

		}
		else{
			
			Find.Object("shpNextBtn_WS").click();
		}

				
	}

	@Override
	public void IsInvalidEmail() {
	}

	@Override
	public void forgotPassword(String email) {

	}

	@Override
	public void IsInvalidPassword() {
	}

	@Override
	public void LoginWithPassword(String password) {

	}

	@Override
	public void LoginWithPaypal(String username, String password) throws Exception {
		
		pLoginSaks.LoginWithPaypal(username,password);
		
	}

	@Override
	public void ClickForgotPassword() {

	}
	@Override
	public void LoginThruCC(String email) {

	}

	@Override
	public void LoginLock(String email, String password) {

	}

	@Override
	public void ClickGuestCheckout() throws Exception {
		if (Find.Object("loginOverlayCheckoutAsGuestBtn_wk").isPresent()) {
			Report.pass("Guest checkout button found and clicked");
			Find.Object("loginOverlayCheckoutAsGuestBtn_wk").click();
		} else {
			Report.fail("Guest checkout button is not present on login overlay");
		}
	}
}
