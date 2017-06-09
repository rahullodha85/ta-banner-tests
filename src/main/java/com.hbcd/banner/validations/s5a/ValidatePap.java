package com.hbcd.banner.validations.s5a;

import com.hbcd.reporting.objects.Step;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import java.util.ArrayList;
import java.util.List;

public class ValidatePap {
    private static boolean newToggle = false;

    public static void setToggleStatus(boolean status) {
        newToggle = status;
    }

    public static void hasPasswordMismatchError() {
        if (newToggle)
            StepLogger.validate(Check.TextPresent, "papValidateDoesNotMatchTxt_wk", "Password does not match");
    }

    public static void hasInvalidPwdDisplayed() {
        if (newToggle)
            StepLogger.validate(Check.TextPresent, "papValidatePasswordLengthTxt_wk", "Password must be at least six characters");
    }

    public static void hasTopEmailError() {
        if (newToggle) StepLogger.validate(Check.TextPresent, "papEmailOverlayValidateConfErrorTxt_wk");
    }

    public static void hasEmailAddress(String email) {

        StepLogger.validate(Check.TextPresent, "papEmailEntered_WS", email);
    }

    public static void hasGiftCardApplied(String cardNumber) throws Exception {
        String giftCardV = Find.Object("papGiftCardApplied_WS").getText().value();
        giftCardV = giftCardV.replaceAll("xx", "");
        Report.pass("Giftcard Data after xx: " + giftCardV, BrowserAction.screenshot());
        if (Find.Object("papGiftCardApplied_WS").getText().value().contains(cardNumber.substring(cardNumber.length() - 4)))
            Report.pass("Last four digits of the card are displayed successfully", BrowserAction.screenshot());
        else
            Report.fail("Last four digits of the card are NOT displayed", BrowserAction.screenshot());

    }

    public static void hasNoGiftCardApplied() throws Exception {

        if (!Find.Object("papGiftCardApplied_WS").isPresent())
            Report.pass("No Gift Card applied as expected");
        else
            Report.fail("Gift Card is applied");

    }

    public static void isPromoCodeApplied(String promo) throws Exception {

        if (Find.Object("papPromoCodeApplied_WS").getText().value().toLowerCase().contains(promo.toLowerCase()))
            Report.pass(promo + " is applied successfully");
        else
            Report.fail(promo + " is NOT applied");
    }

    public static void isPromoCodeNotApplied(String promo) throws Exception {

        if (Find.Object("papPromoCodeApplied_WS").isPresent()) {
            Report.pass("Promo codes are applied successfully");
            if (Find.Object("papPromoCodeApplied_WS").getText().value().toLowerCase().contains(promo.toLowerCase()))
                Report.pass(promo + " is applied successfully");
            else
                Report.fail(promo + " is NOT applied");
        } else
            Report.fail("Promo codes are NOT applied");

    }

    /** not case sensitive */
    public static void hasTextInResults(String s) throws Exception {
        List<String> textResults = Find.MultipleObjects("ofm_papProductTxt_wk").getText();
        s = s.toLowerCase();
        for (String product : textResults)
            if (product.toLowerCase().contains(s)) {
                Report.pass("Text " + s + " found in ProductText");
                return;
            }
        Report.fail("Text " + s + " not found in Product Text");
    }

    public static void hasPaymentMethod(String paymentMethod) throws Exception {
        if( Find.Object("pyPaymentType").getText().value().toLowerCase().contains(paymentMethod.toLowerCase()))
            Report.pass(paymentMethod+" is displayed successfully in the Payment Method dropdown");
        else
            Report.fail(paymentMethod+ " is NOT displayed in the Payment Method dropdown");
    }


    public static void hasNoPaymentMethod(String paymentMethod) throws Exception {
        if( !Find.Object("pyPaymentType").getText().value().toLowerCase().contains(paymentMethod.toLowerCase()))
            Report.pass(paymentMethod+" is NOT displayed successfully in the Payment Method dropdown");
        else
            Report.fail(paymentMethod+ " is displayed in the Payment Method dropdown");
    }

}