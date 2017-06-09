package com.hbcd.banner.LordAndTaylor.fullsite.Validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aalfaruk on 8/24/2016.
 * This class is created for all the validations related to Validate Payment Pages for LT
 */
public class ValidatePaymentPage {

    public static boolean containsOnlyNumbers (String str) throws Exception{
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static void isCreditcardNumberValid(String ccNumber) throws Exception {

        List<String> cards = new ArrayList<String>();
        cards.add(ccNumber);

        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<lordAndTaylor>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<paypal>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

        Pattern pattern = Pattern.compile(regex);

        for (String card : cards) {
            card = card.replaceAll("-", "");
            Matcher matcher = pattern.matcher(card);
            System.out.println(matcher.matches());
            if (matcher.matches()) {
                Report.pass(matcher.group("mastercard" ));
                System.out.println(matcher.group("mastercard"));
            }else{
                Report.fail("Credit Card Number did not match");
            }
        }
    }

    public static void isFormsOfPaymentSelectedFromDropDown(String cardType, String cardNumber) throws Exception{

        if(Find.Object("ltCardTypeLt_AAF").isPresent() && Find.Object("ltCcNumber_AAF").isPresent()){
            Report.pass("User Selects: " + cardType + " as a Payment Type and Card Number is " +  cardNumber);
        }else{
            Report.fail("The Selected Payment Type is Invalid");
        }
    }

    public static void isShoprunnerTopBannerRemoved() throws Exception{
        if(!Find.Object("ltPmtSrTopBanner_AAF").getText().value().contains("ShopRunner 2 DAY FREE SHIPPING")){
            Report.pass("ShopRunner Top Banner is Removed from Payment Page");
        }else{
            Report.fail("Shoprunner Top Banner is Present");
        }
    }

    public static void isCCContainsValidNumbers(String ccNum) throws Exception{
        String ccNumber = Find.Object("ltCcNumber_AAF").getText().value();
        String pattern = "(^[0-9]*$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(ccNumber);
        if (m.find()){
            Report.pass("User Enters Valid Credit Card Number " + ccNum);
        }else{
            Report.dataFail("Worng CC Number");
        }
    }
}
