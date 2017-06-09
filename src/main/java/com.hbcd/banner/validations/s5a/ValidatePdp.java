package com.hbcd.banner.validations.s5a;

import com.hbcd.commonbanner.dataobjects.NumericSize;
import com.hbcd.commonbanner.dataobjects.ShoeSize;
import com.hbcd.commonbanner.enums.CurrencyType;
import com.hbcd.commonbanner.enums.ShippingReturnCountry;
import com.hbcd.scripting.core.Assert;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.fluentInterface.ObjectAction;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ValidatePdp {
    static enum sizeLetter {
        XSML, SML, MED, LRG
    }

    public static void hasPromoMessage(String message) throws Exception {
        if (Find.Object("pdpPromoMessageTxt_wk").isPresent())
            Find.Object("pdpPromoMessageTxt_wk").getText().value().contains("message");
        StepLogger.validate(Check.TextPresent, "pdpPromoMessageTxt_wk", message);
        System.out.println("Promo message is on the page");
    }

    public static void isPersonalizedErrorMessageDisplayed() throws Exception {
        if (Find.Object("pdpErrorLbl").getText().value().toLowerCase()
                .indexOf("should be 1 or greater") >= 0) {
            System.out.println("pass");
        } else
            System.out.println("fail");

    }

    public static void PreOrderMessage() {

        StepLogger.validate(Check.ObjectPresent, "pdpPreorderLabel_WS");
        StepLogger.validate(Check.TextPresent, "pdpPreorderLabel_WS",
                "Pre-OrderPage");
    }

    public static void PreOrderShipDate() {

        StepLogger.validate(Check.ObjectPresent, "pdpPreorderShipDate_WS");
        StepLogger.validate(Check.TextPresent, "pdpPreorderShipDate_WS",
                "Expected ship date");
    }

    public static void HighDemandMesage() {

        StepLogger.validate(Check.ObjectPresent, "pdpHighDemandMessage_WS");
        StepLogger.validate(Check.TextPresent, "pdpHighDemandMessage_WS",
                "DUE TO HIGH DEMAND");
    }

    public static void HighDemandMessageNotPresent() {
        StepLogger.validate(Check.ObjectNotPresent, "pdpHighDemandMessage_WS");
    }

    public static void ColorSizeSwatchSection() {

        StepLogger
                .validate(Check.ObjectPresent, "pdpColorSizeSwatchSection_WS");
    }

    public static void NoColorSizeSwatchSection() {

        StepLogger.validate(Check.ObjectNotPresent,
                "pdpColorSizeSwatchSection_WS");
    }

    public static void BrandName(String brandName) throws Exception {

        StepLogger.validate(Check.TextPresent, "pdpBrandName_WS", brandName);

    }

    public static void NoPreOrderMessage() {

        StepLogger.validate(Check.ObjectNotPresent, "pdpPreorderLabel_WS");

    }

    public static void FindInStoreLink() {

        StepLogger.validate(Check.ObjectPresent, "pdpFindInStoreBtn_ws");
    }

    public static void NoFindInStoreLink() {

        StepLogger.validate(Check.ObjectNotPresent, "pdpFindInStoreBtn_ws");
    }

    public static void STLAccordionsClosedByDefault() throws Exception {

        if (!Find.Object("pdpSTLAccordians_WS").getAttribute("innerHTML")
                .value().contains("opened"))
            Report.pass("STL Accordian closed by default",
                    BrowserAction.screenshot());
        else
            Report.fail("STL Accordian NOT closed by default",
                    BrowserAction.screenshot());
    }

    /**
     * This link can only be seen when Accessed PDP of the selected item from
     * Product Array
     */

    public static void SeeAllQuestionsAnswers() {

        StepLogger.validate(Check.ObjectPresent, "pdp_SeeAllQnALink_WS");
    }

    public static void ShowAllAnswers() {

        StepLogger.validate(Check.ObjectPresent, "pdp_ShowAllAnswers_WS");

    }

    public static void hasSalePrice() {
        StepLogger.validate(Check.ObjectPresent, "pdpSalePriceTxt_wk");
    }

    public static void hasListedPrice() {
        StepLogger.validate(Check.ObjectPresent, "pdpListedPriceTxt_wk");
    }

    public static void hasCurrency(CurrencyType currencyType) {

        StepLogger.validate(Check.TextPresent, "pdpPriceContainer_vm",
                currencyType.toString());
    }

    public static void priceMatchesOverlay() throws Exception {
        StepLogger.validate(Check.TextPresent, "pdpOverlayContainer", Find
                .Object("pdpPriceContainer_wk").getText().value());
    }

    public static void priceDisplays() {
        StepLogger.validate(Check.ObjectPresent, "pdpPriceContainer_wk");
    }

    public static void hasSoldOutMsg() {
        StepLogger.validate(Check.ObjectPresent, "pdpSoldOutMsg_WS");
    }

    public static void hasRangedPrice() {
        StepLogger.validate(Check.TextPresent, "pdpPriceContainer_wk", "- $");
    }

    public static void hasExactPrice() {
        StepLogger
                .validate(Check.TextNotPresent, "pdpPriceContainer_wk", "- $");
    }

    public static void hasSizeGuideLink() {
        StepLogger.validate(Check.ObjectPresent, "pdpSizeGuideBtn_wk");
    }

    public static void hasCannotReturnMsg() {

        StepLogger.validate(Check.TextPresent, "pdpShippingReturnInfo_wk",
                "annot be returned");
    }

    public static void hasCannotShipMsg() {
        StepLogger.validate(Check.TextPresent, "pdpAccordion_wk",
                "annot be shipped");
    }

    public static void horizontalLinesNotPresent() {
        StepLogger.validate(Check.ObjectNotPresent, "pdpStlDivider_wk");
    }

    public static void hasSwatchSelectedClass() {
        StepLogger.validate(Check.ObjectPresent, "pdpSwatchSelected_wk");
    }

    public static void hasStlAddToBagButton() {
        StepLogger.validate(Check.ObjectPresent, "pdpStlAddToBag");
    }

    public static void hasBagOverlay() {
        StepLogger.validate(Check.ObjectPresent, "bOverlay");
    }

    public static void isAddToBagPresent() {
        StepLogger.validate(Check.TextPresent, "pdpRedesignAddToBagBtn",
                "ADD TO BAG");
    }

    public static void isQASectionPresent() {
        StepLogger.validate(Check.TextPresent, "AskQuestionButton_vm",
                "ASK A QUESTION");
    }

    public static void STLDefaultQuantity() throws Exception {

        StepLogger.validate(Check.ObjectPresent, "pdpSTLQuantity_WS");
        if (Find.Object("pdpSTLQuantity_WS").getAttribute("value").value()
                .equals("1")) {
            System.out.println("STL Default Quantity Validation Pass");
        }
    }

    public static void isQuantityMatch() {
        StepLogger.validate(Check.TextPresent, "overlayQuantity_vm", "1");
    }

    public static void isColorSelected() {
        StepLogger.validate(Check.ObjectPresent, "colorLink_vm");
    }

    public static void isPreorderSizeSelected() {
        StepLogger.validate(Check.ObjectPresent, "sizeLink_vm");
    }

    public static void hasBrandName(String brandName) {
        StepLogger.validate(Check.TextPresent, "brandName_vm", brandName);
    }

    public static void hasItemNumber(String itemNumber) throws Exception{
        if(Find.Object("o5m_pdpProductHeader_wk").getText().value().contains(itemNumber))
            Report.pass("Item number found");
        else Report.fail("Item number does not match search");
    }

    public static void isVEGCSection() {
        StepLogger.validate(Check.TextPresent, "giftCardSection_vm",
                "Virtual Gift Card");
    }

    public static void isFriendsAndFamilyEligible() {
        StepLogger.validate(Check.TextPresent, "friendsFamily_vm", "");
    }

    public static void TotalItemsInBag(String expItemCount) throws Exception {
        ObjectAction countObject = Find.Object("o5m_pdpBagIconCount_wk");
        if(countObject.isPresent()){
            Report.pass("Item Count object found");
            String count = countObject.getText().value();
            if(count.contains(expItemCount)){
                Report.pass("Item Count showing correct count");
            }else Report.fail("Item Count showing incorrect [expected: " + expItemCount + ", actual: " + count);
        }else Report.fail("Item Count object not found");
    }

    public static void NoAddToBagButton() {

        StepLogger.validate(Check.ObjectNotPresent, "pdpAddToBagBtn_WS");
    }

    public static void SPD(String shortProdDescription) throws Exception {

        StepLogger.validate(Check.TextPresent, "pdpSPD_WS",
                shortProdDescription);

    }

    public static void NoPriceDisplays() {
        StepLogger.validate(Check.ObjectNotPresent, "pdpPriceContainer_wk");
    }

    public static void FBlink() throws Exception {
        System.out.println("FB Link=" + Find.Object("pdpfb_WS").isPresent());
        StepLogger.validate(Check.ObjectPresent, "pdpfb_WS");
    }

    public static void PinItlink() throws Exception {
        System.out.println("PinIt Link="
                + Find.Object("pdpPinIt_WS").isPresent());
        StepLogger.validate(Check.ObjectPresent, "pdpPinIt_WS");
    }

    public static void TwitterLink() throws Exception {
        System.out.println("Twit Link="
                + Find.Object("pdpTwitter_WS").isPresent());
        StepLogger.validate(Check.ObjectPresent, "pdpTwitter_WS");
    }

    public static void GooglePlusLink() throws Exception {
        System.out.println("GPLus Link="
                + Find.Object("pdpGPlus_WS").isPresent());

        StepLogger.validate(Check.ObjectPresent, "pdpGPlus_WS");

    }

    public static void EmailLink() {
        StepLogger.validate(Check.ObjectPresent, "pdpEmail_WS");
    }

    public static void isSTLpageLoaded() {
        StepLogger.validate(Check.TextPresent, "stlheader_vm",
                "Complete the Look");
    }

    public static void STLAccordions() throws Exception {

        StepLogger.validate(Check.ObjectPresent, "pdpSTLAccordians_WS");
    }

    public static void STLColorDefaulted(String color) throws Exception {

        System.out.println(Find.Object("pdpSTLColor_WS").getText().value());
        StepLogger.validate(Check.TextPresent, "pdpSTLColor_WS", color);

    }

    public static void hasFitModelComment() {
        StepLogger.validate(Check.TextPresent, "FitModelDetails",
                "Model shown is");
        StepLogger.validate(Check.TextPresent, "FitModelDetails",
                "wearing US size");

    }

    public static void isShippingAccordionClosed() throws Exception {
        if (Find.Object("ShippingReturnAccordian").getAttribute("outerHTML")
                .value().indexOf("opened") == -1) {
            Report.pass("Shipping Accordian is Closed",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Shipping Accordian is Open",
                    BrowserAction.screenshot());
        }
    }

    public static void isDetailsAccordianClosed() {

    }

    public static void notShippingMessage() {

    }

    public static void isShippingRestrictionPopUpOpened() {

    }

    public static void BlueMartiniText() {

    }

    public static void hasMsgGiftWrapNotAvailable() {

    }

    public static void isShippingTimeLineDisplayed() {

    }

    public static void isShippingStatementPresent() {

    }

    public static void RecentlyViewedSectionHas(String searchString)
            throws Exception {
        if (Find.Object("pdpRecentlyVIewedSection_WS").getText().value().contains(searchString))
            Report.pass(searchString + " found in recently viewed section", BrowserAction.screenshot());
        else Report.fail(searchString + " not found in recently viewed section", BrowserAction.screenshot());
    }

    public static void RecentlyViewedSectionDoesNotHave(String searchString)
            throws Exception {
        String temp = Find.Object("pdpRecentlyVIewedSection_WS").getText().value();
        StepLogger.validate(Check.TextNotPresent,
                "pdpRecentlyVIewedSection_WS", searchString);

    }

    public static void RecentlyViewedSectionRating(String upc) throws Exception {
        if (Find.Object("pdpRecentlyViewedItemsRating_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .isPresent()) {
            Report.pass(
                    "Rating Information Present in Recently VIewed Section",
                    BrowserAction.screenshot());
        } else {
            Report.fail(
                    "Rating Information NOT Present in Recently VIewed Section",
                    BrowserAction.screenshot());
        }
    }

    public static void isLinkPath(String string) throws Exception {
    }

    public static void hasNoRecentlyViewedSection() {

        StepLogger.validate(Check.ObjectNotPresent,
                "pdpRecentlyVIewedSection_WS");

    }

    public static void hasRecentlyViewedSection() {

        StepLogger.validate(Check.ObjectPresent, "pdpRecentlyVIewedSection_vm");

    }

    public static void hasCorrectPrice() throws Exception {
        // pdpPriceOverlay
        if (Find.Object("pdpPriceOverlay_vm")
                .getText()
                .value()
                .equalsIgnoreCase(
                        Find.Object("pdpPriceContainer_vm").getText().value())) {
            Report.pass("Price Amount is Equal", BrowserAction.screenshot());
        } else
            Report.fail("Price Amount is Not Equal", BrowserAction.screenshot());

    }

    public static void FindInStoreOverlay() {

        StepLogger.validate(Check.ObjectPresent, "inStoreOLZip_ws");

    }

    public static void hasNoColorSwatch() throws Exception {

        if (colorSwatchStatus()) {
            //
            Report.pass("Color Name Present", BrowserAction.screenshot());
        } else
            Report.fail("Color Name Not Present", BrowserAction.screenshot());

    }

    public static void hasColorSwatch() throws Exception {
        if (!colorSwatchStatus()) {
            //
            Report.pass("Color Name Present", BrowserAction.screenshot());
        } else
            Report.fail("Color Name Not Present", BrowserAction.screenshot());

    }

    private static boolean colorSwatchStatus() throws Exception {
        return (Find.Object("pdpColorSwatchLabelName_vm").getText().value()
                .toLowerCase().indexOf("color") >= 0)
                && (Find.Object("pdpColorSwatchName_vm").getText().value()
                .length() > 0)
                && ((!Find.Object("pdpColorSwatchBox_vm").isDisplayed()));
    }

    public static void hasNoColorSwatchPresent() throws Exception {
        if (!(Find.Object("pdpDetailsSection_vm").getText().value()
                .toLowerCase().indexOf("color:") >= 0)
                && !(Find.Object("pdpColorSwatchName_vm").isPresent())
                && ((!Find.Object("pdpColorSwatchBox_vm").isPresent()))) {
            //
            Report.pass("Color Name Present", BrowserAction.screenshot());
        } else
            Report.fail("Color Name Not Present", BrowserAction.screenshot());

    }

    public static void ChannelBanner() {

        StepLogger.validate(Check.ObjectPresent, "pdpChannelBanner_WS");
    }

    public static void hasRecommends() {

        StepLogger.validate(Check.ObjectPresent, "pdpRecommends_WS");
    }

    public static void NoRecommends() {

        StepLogger.validate(Check.ObjectNotPresent, "pdpRecommends_WS");
    }

    public static void ShippingNReturnsAccordianNotPresent() throws Exception {

        if (!(Find.Object("pdpAccordion_wk").getText().value()
                .contains("Shipping"))) {

            Report.pass("Shipping & Returns accordion not displayed",
                    BrowserAction.screenshot());
        }
    }

    public static void VEGCForm() {

        StepLogger.validate(Check.ObjectPresent, "pdpVgcRecip");
    }

    public static void isStandardFreeShippingMsg() throws Exception {
        StepLogger.validate(Check.TextPresent, "pdpShippingReturnInfo_wk", "you may return your purchase for an exchange or refund");
    }

    public static void isColorMatchingWithProduct() throws Exception {
        if (Find.Object("pdpColorSelectedProduct_vm")
                .getText()
                .value()
                .equalsIgnoreCase(
                        Find.Object("pdpColorSelectedProduct_vm").getText()
                                .value())) {
            Report.pass("Color Selected Matching with Product Color",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Color Selected Not Matching with Product Color",
                    BrowserAction.screenshot());
        }
    }

    public static void isPersonalizedPageDisplayed() {
        StepLogger.validate(Check.TextPresent,
                "pdpPersonalizedPageContainer_vm", "Your Text:");

    }

    public static void FitPredictorLink() {

        StepLogger.validate(Check.ObjectPresent, "pdpSizeGuideBtn_wk");
    }

    public static void CalculateSizeLink() {

        StepLogger.validate(Check.ObjectPresent, "pdpCalculateSize_WS");
    }

    public static void NoFitPredictorLink() {

        StepLogger.validate(Check.ObjectNotPresent, "pdpSizeGuideBtn_wk");
    }

    public static void NoCalculateSizeLink() {

        StepLogger.validate(Check.ObjectNotPresent, "pdpCalculateSize_WS");
    }

    public static void YourBestSizeLink() {

        StepLogger.validate(Check.ObjectPresent, "pdpYourBestSize_WS");
    }

    public static void hasAskAQuestionLink() {

        StepLogger.validate(Check.ObjectPresent, "pdpAskAQuestionLink_WS");

    }

    public static void hasQnASection() {

        StepLogger.validate(Check.ObjectPresent, "pdpQnASection_WS");
    }

    public static void hasGiftCardNotAvailableMessage() {

    }

    public static void isSizeSwatchPresent() {

        StepLogger.validate(Check.ObjectPresent, "pdpFirstSizeSwatch_wk");

    }

    public static void hasCallToOrderMsg() {
        StepLogger.validate(Check.ObjectPresent, "pdpCallToOrderMsg");
    }

    public static void addtobagNotPresent() {
        StepLogger.validate(Check.ObjectNotPresent, "qlAddToBagBtn_wk");
    }

    public static void hasSoldOutStyle() throws Exception {
        if (Find.Object("soldOutLink").getAttribute("innerHTML").value()
                .indexOf("item size waitlist selected unavailable") > 0) {
            Report.pass("Item in sold out style", BrowserAction.screenshot());
        } else
            Report.fail("Item not in sold out style",
                    BrowserAction.screenshot());
    }

    public static void hasWaitListBoxPresent() {
        StepLogger.validate(Check.ObjectPresent, "pdpwaitListBox");
    }

    public static void hasSizeSwatch() {
        StepLogger.validate(Check.ObjectNotPresent, "pdpFirstSizeSwatch_wk");
    }

    public static void isSizeSelected() throws Exception {
        if (Find.Object("soldOutLink").getAttribute("innerHTML").value()
                .indexOf("selected") > 0) {
            Report.pass("Item size is selected", BrowserAction.screenshot());
        } else
            Report.fail("Item size is not selected", BrowserAction.screenshot());
    }

    public static void isSizeSwatchHidden() {

    }

    public static void hasSortedSizeLetters() throws Exception {
        List<Integer> intEquivalent = new ArrayList<Integer>();
        List<String> sizeElements = Find.MultipleObjects("pdpsizeElements")
                .getAttributes("title");
        sizeElements = removeNulls(sizeElements);
        for (int i = 0; i < sizeElements.size(); i++) {
            intEquivalent.add(new Integer((sizeLetter.valueOf(sizeElements
                    .get(i)).ordinal())));
        }

        if (isOrdered(intEquivalent)) {
            Report.pass("Elements of Size are Ordered",
                    BrowserAction.screenshot());
        } else
            Report.fail("Elements of Size are Not Ordered",
                    BrowserAction.screenshot());

    }

    private static boolean isOrdered(List<Integer> intEquivalent) {
        for (int i = 0; i < intEquivalent.size() - 1; i++) {
            if (intEquivalent.get(i).intValue() >= intEquivalent.get(i + 1)
                    .intValue()) {
                return false;
            }
        }
        return true;
    }

    public static void hasSortedShoeSizes() throws Exception {
        List<String> allSizes = Find.MultipleObjects("pdpMultipleSizes_wk")
                .getAttributes("data-value");

        allSizes = removeNulls(allSizes);
        List<ShoeSize> numericSizeList = new ArrayList<ShoeSize>();

        for (int i = 0; i < allSizes.size(); i++) {
            numericSizeList.add(i, new ShoeSize(allSizes.get(i)));
        }

        List<ShoeSize> tmp = new ArrayList<ShoeSize>(numericSizeList.size());
        for (ShoeSize numericSize : numericSizeList) {
            tmp.add(numericSize);
        }

        Collections.sort(tmp);
        if (tmp.equals(numericSizeList))
            Report.pass("Sizes are Sorted", BrowserAction.screenshot());
        else
            Report.fail("Sizes are Unsorted", BrowserAction.screenshot());
    }

    private static List<String> removeNulls(List<String> list) {
        List<String> returnList = new ArrayList<String>();
        for (String s : list) {
            if (!s.contains("null") && !s.equalsIgnoreCase(""))
                returnList.add(s);
        }
        return returnList;
    }

    public static void hasColorLabelNoSwatch(String colorLabel)
            throws Exception {

        if (Find.Object("pdpColorSizeSwatchSection_WS").isNotPresent()
                && Find.Object("pdpRedesignColorSection").getText().value()
                .contains(colorLabel)) {
            Report.pass("Color Label Present", BrowserAction.screenshot());
        }

    }

    public static void hasPriceWasNow() throws Exception {

        if (Find.Object("pdp_ItemPrice_WS").getText().value().toLowerCase()
                .contains("now")) {
            Report.pass("Was and Now Price displayed",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Was and Now Price NOT displayed",
                    BrowserAction.screenshot());
        }
    }


    public static void hasProperReturnUrl(ShippingReturnCountry country) throws Exception {
        String temp = Find.Object("pdpShippingDetailLink_wk").getAttribute("href").value();
        if (temp.contains(country.getUrl()))
            Report.pass("Url Matches: " + country.getUrl(), BrowserAction.screenshot());
        else Report.fail("Url Does Not Match: " + country.getUrl(), BrowserAction.screenshot());

    }

    public static void RecentlyViewedSectionHasRangedPrice(String upc)
            throws Exception {

        if (Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("now")) {
            Report.pass("RangedPrice Validation Pass",
                    BrowserAction.screenshot());
        } else {
            Report.fail("RangedPrice Validation Fail",
                    BrowserAction.screenshot());
        }
    }

    public static void RecentlyViewedSectionHasSalePrice(String upc)
            throws Exception {

        if (Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("- $")) {
            Report.pass("SalePrice Validation Pass", BrowserAction.screenshot());
        } else {
            Report.fail("SalePrice Validation Fail", BrowserAction.screenshot());
        }
    }

    public static void RecentlyViewedSectionHasRangedNSalePrice(String upc)
            throws Exception {

        if (Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("- $")
                && Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("now")) {
            Report.pass("Sale and Ranged Price Validation Pass",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Sale and Ranged Price Validation Fail",
                    BrowserAction.screenshot());
        }
    }

    public static void RecentlyViewedSectionHasStandardPrice(String upc)
            throws Exception {

        if (!(Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("- $"))
                || (!(Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("now")))) {
            Report.pass("Standard Price Validation Pass",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Standard Price Validation Fail",
                    BrowserAction.screenshot());
        }
    }

    public static void STLHasStandardPrice(String upc) throws Exception {

        if (!Find.Object("pdpSTLItemPrice_WS").changeContainsText(upc)
                .getText().value().contains("- $")
                || !(Find.Object("pdpRecentlyViewedSalePrice_WS")
                .changeAttributeContainsValue("data-product_code", upc)
                .getText().value().toLowerCase().contains("now"))) {

            Report.pass("Standard Price Validation Pass",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Standard Price Validation Fail",
                    BrowserAction.screenshot());
        }
    }

    public static void STLHasRangedPrice(String upc) throws Exception {

        if (Find.Object("pdpSTLItemPrice_WS").changeContainsText(upc).getText()
                .value().contains("- $")) {

            Report.pass("Ranged Price Validation Pass",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Ranged Price Validation Fail",
                    BrowserAction.screenshot());

        }
    }


    public static void STLHasSalePrice(String upc) throws Exception {

        if (Find.Object("pdpSTLItemPrice_WS").changeContainsText(upc).getText()
                .value().contains("now")) {

            Report.pass("Sale Price Validation Pass",
                    BrowserAction.screenshot());
        } else {
            Report.fail("Sale Price Validation Fail",
                    BrowserAction.screenshot());
        }

    }

    public static void hasSortedModernApparelSizes() throws Exception {
        List<String> allSizes = Find.MultipleObjects("pdpMultipleSizes_wk")
                .getAttributes("data-value");

        allSizes = removeNulls(allSizes);
        List<NumericSize> numericSizeList = new ArrayList<NumericSize>();

        for (int i = 0; i < allSizes.size(); i++) {
            numericSizeList.add(i, new NumericSize((Integer.parseInt(allSizes.get(i)))));
        }

        List<NumericSize> tmp = new ArrayList<NumericSize>(numericSizeList.size());
        for (NumericSize numericSize : numericSizeList) {
            tmp.add(numericSize);
        }

        Collections.sort(tmp);
        if (tmp.equals(numericSizeList))
            Report.pass("Sizes are Sorted", BrowserAction.screenshot());
        else
            Report.fail("Sizes are Unsorted", BrowserAction.screenshot());

    }


    public static void hasReturnMsgInAccordion() {
        StepLogger.validate(Check.TextPresent, "pdpShippingReturnInfo_wk", "you may return");
    }

    public static void returnMsgNotPresentInAccordion() {
        StepLogger.validate(Check.TextNotPresent, "pdpShippingReturnInfo_wk", "you may return");
    }

    public static void SoldOutButton() {

        StepLogger.validate(Check.ObjectPresent, "pdpSoldOutButton_WS");
    }

    public static void isWaitListable() {

        StepLogger.validate(Check.ObjectPresent, "pdpWaitListButton_WS");

    }

    public static void isNotWaitListable() {
        StepLogger.validate(Check.ObjectNotPresent, "pdpWaitListButton_WS");

    }

    public static void hasNoGiftWrapMsg() {
        StepLogger.validate(Check.TextPresent, "pdpShippingReturnInfo_wk", "Gift wrap is not available");
    }

    public static void DetailAccordion() {

        StepLogger.validate(Check.ObjectPresent, "pdpDetailsAccordion_WS");
    }

    public static void DetailAccordionContains(String text) throws Exception {

        if (Find.Object("pdpDetailsAccordion_WS").getText().value().toLowerCase().contains(text)) {

            Report.pass(text + " is present in Detail Accordion", BrowserAction.screenshot());
        }
    }

    public static void hasItemShownInColorMsg() throws Exception {
        Find.Object("pdpSwatchFirstAvailableSelection").click();
        if (Find.Object("pdpValidateItemShownInColor_wk").isPresent()) {
            String colorText = Find.Object("pdpColorSelected_wk").getText().value();
            String shownColor = Find.Object("pdpValidateItemShownInColor_wk").getText().value().trim();
            Report.pass("Item shown in msg displayed", BrowserAction.screenshot());
            if (colorText.contains(shownColor)) {
                Report.pass("Colors [" + colorText + ":" + shownColor + "] displayed", BrowserAction.screenshot());
            } else Report.fail("Colors [" + colorText + ":" + shownColor + "] displayed", BrowserAction.screenshot());
        } else Report.fail("Item shown in msg not displayed", BrowserAction.screenshot());
    }

    public static void hasSharingLinks() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "pdpProductActionsTxt_wk");
    }

    public static void hasShareWithFriend() throws Exception {

        Find.Object("pdpProductActionsTxt_wk").click();
        StepLogger.validate(Check.ObjectPresent, "pdpProductActionsTxt_wk");

    }

    public static void hasTitle(String specifiedTitle) throws Exception {
        StepLogger.validate(Check.TextPresent, "pdpProductTitleNameTxt_wk", specifiedTitle);


    }

    public static void hasRestrictedShippingMsg() {
        StepLogger.validate(Check.TextPresent, "pdpDomesticRestrictionTxt_wk", "cannot");


    }

    public static void hasProductName(String specifiedProductName) throws Exception {
        StepLogger.validate(Check.TextPresent, "pdpProductNameTxt_vm", specifiedProductName);

    }

    public static void hasShoprunner() throws Exception {
        StepLogger.validate(Check.TextPresent,"shopRunnerd_AAF");

    }

    public static void hasNoShoprunner() throws Exception{
        StepLogger.validate(Check.ObjectNotPresent, "shopRunnerd_AAF");

    }

    public static void validateSignoutShopRunner() throws Exception{
        StepLogger.validate(Check.TextPresent,"shopRunnerSignout_AAF");
    }
    public static void hasShortDescription(String description_Short) throws Exception{
        StepLogger.validate(Check.TextPresent,"htmlPage",description_Short);
    }
    public static void hasProductDescription(String product_Description) throws Exception{
        StepLogger.validate(Check.TextPresent,"htmlPage",product_Description);
    }
    public static void hasQuantityBox() throws Exception{
        StepLogger.validate(Check.ObjectPresent,"pdpRedesignQty");
    }
    public static void hasAddToBagButton() throws Exception{
        if(Find.Object("pdpRedesignAddToBagBtn").isPresent()){
            Report.pass("Add To Bag Button is Present in PDP Page");
        }else{
            Report.fail("Add To Bag Button is NOT Present");
        }
        //StepLogger.validate(Check.ObjectPresent,"pdpRedesignAddToBagBtn",BrowserAction.screenshot());
    }
    public static void hasReviewsSection() throws Exception{
        StepLogger.validate(Check.ObjectPresent,"reviewButton_vm");
    }



    public static void hasSTL(){
        StepLogger.validate(Check.ObjectPresent, "pdpStlValidation_wk");
    }

    public static void hasReadReviewsTeaserLink(){
        StepLogger.validate(Check.ObjectPresent, "pdpReadReviewTeaserLinkValidation_wk");
    }
    public static void hasWriteReviewsTeaserLink(){
        StepLogger.validate(Check.ObjectPresent, "pdpWriteReviewTeaserLinkValidation_wk");
    }
    public static void displaysFormForReviewLink() throws Exception {
        Find.Object("pdpWriteReviewTeaserLinkValidation_wk").click();
        Thread.sleep(2000L);
        StepLogger.validate(Check.ObjectPresent, "pdpReviewForm_wk");
        Find.Object("pdpCloseReviewFormBtn_wk").click();
    }

    public static void hasBogoDisplayedOnPdp(String promoMessage) throws Exception{

        if (Find.Object("ofm_bogoPromoPdp_AAF").isPresent()){
            Find.Object("ofm_bogoPromoPdp_AAF").getText().value().contains(promoMessage);
            Report.pass("Promo Message for Bogo Displayed: " + promoMessage,BrowserAction.screenshot());
        }else{
            Report.fail("Promo Meesage for Bogo is NOT displayed", BrowserAction.screenshot());
        }
    }

    public static void hasUserlandedOnPDPPage() throws Exception{
        if (Find.Object("pdpMain_AAF").isPresent()){
            Report.pass("User Landed On PDP Page");
        }else{
            Report.fail("PDP Page is NOT Displayed");
        }
    }

    public static void isSoldOutMessagePresent() throws Exception{
        if (Find.Object("soldOutMessageOnPDP_AAF").isPresent()){
            Report.pass("Sold Out Message is Present",BrowserAction.screenshot());
        }else{
            Report.fail("Sold Out Message is NOT Present");
        }
    }

    public static void isItemAvailableOnPDP() throws Exception{
        if (!Find.Object("soldOutMessageOnPDP_AAF").isPresent()){
            Report.pass("Product is Available");
        }else{
            Report.fail("NOT Available");
        }
    }

    public static void hasDropDownAvaliableOnPDP() throws Exception{

        if (Find.Object("dropDownOnPDP_AAF").isPresent()){
            Report.pass("DropDown is Available for Items with SKU Size More than 15");
        }else{
            Report.fail("DropDown is NOT Available");
        }
    }

    public static void isWaitListPresentOnPDP() throws Exception{
        if (Find.Object("waitListsOnPDP_AAF").isPresent()){
            Report.pass("WaitFor Lists Marketing Available");
        }else{
            Report.fail("WaitFor Lists NOT Available Because Item is NOT SOLD Out");
        }
    }

    public static void hasWaitListMessage() throws Exception{
//        Assert.IsPresent("Waitlits Message: This item is sold out. Add to WaitFor List to be notified when it is back in stock.", "waitlistsMessage_AAF");
        Assert.Report("Waitlits Message: This item is sold out. Add to WaitFor List to be notified when it is back in stock.").isExist("waitlistsMessage_AAF");
    }

    public static void hasSizeColorOptionAvailable() throws Exception{
            //Assert.IsPresent("Color is Available", "com_pdpSelectColor_wk");
        if (Find.Object("com_pdpSelectColor_wk").isPresent()){
            Report.pass("Select First Color");
        }
        if (Find.Object("fixedColor_AAF").isPresent()){
            Report.pass("Color is Selected");
        }
        }

    public static void hasSizeOptionsAvailable() throws Exception{
        //Assert.IsPresent("Size Options Available on PDP", "com_pdpSelectSize_wk");
        Assert.Report("Size Options Available on PDP").isExist("com_pdpSelectSize_wk");
    }

    public static void hasFindinStorePresentInPDP(String zipcode) throws Exception{

        if (Find.Object("findInStoreLink_AAF").isPresent()){
            Report.pass("Find In Store Link is Present in PDP");
            Find.Object("findInStoreLink_AAF").click();
        }else{
            Report.fail("Find in Store Link is NOT Displayed With this SKU");
        }
//        Assert.IsPresent("User Selects Size", "selectSizeFindInStore");
        Assert.Report("User Selects Size").isExist("selectSizeFindInStore");
        Find.Object("selectSizeFindInStore").select(1);
//        Assert.IsPresent("User Enters ZipCode", "enterZipFindinStore");
        Assert.Report("User Enters ZipCode").isExist("enterZipFindinStore");
        Find.Object("enterZipFindinStore").input(zipcode);
//        Assert.IsPresent("User Clicks on CheckStore Button","clickOnCheckStores");
        Assert.Report("User Clicks on CheckStore Button").isExist("clickOnCheckStores");
        Find.Object("clickOnCheckStores").click();
    }

    public static void hasSizeFirPredictorAvailableOnPDP() throws Exception{
        Thread.sleep(5000L);
//        Assert.IsPresent("Calculate Your Size Available in PDP with SKU", "sizeGuide_AAF");
//        Assert.IsPresent("Fit Predictor is Present","FitPredictor_AAF");
//        Assert.IsPresent("Calculate Your Size Selection Available and Clciked To Select Size", "calCulateSize_AAF");

        Assert.Report("Calculate Your Size Available in PDP with SKU").isExist("sizeGuide_AAF");
        Assert.Report("Fit Predictor").isExist("FitPredictor_AAF");
        Assert.Report("Calculate Your Size Selection Available and Clciked To Select Size").isExist("calCulateSize_AAF");

    }
    public static void hasPriceRageAvailablePDP() throws Exception{
         if (Find.Object("priceRage_AAF").isPresent()){
            Report.pass("Price Rage and Discounted/Off Price Displayed on PDP");
         }else{
             Report.fail("Price Rage is NOT Displayed");
         }
    }

    public static void hasSocialShareLinkAvailable() throws Exception{
        if (Find.Object("socialShareLink_AAF").isPresent()){
            Report.pass("Socialshare Links Are Available in PDP",BrowserAction.screenshot());
            //Find.Object("fbLinks_AAF").click();
        }else{
            Report.fail("SocialShare Links Are NOT Available");
        }

    }

    public static void isIsternationalCurrencyDisplayed() throws Exception{
        if (Find.Object("priceRage_AAF").isPresent()){
            Report.pass("International PRICE Range is Present and Displayed on PDP Page");
        }else{
            Report.fail("Price Rage is NOT Displayed");
        }
    }

    public static void priceAndDiscountDisplayed()throws Exception{
        if (Find.Object("strikedOff_AAF").isPresent()){
            Report.pass("Strike Off Price is Displayed on PDP Page");
        }else{
            Report.fail("Strike Off Price is NOT Displayed");
        }
        if(Find.Object("presentPriceRange_AAF").isPresent()){
            Report.pass("Price Rage and Discount with Percent Off Displayed");
        }else{
            Report.fail("Price Rage with Percent Discount is NOT Present and Displayed");
        }
    }

    public static void recentlyViewdItem() throws Exception{
        Thread.sleep(9000L);
        if(Find.Object("closeButtonSubwindow_AAF").isPresent()){
            Report.pass("Our Customer Q&A module is temporarily down for maintenance. Thank you for your patience. \n ANNE BACKY created Defect in QC");
            Find.Object("closeButtonSubwindow_AAF").click();
        }
        Thread.sleep(9000L);
        if (Find.Object("recentlyViewedItems_AAF").isPresent()) {
            Report.pass("Recently Viewd Items are Present");
        }else{
            Report.fail("Recently Viewed Items NOT available");
        }
    }

    public static void haspromoMoremessageOnFooter() throws Exception{
        if(Find.Object("promoMore_AAF").isPresent()){
            Report.pass("More! Promo Message is Displayed");
        }else{
            Report.fail("Promo Message with MORE is NOT displayed");
        }
    }

    public static void hasMorePromoOnPDP() throws Exception{

        if (Find.Object("morePromoMessage_AAF").isPresent()){
            Report.pass("More Promo Message is Displayed with Item");
        }else{
            Report.fail("More Promo Message is NOT displayed");
        }
    }
}
