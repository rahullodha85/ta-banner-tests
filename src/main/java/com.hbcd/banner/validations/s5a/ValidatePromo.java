package com.hbcd.banner.validations.s5a;

import com.hbcd.commonbanner.dataobjects.OrderSummary;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class ValidatePromo{
    public static void hasGwp(String upc) throws Exception {
        if (Find.ObjectWith("jsItemRoot ", "data-cartproductcode", upc, "p[class='widebag-item-unit-price']").getText().value().contains("0.00"))
            System.out.println("pass");
        else System.out.println("fail");
    }
    public static void doesNotHaveGwp(String upc) throws Exception {
        if (Find.ObjectWith("jsItemRoot ", "data-cartproductcode", upc, "p[class='widebag-item-unit-price']").getText().value().contains("0.00"))
            System.out.println("pass");
        else System.out.println("fail");
    }

    public static void hasPercentOff(int expectedPercentOff, boolean include, OrderSummary beforePromo) throws Exception {
        OrderSummary afterPromo = new OrderSummary();
        double actualDiscount = Math.round((double) (beforePromo.getBeforeTaxTotal() - beforePromo.getShippingCost()) * (1 - ((double) expectedPercentOff / 100.00)));
        if (actualDiscount == Math.round((afterPromo.getBeforeTaxTotal() - afterPromo.getShippingCost())))
            Report.pass("BeforePromotion: [" + beforePromo.toString() + "], \r AfterPromotion[" + afterPromo.toString() + "]", BrowserAction.screenshot());
        else
            Report.fail("BeforePromotion: [" + beforePromo.toString() + "], AfterPromotion[" + afterPromo.toString() + "]", BrowserAction.screenshot());
    }

    public static void hasDollarOff(int expectedAmountOff, boolean include, OrderSummary beforePromo) throws Exception {
        OrderSummary afterPromo = new OrderSummary();
        double actualAmountOff = (double) Math.round(((afterPromo.getItemTotal())));
        if (actualAmountOff == expectedAmountOff)
            System.out.println("Discount Successfully Applied");
        else System.out.println("Discount NOT Applied");
    }

    public static void hasEgcWithAmount(int amountOff, OrderSummary beforePromo) throws Exception {
        OrderSummary afterPromo = new OrderSummary();
        if (beforePromo.getBeforeTaxTotal() == afterPromo.getBeforeTaxTotal()) {
            //need to validate whether the EGC is in Cart
        } else System.out.println("Discount NOT Applied");
    }
}
