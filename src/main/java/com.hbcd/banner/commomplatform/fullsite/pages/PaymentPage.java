package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.PaymentPageBase;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by 461967 on 6/6/2016.
 */
public class PaymentPage extends PaymentPageBase {
    @Override
    public void ClickCheckout() throws Exception {
        Thread.sleep(4000);
        if (Find.Object("pyCheckout").isPresent()) {
            StepLogger.validate(Check.ObjectPresent, "pyCheckout");
            Find.Object("pyCheckout").click();
        } else if (Find.Object("rsPayPalContinueBtn").isPresent()) {
            StepLogger.validate(Check.ObjectPresent, "rsPayPalContinueBtn");
            Find.Object("rsPayPalContinueBtn").click();
        }
        Thread.sleep(4000);
    }

    @Override
    /** ONLY for UNREGISTERED user */
    public void AddNewCreditCard(int cardType) throws Exception {
        Thread.sleep(4000);
        StepLogger.validate(Check.ObjectPresent, "pyPaymentType");
        Find.Object("pyPaymentType").select(cardType);

        if (cardType != 1) {
            Find.Object("pyMonth").select("12");
            Find.Object("pyYear").select("2020");
            Find.Object("pySecurityCode").input("212");

            if (cardType == 3)// master
            {
                Storage.save("ccNumber", "5431111111111111");
                Find.Object("pyCreditCardNumber").input("5431111111111111");
            } else if (cardType == 4)// visa
            {
                Storage.save("ccNumber", "4445222299990007");
                Find.Object("pyCreditCardNumber").input("4445222299990007");
            } else if (cardType == 1) {
                Storage.save("ccNumber", "7528294270");
                Find.Object("pyCreditCardNumber").input("7528294270");
            }

        } else {

            Storage.save("ccNumber", "8091179005");
            Find.Object("pyCreditCardNumber").input("8091179005");
        }
        if (cardType != 10)
            Find.Object("pyNameOnCard").input("James Christopher");

    }

    @Override
    public void enterNewEmail(String email) throws Exception {
        Find.Object("papEmailOverlayEmailTxt_wk").input(email);
        Find.Object("papEmailOverlayConfEmailTxt_wk").input(email);
        Find.Object("papEmailOverlayApplyBtn_wk").click();
    }

    @Override
    public void EnterPassword(String password, String confPassword)
            throws Exception {
        Find.Object("papPasswordTxt_wk").clear();
        Find.Object("papPasswordTxt_wk").input(password);
        Find.Object("papConfirmPasswordTxt_wk").clear();
        StepLogger.validate(Check.ObjectPresent, "papConfirmPasswordTxt_wk");
        Find.Object("papConfirmPasswordTxt_wk").input(confPassword);

    }

    @Override
    public void EnterPassword() throws Exception {
        Find.Object("papPasswordTxt_wk").input("test123");
        Find.Object("papConfirmPasswordTxt_wk").input("test123");
    }


    @Override
    public void UpdateQuantity(String skuid, String qty) throws Exception {
        Find.ObjectWith("minibag-item", "data-cartproductcode", skuid,
                "a[class='action-link jsEditItem']").click();
        if (Find.Object("paQuantity_WS").isPresent()) {
            StepLogger.validate(Check.ObjectPresent, "paQuantity_WS");
            Find.Object("paQuantity_WS").clear();
            Find.Object("paQuantity_WS").input(qty);
            StepLogger.validate(Check.ObjectPresent, "paUpdateQuantity_WS");
            Find.Object("paUpdateQuantity_WS").click();
        } else if ((Find.Object("paQty_WS").isPresent())) {
            StepLogger.validate(Check.ObjectPresent, "paQty_WS");
            Find.Object("paQty_WS").clear();
            Find.Object("paQty_WS").input(qty);
            StepLogger.validate(Check.ObjectPresent, "paUpdateQty_WS");
            Find.Object("paUpdateQty_WS").click();
        }
    }

    @Override
    public void ContinueWithPaypal() throws Exception {
        Find.Object("pyPaymentType").select(10);
        StepLogger.validate(Check.ObjectPresent, "rsPayPalContinueBtn");
        Find.Object("rsPayPalContinueBtn").click();


    }

    @Override
    public void ContinueCheckoutPaymentPage() throws Exception {
        Thread.sleep(4000);
        if (Find.Object("ofm_papContinueCheckout_WS").isPresent()) {
            Thread.sleep(1000);
            Report.pass("Click Continue is Displayed", BrowserAction.screenshot());
            Find.Object("ofm_papContinueCheckout_WS").click();

            if (Find.Object("ofm_papCVV_WS").isPresent()) {
                if (Find.Object("ofm_papCVV_WS").getText().value().contains("Please supply the security code")) {
                    Find.Object("pySecurityCode").input("357");
                    Find.Object("ofm_papContinueCheckout_WS").click();
                }
            }
        }
    }

    @Override
    public void EnterPaymentDetails(String cardType, String cardNumber, String cardHolderName) throws Exception {

    }

    @Override
    public void AddGiftcard(String GCNumber, String pin) throws Exception {
        Assert.Report("Gift Card Number Field").isExist("pyGiftCardNumTxt").stopIfFalse();
        Assert.Report("Gift Card Pin Field").isExist("pyGiftCardPinTxt").stopIfFalse();
        Report.pass("User Enters Card Number And Pin Number");
        Find.Object("pyGiftCardNumTxt").input(GCNumber);
        Find.Object("pyGiftCardPinTxt").input(pin);
        Find.Object("rsGiftBtn").click();
    }

    @Override
    public void ApplyCreditCard(String CardType, String CardHolder_Name, String Card_Number,
                                String CVV, String Expiration_month, String Expiration_Year)
            throws Exception {
        Assert.Report("Payment Type Field").isExist("pyPaymentType").stopIfFalse();
        Assert.Report("Name on Card Field").isExist("pyNameOnCard").stopIfFalse();
        Assert.Report("Card Number Field").isExist("pyCreditCardNumber").stopIfFalse();
        Assert.Report("Expired Month Field").isExist("pyMonth").stopIfFalse();
        Assert.Report("Expired Field").isExist("pyYear").stopIfFalse();
        Assert.Report("CCV Field").isExist("pySecurityCode").stopIfFalse();
        Find.Object("pyPaymentType").selectByValue(CardType);
        Find.Object("pyNameOnCard").input(CardHolder_Name);
        Find.Object("pyCreditCardNumber").input(Card_Number);
        Find.Object("pyMonth").select(Expiration_month);
        Find.Object("pyYear").select(Expiration_Year);
        Find.Object("pySecurityCode").input(CVV);
//        Storage.save("ccNumber", "5444009999222205");
//        Storage.save("ccNumber", "4445222299990007");
    }

    @Override
    public void ApplyHouseCard(String CardType, String CardHolder_Name, String Card_Number) throws Exception {
        Assert.Report("Payment Type Field").isExist("pyPaymentType").stopIfFalse();
        Assert.Report("Name on Card Field").isExist("pyNameOnCard").stopIfFalse();
        Assert.Report("Card Number Field").isExist("pyCreditCardNumber").stopIfFalse();
        Find.Object("pyPaymentType").selectByValue(CardType);
        Find.Object("pyNameOnCard").input(CardHolder_Name);
        Find.Object("pyCreditCardNumber").input(Card_Number);
    }
}

