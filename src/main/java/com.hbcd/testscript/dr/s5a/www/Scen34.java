package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen34 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		yap.GoToMyAcccount();
		yap.CreateRandomAccount("testautomation");
		yap.clickSave();
		Alert.Confirm();
		yap.ClickAddShipping().fillNewProfileShippingAddress("",
				"13 E 49th St", "New York", "New York", "10017");
		yap.ClickAddBilling().fillNewProfileBillingAddress("United States",
				"13 E 49th St", "New York", "New York", "10017");
		ValidateNav.hasWelcomeUser("Hello");
		nav.goToPage("Your Account");
		ValidateYourAcc.ValidateIsOnThePage("ACCOUNT INFORMATION FOR");
		nav.goToPage("Order History");
		ValidateYourAcc.ValidateIsOnOrderHistoryPage("ORDER HISTORY");
		nav.goToPage("Account and Email Settings");
		ValidateYourAcc.ValidateIsOnAccountEmailPage();
		nav.goToPage("Shipping Address Book");
		ValidateYourAcc
				.ValidateIsOnOrderHistoryPage("ADD A NEW SHIPPING ADDRESS");
		nav.goToPage("Billing Address Book");
		ValidateYourAcc.ValidateIsOnBillingAddressPage();
		nav.goToPage("Payment Method");
		ValidateYourAcc.ValidateIsOnOrderHistoryPage("PAYMENT METHOD");
		nav.goToPage("SaksFirst and Online Billing");
		ValidateYourAcc.ValidateSaksFirstPage();
		yap.Signout();
		ValidateYourAcc.ValidateAccountPage();

		// Can't create conditions when
		// "User is returning user on the same machine and browser but not signed into any secure page including checkout"
		Navigate.go("http://qa.saks.com");
		
		yap.GoToMyAcccount();
		yap.Login(Storage.get("emailAddress2"), "test@123");
		ValidateNav.hasWelcomeUser("Hello");
		yap.ClickShippingAddressBook();
		yap.removeFromShippingAddressBook("Mr. James Altucher");
		yap.GoToMyAcccount();
		yap.ClickAddShipping().fillNewProfileShippingAddress("",
				"13 E 49th St", "New York", "New York", "10017");
		yap.ClickBillingAddressBook();
		yap.removeFromBillingAddressBook("Mr. James Altucher");
		yap.GoToMyAcccount();
		yap.ClickAddBilling().fillNewProfileBillingAddress("United States",
				"13 E 49th St", "New York", "New York", "10017");
		yap.ClickPaymentInformation();
		yap.AddCreditCard("MasterCard", "5444009999222205",
				"Tester Automation", "12 - December", "2017");
		nav.goToPage("Your Account");
		ValidateYourAcc.ValidateIsOnThePage("ACCOUNT INFORMATION FOR");
		nav.goToPage("Order History");
		ValidateYourAcc.ValidateIsOnOrderHistoryPage("ORDER HISTORY");
		nav.goToPage("Account and Email Settings");
		ValidateYourAcc.ValidateIsOnAccountEmailPage();
		nav.goToPage("Shipping Address Book");
		ValidateYourAcc
				.ValidateIsOnOrderHistoryPage("ADD A NEW SHIPPING ADDRESS");
		nav.goToPage("Billing Address Book");
		ValidateYourAcc.ValidateIsOnBillingAddressPage();
		nav.goToPage("Payment Method");
		ValidateYourAcc.ValidateIsOnOrderHistoryPage("PAYMENT METHOD");
		nav.goToPage("SaksFirst and Online Billing");
		ValidateYourAcc.ValidateSaksFirstPage();
		yap.Signout();
		ValidateYourAcc.ValidateAccountPage();

	}

}
