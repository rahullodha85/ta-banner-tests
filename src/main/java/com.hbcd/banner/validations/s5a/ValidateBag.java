package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.*;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateBag {
    private static boolean newToggle = false;

    public static void setToggleStatus(boolean status) {
        newToggle = status;
    }

    public static void isPromoApplied(String promoCode) throws Exception {
        if (Find.Object("bagPromoBox").getText().value().toLowerCase()
                .indexOf(promoCode.toLowerCase()) >= 0) {
            System.out.println("pass");
        } else
            System.out.println("fail");
    }

    public static void isQuickLookOverlay() throws Exception {
        if (Find.Object("bagQuickLookOverLay").isPresent()) {
            Report.pass("QuickLook Overlay displayed");
        } else {
            Report.fail("QuickLook Overlay NOT displayed");
        }
    }

    public static void ValidatePrice(String upc) throws Exception {

        String uPrice = New
                .Object("")
                .setProperty(PropertyType.CSS_SELECTOR,
                        "div[class='jsItemRoot widebag-item ']")
                .setProperty(PropertyType.ATTRIBUTE_KEY1,
                        "data-cartproductcode")
                .setProperty(PropertyType.ATTRIBUTE_VALUE1, upc)
                .setProperty(PropertyIntType.IS_PARENT, 1)
                .setChildProperty(PropertyType.CSS_SELECTOR,
                        "p[class='widebag-item-unit-price']").getText().value();

        float unitPrice = Float.parseFloat((uPrice.replace("$", "").replace(
                " ", "")));

        String qty = New
                .Object("")
                .setProperty(PropertyType.CSS_SELECTOR,
                        "div[class='jsItemRoot widebag-item ']")
                .setProperty(PropertyType.ATTRIBUTE_KEY1,
                        "data-cartproductcode")
                .setProperty(PropertyType.ATTRIBUTE_VALUE1, upc)
                .setProperty(PropertyIntType.IS_PARENT, 1)
                .setChildProperty(PropertyType.CSS_SELECTOR,
                        "input[class='jsItemQuantity widebag-item-quantity-field']")
                .getAttribute("value").value();

        int quantity = Integer.parseInt(qty.replace("\"", ""));
        String tPrice = New.Object("")
                .setProperty(PropertyType.CSS_SELECTOR,
                        "div[class='jsItemRoot widebag-item ']")
                .setProperty(PropertyType.ATTRIBUTE_KEY1,
                        "data-cartproductcode")
                .setProperty(PropertyType.ATTRIBUTE_VALUE1, upc)
                .setProperty(PropertyIntType.IS_PARENT, 1)
                .setChildProperty(PropertyType.CSS_SELECTOR,
                        "p[class='widebag-item-extended-price']").getText()
                .value();
        float totalPrice = Float.parseFloat(tPrice.replace("$", "").replace(
                " ", ""));

        if (unitPrice * quantity == totalPrice) {

            System.out.println("ValidatePrice Pass");
        } else {
            System.out.println("ValidatePrice Fail");
        }

    }

    public static void isShipFromStore() throws Exception {
        StepLogger.validate(Check.TextPresent, "bagShipStoreWarning", "from a store");


    }

    public static void bagShopRunnerEligibleSignDisplay() throws Exception {
        StepLogger.validate(Check.TextPresent, "bagShopRunnerEligible_zk");

    }

    public static void bagShopRunnerEligibleSignNotDisplay() throws Exception {
        StepLogger.validate(Check.ObjectNotPresent, "bagShopRunnerEligible_zk");

    }

    public static void bagExpressShopRunnerBtn() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "bagExpressShopRunnerBtn_zk");

    }

    public static void bagValidateShippingMethod(String text) throws Exception {
        StepLogger.validate(Check.TextPresent, "bagValidateShippingMethod_zk", text);

    }

    public static void bagShopRunnerSignOut() throws Exception {
        StepLogger.validate(Check.TextPresent, "bagShopRunnerSignOut_zk", "Sign Out");

    }

    public static void topBannerShopRunnerSigninlearnMore() throws Exception {

        if (Find.Object("topBannerShoprunnerSignin_AAF").isDisplayed()) {
            System.out.println("ShopRunner Icon is present for Top Banner");
        } else {
            System.out.println("ShopRunner Icon is not present for Top Banner");
        }
    }

    public static void shopRunnerTopBanner(String text) throws Exception {
        StepLogger.validate(Check.TextPresent, "shopRunnerTopBanner_zk", text);
    }

    public static void isBagPage() throws Exception {
        StepLogger.validate(Check.TextPresent, "bagPageName_vm", "SAKS BAG");
    }

    public static void isItemShippable() throws Exception {
        StepLogger.validate(Check.TextNotPresent, "confShipAddressAndItemsSection", "Not shippable");
    }

    public static void hasCurrency(String currency) throws Exception {
        StepLogger.validate(Check.TextPresent, "bagPojoGrandTotalTxt_wk", currency);
    }

    public static void hasItemInBagOverLay() throws Exception {
        Thread.sleep(5000);
        if (Find.Object("bOverlay").isDisplayed())
            Report.pass("Overlay page Appeared", BrowserAction.screenshot());
        if (Find.Object("itemInBagOverLay_AAF").isDisplayed())
            Report.pass("Item has been displayed in the Bag", BrowserAction.screenshot());
        else
            Report.pass("Validation Fails", BrowserAction.screenshot());
    }

    public static void validateCheckoutButtonAndViewMyLink() throws Exception {

        if (Find.Object("validateCheckoutLink_AAF").isDisplayed())
            Report.pass("UnRegisterCheckout Button is Present in Bag Overlay Page", BrowserAction.screenshot());
        else
            Report.fail("Validation Fails", BrowserAction.screenshot());
        if (Find.Object("pdpBagLink").isDisplayed())
            Report.pass("Validation Passed", BrowserAction.screenshot());
        else
            Report.fail("Validations Fails", BrowserAction.screenshot());
    }

    public static void hasBuyOneGetOnePromoDisplayed(String itemPromo) throws Exception {
        Thread.sleep(1000L);
        if (Find.Object("ofm_itemPromoBogoBag_AAF").isPresent()) {
            Report.pass("BUY ONE GET ONE Promo Message Present on BagPage");
        } else {
            Report.fail("Promo Message is NOT Present on BagPage");
        }
        if (Find.Object("ofm_itemPromoBogoBag_AAF").getText().value().contains(itemPromo)) {
            Report.pass("Bogo promo Message displayed: " + itemPromo, BrowserAction.screenshot());
        } else {
            Report.fail("Bogo promo is NOT displayed on Bag Page", BrowserAction.screenshot());
        }
    }

    public static void hasPromoMessageBuyTwoGetOneDisplayed(String promo) throws Exception {
        StepLogger.validate(Check.ObjectPresent, "ofm_itemBagBuyOneGetTwoFree_AAF");
        if (Find.Object("ofm_itemBagBuyOneGetTwoFree_AAF").getText().value().contains(promo))
            Report.pass("Promo Message " + promo + " is Displayed", BrowserAction.screenshot());
        else
            Report.fail("Promo Message with BUY 2 GET 1 FREE is NOT displayed");

    }

    public static void hasPromoCodeDisplayed() throws Exception {
        if (Find.Object("ofm_promoOnBagPage_AAF").isPresent()) {
            Report.pass("Promo Code is Applied", BrowserAction.screenshot());
        } else {
            Report.fail("Promo Code is NOT Applied", BrowserAction.screenshot());
        }
    }

    public static void hasSubTotalPriceChangedByPromo() throws Exception {
        if (Find.Object("ofm_subTotalPriceOff_AAF").isPresent()) {
            Report.pass("Percent Dollar Off Promo Displayed", BrowserAction.screenshot());
        } else {
            Report.fail("Percent Dollar Off Promo is NOT displayed", BrowserAction.screenshot());
        }
    }

    public static void hasItemPromoMessageDisplayedBagPage(String bogoText) throws Exception {
    }

    public static void isInternationalPriceOnBagPage() throws Exception {
//		Assert.IsPresent("International Price is Present and Displayed in BagPage", "intPriceBagPage_AAF");
        Assert.Report("International Price is Present and Displayed in BagPage").isExist("intPriceBagPage_AAF");
    }
    public static void hasNoMasterPassButton() throws Exception {
        if(!Find.Object("bagMasterPassBtn_WS").isPresent())
            Report.pass("MasterPass button is not displayed as expected");
        else
            Report.fail("MasterPass button is displayed");
    }
    public static void hasMasterPassButton() throws Exception {
        if(Find.Object("bagMasterPassBtn_WS").isPresent())
            Report.pass("MasterPass button is displayed as expected");
        else
            Report.fail("MasterPass button is NOT displayed");
    }

}
