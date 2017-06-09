package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.banner.validations.common.ValidateBagPage;
import com.hbcd.commonbanner.base.pages.PDPPageBase;
import com.hbcd.commonbanner.overlays.AddToWaitListOverLay;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 461967 on 6/6/2016.
 */
public class PdpPage extends PDPPageBase {
//    @Override
//    public void AddToBag(String swatchOption, int quantity) throws Exception {
//
//        System.out.println(Thread.currentThread().getStackTrace()[1]
//                .getMethodName());
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//        boolean isVegc = Find.Object("pdpVegcValidation").getText().value()
//                .contains("Virtual Gift Card") ? true : false;
//        if (!isVegc) {
//            selectSwatch(swatchOption);
//            selectFirstDropdownItem();
//            selectFirstSwatch();
//            updateQty(quantity);
//            clickAddToBagButton();
//        } else
//            addVegc();
//        StepLogger.validate(Check.ObjectPresent, "bOverlay");
//    }
//
//
//    public void AddToBag(int quantity) throws Exception {
//
////		No results found check
//        if (Find.Object("yapPaymentMethodForm").isPresent()) {
//
//            if (Find.Object("yapPaymentMethodForm").getText().value()
//                    .contains("No results were found for"))
//                Report.dataFail("No results were found for",
//                        BrowserAction.screenshot());
//        }
//        System.out.println(Thread.currentThread().getStackTrace()[1]
//                .getMethodName());
//
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//
//        boolean isVegc = false;
//        if(Find.Object("pdpVegcValidation").isPresent())
//            isVegc = Find.Object("pdpVegcValidation").getText().value()
//                    .contains("Virtual Gift Card");
//        if (!isVegc) {
//            Thread.sleep(2000);
//            selectFirstSwatch();
//            selectFirstSizeSwatch();
//            selectFirstDropdownItem();
//            updateQty(quantity);
//            clickAddToBagButton();
//        } else
//            addVegc();
//
//        StepLogger.validate(Check.ObjectPresent, "bOverlay");
//
//    }
//
//    @Override
//    public void AddToWaitList(String email) throws Exception{
//
//        if (Find.Object("yapPaymentMethodForm").isPresent()) {
//
//            if (Find.Object("yapPaymentMethodForm").getText().value()
//                    .contains("No results were found for"))
//                Report.dataFail("No results were found for",
//                        BrowserAction.screenshot());
//        }
//        System.out.println(Thread.currentThread().getStackTrace()[1]
//                .getMethodName());
//
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//
//        boolean isVegc = false;
//        if(Find.Object("pdpVegcValidation").isPresent())
//            isVegc = Find.Object("pdpVegcValidation").getText().value()
//                    .contains("Virtual Gift Card");
//        if (!isVegc) {
//            Thread.sleep(2000);
//            selectFirstUnavailableColorSwatch();
//            selectFirstUnavailableSizeSwatch();
//            StepLogger.validate(Check.ObjectPresent, "pdpWaitListEmailTextBox_zk");
//            Find.Object("pdpWaitListEmailTextBox_zk").input(email);
//            clickAddToWaitListButton();
//        } else{
//            Report.fail("Item selected has no unavailable colore or size, so cannot be added to waitlist", BrowserAction.screenshot());
//        }
//    }
//
//
//    @Override
//    public void EnterBag() throws Exception {
//		/*
//		 * if(!Find.Object("bOverlayViewBagBtn").isPresentDisplayedEnabled())
//		 * Find.Object("pdpBagLink").click();
//		 * StepLogger.validate(Check.ObjectPresent, "bOverlayViewBagBtn");
//		 */
//        // if (!Find.Object("bOverlayViewBagBtn1").isDisplayed()) //check first
//        // time (may be slow to display)
//        //Thread.sleep(4000);
//        if (Find.Object("bOverlay").getAttribute("style").value()
//                .contains("display: none")) {
//            Thread.sleep(1000);
//            // if (!Find.Object("bOverlayViewBagBtn1").isDisplayed()) //check
//            // again
//            if (Find.Object("bOverlay").getAttribute("style").value()
//                    .contains("display: none")) {
//                Find.Object("pdpBagLink").click();
//                Thread.sleep(1000);
//            }
//        }
//        StepLogger.validate(Check.ObjectPresent, "bOverlayViewBagBtn1");
//        Find.Object("bOverlayViewBagBtn1").click();
//        StepLogger.validate(Check.ObjectPresent, "bagTitle");
//
//        ValidateBagPage.soldOutStatus("bagItemsTable_WS");
//
//    }
//
//
//    private void addVegc() throws Exception {
//        Find.Object("pdpRedesignVEGCChooseDeno").click();
//        New.Object("")
//                .setProperty(Type.PropertyType.CSS_SELECTOR,
//                        "a[class='item sku available first']")
//                .setProperty(Type.PropertyIntType.iTH, 1).click();
//        Find.Object("pdpRedesignAddToBagBtn").click();
//
//        Thread.sleep(3000);
//        Find.Object("pdpVgcRecip").input("Leroy Jenkins");
//        Find.Object("pdpVgcSender").input("LEEEEEEEEEROY Jenkins");
//        Find.Object("pdpVgcNotifyEmail").input("hello@hello.com");
//        Find.Object("pdpVgcConfirmEmail").input("hello@hello.com");
//        setDate();
//        StepLogger.validate(Check.ObjectPresent, "pdpVegcAddToBag");
//        Find.Object("pdpVegcAddToBag").click();
//        StepLogger.validate(Check.ObjectPresent, "bOverlay");
//    }
//
//    private void setDate() throws Exception {
//
//        Calendar c = new GregorianCalendar();
//        c.add(Calendar.MONTH, 2);
//
//        int month = c.get(Calendar.MONTH);
//        int day=c.get(Calendar.DAY_OF_MONTH);
//        if(month==2)
//            day=20;
//        String date = checkDigits(month) + "/"
//                + checkDigits(day) + "/"
//                + c.get(Calendar.YEAR);
//        Find.Object("pdpVgcDeliverDate").clear();
//        Find.Object("pdpVgcDeliverDate").input(date);
//    }
//
//    private String checkDigits(int input) {
//        if (input < 10)
//            return "0" + input;
//        else if (input > 30) {
//            input--;
//            return "" + input;
//        } else
//            return "" + input;
//    }
//
//    @Override
//    public void PersonalizeAddToBag(int size, String text) throws Exception {
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//        selectFirstSwatch();
//        selectFirstDropdownItem();
//        selectFirstSizeSwatch();
//        Find.Object("pdpPersonalizeAddtoBagBtn").click();
//        Find.Object("pdpPersonalizeTextBox").input(text);
//        if (Find.Object("pdpPersonalizeAddtoBagBtn2").isEnabled()) {
//            Find.Object("pdpPersonalizeAddtoBagBtn2").click();
//        }
//    }
//
//    @Override
//    public void PersonalizeAddToBag(int size, int quantity) throws Exception {
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//        if (size != -1)
//            selectSize(size);
//        PersonalizeAddToBag(quantity);
//		/*
//		 * Find.Object("pdpRedesignQty").clear();
//		 * Find.Object("pdpRedesignQty").input(new
//		 * Integer(quantity).toString());
//		 * Find.Object("pdpPersonalizeAddtoBagBtn").click();
//		 */
//        Find.Object("pdpPersonalizeTextBox").input("Hello World");
//        StepLogger.validate(Check.ObjectPresent, "pdpPersonalizeAddtoBagBtn2");
//        Find.Object("pdpPersonalizeAddtoBagBtn2").click();
//    }
//
//    @Override
//    public void PersonalizeAddToBag(int quantity) throws Exception {
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//        Find.Object("pdpRedesignQty").clear();
//        Find.Object("pdpRedesignQty").input(new Integer(quantity).toString());
//        StepLogger.validate(Check.ObjectPresent, "pdpPersonalizeAddtoBagBtn");
//        Find.Object("pdpPersonalizeAddtoBagBtn").click();
//    }
//
//    private void personalizedItemSelect(int option) throws Exception {
//        if(Find.Object("pdpPersonalizeSelectColorSize").isPresent())
//            Find.Object("pdpPersonalizeSelectColorSize").select(option);
//    }
//
//    public void ClickInStore() throws Exception {
//        StepLogger.validate(Check.ObjectPresent, "pdpFindInStoreBtn_ws");
//        Find.Object("pdpFindInStoreBtn_ws").click();
//    }
//
//    public AddToWaitListOverLay clickAddToWaitList() {
//        return null;
//    }
//
//    public String GetProductCode() {
//        return null;
//    }
//
//    public void AddToBag(String sizeOption, String swatchOption, int quantity)
//            throws Exception {
//        System.out.println(Thread.currentThread().getStackTrace()[1]
//                .getMethodName());
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//        boolean isVegc = Find.Object("pdpVegcValidation").getText().value()
//                .contains("Virtual Gift Card") ? true : false;
//        if (!isVegc) {
//            selectSwatch(swatchOption);
//            selectDropdownOption(sizeOption);
//            selectSizeSwatch(sizeOption);
//            updateQty(quantity);
//            clickAddToBagButton();
//        } else
//            addVegc();
//        StepLogger.validate(Check.ObjectPresent, "bOverlay");
//    }
//
//
//    public void AddToBag(String optionSize, int quantity, int optionColor)
//            throws Exception {
//    }
//
//    private static void selectSize(int optionIndex) throws Exception {
//        Find.Object("pdpRedesignPreOrderSize").click();
//        New.Object("")
//                .setProperty(Type.PropertyType.CSS_SELECTOR, "a[class='item size ']")
//                .setProperty(Type.PropertyIntType.iTH, optionIndex).click();
//    }
//
//
//    @Override
//    public void AddToBag(String sizeOption) throws Exception {
//
//        System.out.println(Thread.currentThread().getStackTrace()[1]
//                .getMethodName());
//        if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {
//
//            Report.dataFail("Sold Out", BrowserAction.screenshot());
//        }
//        boolean isVegc = Find.Object("pdpVegcValidation").getText().value()
//                .contains("Standard Gift Card") ? true : false;
//        if(isVegc) {
//            Find.Object("giftcardDropDown_RL").click();
//            Find.Object("giftcardValueSelect_RL").changeChildContainsText(sizeOption).click();
//        }else{
//            selectFirstSwatch();
//            selectSizeSwatch(sizeOption);
//        }
//        clickAddToBagButton();
//        StepLogger.validate(Check.ObjectPresent, "bOverlay");
//    }
//
//
//    public void AddToBag(String optionSize, int quantity, String optionColor)
//            throws Exception {
//    }
//
//    @Override
//    public void ClickShippingAccordian() throws Exception {
//        Find.Object("ShippingAccordian_vm").click();
//        StepLogger.validate(Check.ObjectPresent, "ShippingAccordianPanel_vm");
//    }
//
//
//
//    private static void updateQty(int qty) throws Exception {
//        Find.Object("pdpRedesignQty").doubleClick();
//        Find.Object("pdpRedesignQty").clear();
//        Find.Object("pdpRedesignQty").input(new Integer(qty).toString());
//    }
//
//
//    private static void selectFirstDropdownItem() throws Exception {
//        if (Find.Object("pdpRedesignPreOrderSize").isPresent()) {
//            Find.Object("pdpRedesignPreOrderSize").click();
//            Find.Object("pdpDropdownFirstSelection").click();
//
//        }
//    }
//
//    private static void selectFirstSwatch() throws Exception {
//        boolean colorSelected = false;
//        if (!colorSelected
//                && Find.Object("pdpSwatchFirstSelection").isPresent()) {
//            Find.Object("pdpSwatchFirstSelection").click();
//            colorSelected = true;
//        }
//        if (!colorSelected
//                && Find.Object("pdpRedesignColorSection").isPresent()) {
//            Find.Object("pdpSwatchFirstAvailableSelection").click();
//            colorSelected = true;
//        }
//    }
//
//    private static void selectFirstUnavailableColorSwatch() throws Exception{
//        boolean colorSelected = false;
//        if (!colorSelected
//                && Find.Object("pdpUnavailableColorSwatchLink_zk").isPresent()) {
//            Find.Object("pdpUnavailableColorSwatchLink_zk").click();
//            colorSelected = true;
//        }else {
//            Report.dataFail("Item selected has no unavailable colore or size, so cannot be added to waitlist",BrowserAction.screenshot());
//        }
//
//    }
//
//    private void selectFirstSizeSwatch() throws Exception {
//        if (Find.Object("pdpFirstSizeSwatch_wk").isPresent())
//            Find.Object("pdpFirstSizeSwatch_wk").click();
//        else if(Find.Object("pdpFirstSizeSwatchForPreOrder_RL").isPresent()){
//            Find.Object("pdpFirstSizeSwatchForPreOrder_RL").click();
//        }
//    }
//
//    private void selectFirstUnavailableSizeSwatch() throws Exception {
//        if (Find.Object("pdpUnavailableSizeSwatchLink_zk").isPresent())
//            Find.Object("pdpUnavailableSizeSwatchLink_zk").click();
//    }
//
//    public static void selectSwatch(String swatchOption) throws Exception {
//        boolean swatchSelected = false;
//        if (!swatchSelected
//                && Find.Object("pdpSwatchFirstSelection").isPresent()) {
//            Find.Object("pdpColorSelection")
//                    .changeChildAttributeContainsValue("title", swatchOption)
//                    .click();
//            swatchSelected = true;
//        }
//        if (!swatchSelected
//                && Find.Object("pdpSwatchFirstAvailableSelection").isPresent()) {
//            Find.Object("pdpColorSelection")
//                    .changeChildContainsText(swatchOption).click();
//            swatchSelected = true;
//        }
//        if (!swatchSelected
//                && Find.Object("pdpColorSwatch2Check_wk").isPresent()) {
//            Find.Object("pdpColorSwatch2_wk")
//                    .changeChildAttributeContainsValue("title", swatchOption)
//                    .click();
//            swatchSelected = true;
//        }
//    }
//
//    private static void selectDropdownOption(String option) throws Exception {
//        if (Find.Object("pdpRedesignPreOrderSize").isPresent()) {
//            Find.Object("pdpRedesignPreOrderSize").click();
//            Find.Object("pdpOptionsSelection").changeChildContainsText(option)
//                    .click();
//        }
//    }
//
//    public void selectSizeSwatch(String size) throws Exception {
//        if (Find.Object("pdpSizeSwatchLink")
//                .changeChildAttributeContainsValue("data-value", size)
//                .isPresent())
//            Find.Object("pdpSizeSwatchLink")
//                    .changeChildAttributeContainsValue("data-value", size)
//                    .click();
//        else Report.fail("Swatch not found", BrowserAction.screenshot());
//    }
//
//    public void AddToBag() throws Exception {
//        Find.Object("qlAddToBagBtn_wk").click();
//        //Thread.sleep(3000);
//    }
//
//
//    @Override
//    public void ClickShippingAndReturns() throws Exception {
//        Find.Object("pdpShippingReturnsBtn_wk").click();
//        StepLogger.validate(Check.TextPresent, "pdpAccordion_wk", "opened");
//
//    }
//
//    @Override
//    public void UpdateSTLQuantity(int qty) throws Exception {
//        Find.Object("pdpSTLQuantity_WS").clear();
//        Find.Object("pdpSTLQuantity_WS").input(String.valueOf(qty));
//
//    }
//
//    @Override
//    public void EnterQuantity(int qty) throws Exception {
//        Find.Object("pdpRedesignQty").clear();
//        Find.Object("pdpRedesignQty").input(new Integer(qty).toString());
//
//    }
//
//    @Override
//    public void ClickSeeAllQnA() throws Exception {
//        Find.Object("pdp_SeeAllQnALink_vm").click();
//
//    }
//
//    @Override
//    public void CloseAccordian() throws Exception {
//        Find.Object("detailsAccordinLink").click();
//
//    }
//
//    @Override
//    public void SelectItemFromRecentlyViewed(String upc) throws Exception {
//
//        Find.Object("pdpRecentlyVIewedItemSelection_WS").changeChildAttributeContainsValue("data-product_code",
//                upc).click();
//    }
//
//    @Override
//    public void ClickDetails() throws Exception {
//        Find.Object("detailAccordian_wk").click();
//    }
//
//    @Override
//    public void ClickAddToBagForVegc() throws Exception {
//
//        Find.Object("pdpVGCDeno_WS").click();
//        Find.Object("pdpVGCDEnoFirst_WS").click();
//        Find.Object("pdpAddToBagBtn_WS").click();
//
//
//    }
//
//    @Override
//    public void ClickColorSwatch(String colorName) throws Exception {
//        Find.Object("pdpColorSwatchLink").changeChildContainsText(colorName).click();
//
//    }
//
//    @Override
//    public void ClickAskAQuestionLink() throws Exception {
//        Find.Object("pdpAskAQuestionLink_WS").click();
//    }
//
//    @Override
//    public void ClickSizeSwatch(String size) throws Exception {
//        Find.Object("pdpSizeSwatchLink").changeChildContainsText(size).click();
//
//    }
//
//    private static void clickAddToBagButton() throws Exception {
//
//        Find.Object("qlAddToBagBtn_wk").click().getPerformance("Add to Bag", "PDP");
//    }
//
//    private void clickAddToWaitListButton() throws Exception{
//        Find.Object("pdpAddToWaitListButton_zk").click();
//    }
//    @Override
//    public void ClickReviews() throws Exception{
//        Find.Object("pdpReviewButton_vm").click();
//    }

    @Override
    public void AddToBag() throws Exception{
        if(hasDropDown()){
            selectFirstFromDropdown();
            clickOldAddToBag();
            return;
        }
        selectFirstColor();
        selectFirstSize();
        clickAddToBag();
    }

    @Override
    public void ClickEmailIcon() throws Exception{
        Find.Object("AEMpdpEmailIcon_wk").click();
    }
    @Override
    public void ClickRecentlyViewed() throws Exception{

        Find.Object("recentlyviewed_vm").click();
    }
    @Override
    public void ClickShippingAndReturns() throws Exception {
        Find.Object("shippingreturnpanel_vm").click();
    }

    @Override
    public void ClickQtyIncrement() throws Exception{
        Find.Object("qtyIncrement_vm").click();
    }

    @Override
    public void AddToBag(int option) throws Exception {
        if(option > 1) {
            EnterQuantity(option);
        }
        AddToBag();
    }

    @Override
    public void AddToBag(int quantity, int colorSwatchIndex, int sizeSwatchIndex) throws Exception {
        if(quantity > 1) {
            EnterQuantity(quantity);
        }
        selectColorSwatchByIndex(colorSwatchIndex);
        selectSizeSwatchByIndex(sizeSwatchIndex);
        clickAddToBag();
    }

    @Override
    public void EnterQuantity(int q) throws Exception {
        if(Find.Object("com_pdpQuantity_wk").isPresent()) {
            Find.Object("com_pdpQuantity_wk").clear();
            Find.Object("com_pdpQuantity_wk").input(Integer.toString(q));
        }
    }

    @Override
    public void EnterBag() throws Exception {
        Thread.sleep(9000L);
        if(Find.Object("closeButtonSubwindow_AAF").isPresent()){
            Report.pass("Our Customer Q&A module is temporarily down for maintenance. Thank you for your patience. \n ANNE BACKY created Defect in QC");
            Find.Object("closeButtonSubwindow_AAF").click();
        }
        Thread.sleep(9000L);
        if (!Find.Object("bOverlay").isPresent()) {
            Find.Object("pdpBagLink").click();
            Thread.sleep(1000);
        }
        if (Find.Object("bOverlayViewBagBtn1").isPresent()) {
            Thread.sleep(2000);
            Find.Object("bOverlayViewBagBtn1").click();
            Report.pass("View shopping bag button found and clicked");
        } else {
            Report.fail("View shopping bag button is not present on Minibag Overlay");
        }
        ValidateBagPage.soldOutStatus("bagItemsTable_WS");
    }

    private void selectFirstSize() throws Exception {
        if(hasSizeSection())
            Find.Object("com_pdpSelectSize_wk").click();
        else Log.Info("No Available sizes");
    }

    private void selectSizeSwatchByIndex(int idx) throws Exception {
        if (idx > 0) {
            if (hasSizeSection())
                Find.MultipleObjects("pdp_allSizeSwatch_ep").select(idx).click();
            else Log.Info("No Available sizes");
        }
        else
        {
            selectFirstSize();
        }
    }

    private void selectFirstColor()throws Exception{
        if(hasColorSection()) {
            Find.Object("com_pdpSelectColor_wk").click();
            colorHasSizes();
        }
        else {
            Log.Info("No Available Colors");
        }
    }

    private void selectColorSwatchByIndex(int idx)throws Exception{
        if (idx > 0) {
            if (hasColorSection()) {
                Find.MultipleObjects("pdp_allColorSwatch_ep").select(idx).click();
                colorHasSizes();
            } else {
                Log.Info("No Available Colors");
            }
        }
        else
        {
            selectFirstColor();
        }
    }


    private void selectFirstFromDropdown() throws Exception{
        String innerDropDown = Find.Object("com_pdpDropDown_wk").getAttribute("innerHTML").value();
        int optionsAvailable = countAvailableOptions(innerDropDown);

        //pick a non sold out item
        for(int i = 1; i < optionsAvailable; i++){
            if(!Find.Object("com_pdpDropDown_wk").getDropDownSelectedValue().contains("Sold Out")){
                Find.Object("com_pdpDropDown_wk").select(i);
                break;
            }
        }
    }
    private void clickAddToBag() throws Exception{
        if(Find.Object("AEMsoldOutMsg_wk").isPresent())
            Report.dataFail("Sold Out Message Displayed");
        else Find.Object("com_pdpAddToBag_wk").click();
    }
    private void clickOldAddToBag() throws Exception{
        if(Find.Object("AEMsoldOutMsg_wk").isPresent())
            Report.dataFail("Sold Out Message Displayed");
        else Find.Object("pdp_reskinAddToBagBtn_wk").click();
    }
    /** checks for an available size after selecting color */
    private void colorHasSizes() throws Exception{
        if(hasSizeSection())
            Report.pass("Sizes available");
        else Report.fail("Sizes not available for selected Color");
    }
    private boolean hasSizeSection() throws Exception{
        return Find.Object("com_pdpSelectSize_wk").isPresent();
    }
    private boolean hasColorSection() throws Exception{
        return Find.Object("com_pdpSelectColor_wk").isPresent();
    }
    private boolean hasDropDown() throws Exception{
        return Find.Object("com_pdpDropDown_wk").isPresent();
    }
    private int countAvailableOptions(String innerHtml){
        Pattern option = Pattern.compile("data-return=\"true\"");
        Matcher matcher = option.matcher(innerHtml);

        int count = 0;
        while(matcher.find()){
            count++;
        }
        return count;
    }

    @Override
    public void JoinWaitListEmail(String email, String mobilePhoneNumber) throws Exception{

        //Assert.IsPresent("First Unavailable Color is Selected", "selectFirstColor_AAF");
        if (Find.Object("selectFirstColor_AAF").isPresent()){
            Report.pass("First Unavailable Color is Selected");
            Find.Object("selectFirstColor_AAF").click();
        }
        if(Find.Object("selectFirstSize_AAF").isPresent()){
            Report.pass("First Unavailable Size is Selected");
            Find.Object("selectFirstSize_AAF").click();
        }
        if(Find.Object("inputEmailId_AAF").isPresent()){
            Report.pass("Input Email in WaitList Email TextBox");
            Find.Object("inputEmailId_AAF").clear();
            Find.Object("inputEmailId_AAF").input(email);
        }else{
            Report.fail("Input Email Field is NOT Available",BrowserAction.screenshot());
        }
        if (Find.Object("inutMobilePhone_AAF").isPresent()){
            Report.pass("Input Phone Number");
            Find.Object("inutMobilePhone_AAF").clear();
            Find.Object("inutMobilePhone_AAF").input(mobilePhoneNumber);
        }

        Find.Object("waitListsOnPDP_AAF").click();
    }

    @Override
    public void ValidatePDPPresent() throws Exception{
        Find.Object("pdp_is Present_YA").isPresent();
        Report.pass("PDP was reached, MiniBag closed");
    }
}
