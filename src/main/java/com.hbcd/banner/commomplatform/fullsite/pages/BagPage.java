package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.BagPageBase;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/6/2016.
 */
public class BagPage extends BagPageBase {
    @Override
    public void ApplyPromo(String promo) throws Exception {
        Find.Object("bagPromoTxt").input(promo);
        StepLogger.validate(Check.ObjectPresent, "bagApplyPromoBtn");
        Find.Object("bagApplyPromoBtn").click();
        if(Find.Object("bagPromoMesgOverLay_WS").isPresent())
            Report.dataFail("The promotional code that you have entered is not valid because it does not fall within the promotion's eligible date range", BrowserAction.screenshot());

        StepLogger.validate(Check.TextPresent, "bagPromoBox");
    }

    @Override
    public void ApplyPromoExpectFail(String promo) throws Exception {
        Find.Object("bagPromoTxt").input(promo);
        StepLogger.validate(Check.ObjectPresent, "bagApplyPromoBtn");
        Find.Object("bagApplyPromoBtn").click();
        if(Find.Object("bagPromoMesgOverLay_WS").isPresent())
            Report.pass("Error Message Displayed");

        String promoBoxTxt = Find.Object("bagPromoBox").getText().toString();
        if(promoBoxTxt.contains(promo)){
            Report.fail("Promo is displayed in promo box");
        }else Report.pass("Promo is not displayed in promo box");
    }

    @Override
    public LoginOverlay ClickCheckout() throws Exception {
            if (Find.Object("bagCheckoutBtn").isPresent()){
                Report.pass("LoginOverlay is Appeared");
            }else{
                Report.fail("LoginOverLay is NOT Appeared");
            }
            Find.Object("bagCheckoutBtn").click();
        return new com.hbcd.banner.commomplatform.fullsite.overlays.LoginOverlay();
    }

    public LoginOverlay LoginOverlay() throws Exception {
        return new com.hbcd.banner.commomplatform.fullsite.overlays.LoginOverlay();
    }

    @Override
    public QuickLookOverLay ClickEditFor(String upc) throws Exception {
        New.Object("bagEditBtn")
                .setProperty(Type.PropertyType.CSS_SELECTOR, "div[class='jsItemRoot widebag-item ']")
                .setProperty(Type.PropertyType.ATTRIBUTE_KEY1, "data-cartproductcode")
                .setProperty(Type.PropertyType.ATTRIBUTE_VALUE1, upc)
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.CSS_SELECTOR, "span[class='font-icon font-icon-pencil']")
                .setChildProperty(Type.PropertyIntType.iTH, 1)
                .click();
        if(Find.Object("bagQuickLookOverLay").isPresent()) {
            Report.pass("Bag Quicklook Overlay opened after clicking edit-item");
        } else {
            Report.fail("Bag Quicklook Overlay did not open after edit-item was clicked");
        }
        return new com.hbcd.banner.commomplatform.fullsite.overlays.QuickLookOverLay();
    }

    @Override
    public void Remove(String upc) throws Exception {
        if(Find.Object("bagItemRoot")
                .changeAttributeExactValue("data-cartproductcode",upc).isPresent()) {
            Use.CapturedObject("bagItems").FindObject("bagItemRoot")
                    .changeAttributeExactValue("data-cartproductcode",upc).storeAs("item");
            Use.CapturedObject("item").FindObject("bagRemoveBtn_RL").click();
            Find.Object("bagRemoveConfirm").click();
            Report.pass("Item with upc code: " + upc + " is removed from bag");
        } else {
            Report.fail("Item with upc code: " + upc + " is not in bag");
        }
    }

    @Override
    public void UpdateQuantity(String itemId,String quantity) throws Exception {

        if(Find.MultipleObjects("bag_itemBoxList_zk").size() > 0) {
            Report.pass("Update Quantity Field Displayed");
            Find.MultipleObjects("bag_itemBoxList_zk").selectItemContainText(itemId).storeAs("local_itemBox");
            Use.CapturedObject("local_itemBox").FindObject("bagEditQantitySelectionTxt_wk").clear();
            Use.CapturedObject("local_itemBox").FindObject("bagEditQantitySelectionTxt_wk").input(quantity);
        }else {
            Report.fail("Update Quantity Field Not Displayed");
        }
    }
    
    @Override
    public GiftOverlay MakeGift(String itemId) throws Exception {
        if(Find.Object("bagItemRoot")
                .changeAttributeExactValue("data-cartproductcode",itemId).isPresent()) {
            Use.CapturedObject("bagItems").FindObject("bagItemRoot")
                    .changeAttributeExactValue("data-cartproductcode",itemId).storeAs("item");
            Use.CapturedObject("item").FindObject("bagMakeGift_RL").click();
            Report.pass("\"Make this a Gift\" was clicked for item: " + itemId);
        } else {
            Report.fail("Item with upc code: " + itemId + " is not in bag");
        }
        return new com.hbcd.banner.commomplatform.fullsite.overlays.GiftOverlay();
    }
    @Override
    public void selectShippingMethod(String shipmethod) throws Exception {
        Find.Object("bagShipMethodZipCode").input("10017");
        switch(shipmethod){
            case "Rush": Find.Object("bagShipMethodDrpDwn").select(2); break;
            case "Next Bus. Day": Find.Object("bagShipMethodDrpDwn").select(3); break;
            case "Saturday": Find.Object("bagShipMethodDrpDwn").select(4); break;
            default: Find.Object("bagShipMethodDrpDwn").select(1); //standard
        }
        Thread.sleep(10000);
        StepLogger.validate(Check.TextPresent, "bagShipMethodDrpDwn", shipmethod);
    }

    @Override
    public void EnterZipCode(String zipCode) throws Exception {
        Find.Object("bagZipCodeTxt").input(zipCode);
        StepLogger.validate(Check.TextPresent, "bagZipCodeTxt", zipCode);
    }
    @Override
    public void ClickCheckoutInternational() throws Exception {
        Thread.sleep(5000);
        Find.Object("bagInternationalCheckoutBtn_zk").click();
    }

    @Override
    public void ClickSaveForLater(String upc) throws Exception {
        Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc, "span[class='font-icon font-icon-heart']").click();
        StepLogger.validate(Check.TextPresent, "bagCheckSaveForLater_wk", upc);
    }

    @Override
    public void saveItem(String skuid) throws Exception {
        New.Object("")
                .setProperty(Type.PropertyType.CLASS, "cart-row")
                .setProperty(Type.PropertyType.CONTAINS_TEXT, skuid)
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.TAG_NAME, "a")
                .setChildProperty(Type.PropertyType.CLASS, "add-to-cart")
                .click();
        StepLogger.validate(Check.TextPresent, "bagCheckSaveForLater", skuid);
    }

    public void MoveToBag(String upc) throws Exception{
        StepLogger.validate(Check.ObjectPresent,"bagSaveLaterSection_WS");
        Find.Object("bagSavedItems_WS").changeContainsText(upc).click();
    }

    @Override
    public void ClickBagShopRunnerSignIn() throws Exception {
        Find.Object("bagClickShopRunnerSignIn_zk").click();
        Thread.sleep(4000);
    }

    @Override
    public void clickShoprunnerExpressCheckOut() throws Exception {
        Find.Object("bagExpressShopRunnerSigninButton_AAF").click();
    }

}
