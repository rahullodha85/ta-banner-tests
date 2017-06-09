package com.hbcd.banner.validations.s5a; 

import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import com.hbcd.utility.configurationsetting.ConfigurationLoader;

public class ValidateYourAcc {
	private static boolean newToggle = false;

	public static void setToggleStatus(boolean status) {
		newToggle = status;
	}

	public static boolean setAlertPopup() throws Exception {
		String env = ConfigurationLoader.getWebSiteURL("SAKS_FIFTH.URL");
		if (env.contains("qaslot10") || env.contains("http://qa.saks") || env.contains("qaslot34")||env.contains("qaslot41")||env.contains("qaslot40")||env.contains("qaslot6"))
			return false;
		else
			return true;
	}

	public static void ValidateNonExistingAccount() throws Exception {
		StepLogger.validate(Check.TextPresent, "yapPaymentMethodForm", "The e-mail address and/or password entered do not match a registered saks.com account.");
	}

	public static void ValidateLink(String linkName) throws Exception {

		StepLogger.validate(Check.TextPresent, "saksContainer", linkName);

	}

	public static void ValidateCC(String ccNumber) throws Exception {

		StepLogger.validate(Check.TextPresent, "yapPaymentMethodForm", ccNumber.substring(ccNumber.length() - 4));
	}

	public static void ValidateErrorMessage(String error) throws Exception {

		StepLogger.validate(Check.TextPresent, "yapErrorMessage", error);
	}

	public static void ValidateIsOnThePage(String title) throws Exception {

		StepLogger.validate(Check.TextPresent, "pageTitle");

	}

	public static void ValidateIsOnOrderHistoryPage(String text) throws Exception {

		StepLogger.validate(Check.TextPresent, "orderHistoryTitle", text);

	}

	public static void ValidateSaksFirstPage() throws Exception {

		StepLogger.validate(Check.TextPresent, "masterCardLink");

	}

	public static void ValidateAccountPage() throws Exception {

		StepLogger.validate(Check.ObjectPresent, "glpYourAccountBtn");
		Find.Object("glpYourAccountBtn").click();


	}

	public static void ValidateIsOnBillingAddressPage() throws Exception {

		StepLogger.validate(Check.TextPresent, "billingAddressTitle");
	}


	public static void ValidateIsOnAccountEmailPage() throws Exception {

		StepLogger.validate(Check.ObjectNotPresent, "AccountEmail_WS");

	}


	public static void ValidateShippingAddressBook(String address) throws Exception {

		ValidateYourAcc.AddressValidation(address);
	}

	public static void ValidateBillingAddressBook(String address) throws Exception {

		ValidateYourAcc.AddressValidation(address);
	}

	public static void AddressValidation(String address) throws Exception {
		StepLogger.validate(Check.TextPresent, "yapPaymentMethodForm", address);
	}

	public static void CreditCardContains(String ccNumber) throws Exception {
		if (newToggle) {
			Find.Object("yapAccountBtn").click();
			StepLogger.validate(Check.ObjectPresent, "yapPaymentMethodBtn");
			Find.Object("yapPaymentMethodBtn").click();
			Thread.sleep(6000);
			if (ValidateYourAcc.setAlertPopup())
				Alert.Confirm();
			ValidateYourAcc.ValidateCC(ccNumber);
		}


	}

	public static void ShippingAddressContains(String address) throws Exception {
		if (newToggle) {

			Find.Object("yapAccountBtn").click();
			StepLogger.validate(Check.ObjectPresent, "yapShippingAddressBookBtn");
			Find.Object("yapShippingAddressBookBtn").click();
			Thread.sleep(6000);
			if (ValidateYourAcc.setAlertPopup())
				Alert.Confirm();
			ValidateYourAcc.ValidateShippingAddressBook(address);
		}


	}

	public static void BillingAddressContains(String address) throws Exception {
		if (newToggle) {
			Find.Object("yapAccountBtn").click();
			Thread.sleep(4000);
			StepLogger.validate(Check.ObjectPresent, "yapBillingAddressBookBtn");
			Find.Object("yapBillingAddressBookBtn").click();
			Thread.sleep(6000);
			if (ValidateYourAcc.setAlertPopup())
				Alert.Confirm();
			ValidateYourAcc.ValidateBillingAddressBook(address);
		}
	}

	public static void hasNewBillingAddress(String firstName, String lastName,
											String streetaddress, String streetaddress2,
											String city, String country,
											String province, String postalCard,
											String phonenumber1, String phonenumber2,
											String phonenumber3, String phoneextension) throws Exception {

		if (Find.Object("shippingAddressPageTitle_AAF").getText().value().toLowerCase().contains("billing")) {
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
			if (Find.Object("rsBillingAddressApplyBtn").isPresent()) {
				Report.pass("Save button found and clicked",
						BrowserAction.screenshot());
				Find.Object("rsBillingAddressApplyBtn").click();
				if (Find.Object("confirmAddress_RL").isPresent()) {
					Find.Object("confirmAddress_RL").click();
				}

			}
		}

	}
}
    

