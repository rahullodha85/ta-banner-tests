package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.commonbanner.base.pages.PaymentPageBase;
import com.hbcd.scripting.core.Assert;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mPaymentPage  extends PaymentPageBase {

	
	@Override
	public void AddNewCreditCard(int cardType) throws Exception {
		
		StepLogger.validate(Check.ObjectPresent, "papCCType_WS");
		
		Find.Object("papCCType_WS").select(cardType);
		
		
		if (cardType != 0) {
			Find.Object("papCCMonth_WS").select(11);
			Find.Object("papCCYear_WS").select("2020");
			Find.Object("papCCCVV_WS").input("212");

			if (cardType == 3)// master
				Find.Object("papCCNumber_WS").input("5444009999222205");
			else if (cardType == 4)// visa
				Find.Object("papCCNumber_WS").input("4445222299990007");
			else if (cardType == 1)
				Find.Object("papCCNumber_WS").input("7528294270");
		} else {
			Find.Object("papCCNumber_WS").input("8091179005");
		}
		if (cardType != 10)
			Find.Object("papCCName_WS").input("James Christopher");
		
		if(Find.Object("paymentNextBtn_RL").isPresent()) {
			Find.Object("paymentNextBtn_RL").click();
		}
		Find.Object("papSkipButton_WS").click();
	}
private static void CreateAccount(String password, String confPassword) throws Exception{
	
	StepLogger.validate(Check.ObjectPresent, "papCreateAccPwd_WS");
	Find.Object("papCreateAccPwd_WS").input(password);
	Find.Object("papCreateAccPwd2_WS").input(confPassword);
	Find.Object("papCreateAccPwdHint_WS").input("CommonPassword");
	
	StepLogger.validate(Check.ObjectPresent, "papCreateAccNextBtn_WS");
	Find.Object("papCreateAccNextBtn_WS").click();
	
	if(Find.Object("saksBagAdditionalItemError_WS").isPresent() && Find.Object("saksBagAdditionalItemError_WS").getText().value().toLowerCase().contains("already exists in our system")){
		
							Report.dataFail("Email Address already exists in the system", BrowserAction.screenshot());
		
	}

}

@Override
public void AddNewCreditCard(int cardType,String password,String confPassword) throws Exception {
	
	StepLogger.validate(Check.ObjectPresent, "papCCType_WS");
	
	Find.Object("papCCType_WS").select(cardType);
	
	
	if (cardType != 0) {
		Find.Object("papCCMonth_WS").select(11);
		Find.Object("papCCYear_WS").select("2020");
		Find.Object("papCCCVV_WS").input("212");

		if (cardType == 3)// master
			Find.Object("papCCNumber_WS").input("5444009999222205");
		else if (cardType == 4)// visa
			Find.Object("papCCNumber_WS").input("4445222299990007");
		else if (cardType == 1)
			Find.Object("papCCNumber_WS").input("7528294270");
	} else {
		Find.Object("papCCNumber_WS").input("8091179005");
	}
	if (cardType != 10)
		Find.Object("papCCName_WS").input("James Christopher");

		StepLogger.validate(Check.ObjectPresent, "shpNextBtn_WS");
	Find.Object("shpNextBtn_WS").javascriptClick();

	CreateAccount(password, confPassword);
}

	@Override
	public void EnterGuestPaymentInformation() throws Exception {

	}

	@Override
	public void EnterMobileGiftCardNumber(String cardNumber, String pinNumber) throws Exception {
		if (Find.Object("addGiftcardButton_AAF").isPresent()){
			Report.pass("User Clicks to Input Card", BrowserAction.screenshot());
		}else{
			Report.dataFail("Gift Card is NOT working", BrowserAction.screenshot());
		}
		Thread.sleep(2000);
		StepLogger.validate(Check.ObjectPresent, "mobileGiftCardNumber_AAF");
		Find.Object("mobileGiftCardNumber_AAF").clear();
		Find.Object("mobileGiftCardNumber_AAF").input(cardNumber);
		Thread.sleep(2000);
		StepLogger.validate(Check.ObjectPresent, "mobileGiftCardPinNumber_AAF");
		Find.Object("mobileGiftCardPinNumber_AAF").clear();
		Find.Object("mobileGiftCardPinNumber_AAF").input(pinNumber);
		Thread.sleep(2000);
	}

	@Override
	public void EnterPromotionalCode(String promoCode) throws Exception {

		if (Find.Object("promocodeInputField_AAF").isPresent()){
			Report.pass("Promo Code is Displayed And User Inputs Promo Code", BrowserAction.screenshot());
		}else{
			Report.fail("Promo Code Field is NOT Displayed", BrowserAction.screenshot());
		}
		Find.Object("promocodeInputField_AAF").clear();
		Find.Object("promocodeInputField_AAF").input(promoCode);
	}

	@Override
	public void EnterCreditCardDetails(int cardType) throws Exception {

		StepLogger.validate(Check.ObjectPresent, "papCCType_WS");

		Find.Object("papCCType_WS").select(cardType);


		if (cardType != 0) {
			Find.Object("papCCMonth_WS").select(11);
			Find.Object("papCCYear_WS").select("2020");
			Find.Object("papCCCVV_WS").input("212");

			if (cardType == 3)// master
				Find.Object("papCCNumber_WS").input("5444009999222205");
			else if (cardType == 4)// visa
				Find.Object("papCCNumber_WS").input("4445222299990007");
			else if (cardType == 1)
				Find.Object("papCCNumber_WS").input("7528294270");
		} else {
			Find.Object("papCCNumber_WS").input("8091179005");
		}
		if (cardType != 10)
			Find.Object("papCCName_WS").input("James Christopher");

	}

	public void ApplyGiftCard(String cardNumber, String cardPin)throws Exception{

		StepLogger.validate(Check.ObjectPresent,"addGiftcardButton_AAF");
		Find.Object("addGiftcardButton_AAF").click();
		StepLogger.validate(Check.ObjectPresent, "rsEnterGiftCard");
		Find.Object("rsEnterGiftCard").input(cardNumber);
		Find.Object("rsEnterGiftCardPin").input(cardPin);
		if(Find.Object("clickContinue_AAF").isPresent()){
			Find.Object("clickContinue_AAF").click();
		}
		Thread.sleep(2000);
//		if(Find.Object("gifycardMessage_AAF").isPresent()){
//			Assert.IsPresent("Gift Card Has No/Less Available Balance","gifycardMessage_AAF");
//		}
		Assert.Report("Gift Card Has No/Less Available Balance").isExist("gifycardMessage_AAF");

		if(Find.Object("inputPassWord_AAF").isPresent()){
			Find.Object("inputPassWord_AAF").input("test1234");
			Find.Object("inputConfirpassword_AAF").input("test1234");
			Find.Object("passWordHint_AAF").input("PasswordTest");
			Thread.sleep(2000);
			Find.Object("clickContinueOnSaks_AAF").click();
		}
		//Find.Object("rsAddGiftCard").click();

	}

	public void	RemoveGiftCard() throws Exception {

		StepLogger.validate(Check.ObjectPresent, "papRemoveGift_WS");
		Find.Object("papRemoveGift_WS").click();
	}

	public void ApplyPromo(String promoCode) throws Exception{

		StepLogger.validate(Check.ObjectPresent,"promotionCode_AAF");
		Find.Object("promotionCode_AAF").click();

		StepLogger.validate(Check.ObjectPresent, "papPromoCode_WS");
		Find.Object("papPromoCode_WS").input(promoCode);
		Find.Object("promotionCode_AAF").click();

	}

	public void RemoveFirstAppliedPromo() throws Exception{

		StepLogger.validate(Check.ObjectPresent,"papFirstPromoRemoveBtn_WS");
		Find.Object("papFirstPromoRemoveBtn_WS").click();
	}
}
