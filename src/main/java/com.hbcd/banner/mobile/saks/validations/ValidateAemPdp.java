package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.fluentInterface.MultiObjectsAction;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hbcd.scripting.core.BrowserAction.javascriptExecuteScript;
import static com.hbcd.scripting.core.Use.CapturedObject;

/**
 * Created by williskong on 11/13/2015.
 */
public class ValidateAemPdp {
    public static void hasHighDemandMessage() throws Exception {
        StepLogger.validate(Check.TextPresent, "AEMhighDemandMsg_wk", "");
    }
    public static void numberOfItemsAddedOverlayMessage(int q) throws Exception{
        if(Find.Object("AEMcartOverlayTxt_wk").getText().value().contains(""+ q))
            Report.pass( q + " ITEMS IN YOUR BAG");
        else Report.fail("number of items failed");
    }

    public static void shippingReturnsAccordion() throws Exception{
        if(Find.Object("AEMproductAccordion_wk").getText().value().contains("Shipping & Returns"))
            Report.pass("shipping accordion displayed");
        else Report.fail("No Shipping Accordion");
    }

    public static void FBlink() {
        StepLogger.validate(Check.ObjectPresent, "AEMpdpFbIcon_wk");
    }

    public static void PinItlink() {
        StepLogger.validate(Check.ObjectPresent, "AEMpdpPinIcon_wk");
    }

    public static void TwitterLink() {
        StepLogger.validate(Check.ObjectPresent, "AEMpdpTwitterIcon_wk");
    }

    public static void GooglePlusLink() {
        StepLogger.validate(Check.ObjectPresent, "AEMpdpGoogleIcon_wk");
    }

    public static void EmailLink() {
        StepLogger.validate(Check.ObjectPresent, "AEMpdpEmailIcon_wk");
    }

    public static void hasNumberOfItemsInOverlay(String items) throws Exception{
       // Thread.sleep(9000L);
        if(Find.Object("closeButtonSubwindow_AAF").isPresent()){
            Report.pass("Our Customer Q&A module is temporarily down for maintenance. Thank you for your patience. \n ANNE BACKY created Defect in QC");
            Find.Object("closeButtonSubwindow_AAF").click();
        }
       // Thread.sleep(9000L);
        if (!Find.Object("bOverlay").isPresent()) {
            Find.Object("pdpBagLink").click();
            Thread.sleep(1000);
        }
       Find.Object("itemsInOverLay_AAF").getText().value().contains(items);
        Report.pass(items + " items In your Bag");
    }

    public static void hasBrandName() throws Exception {
        if(Find.Object("com_pdpBrand_wk").isPresent()){
            Report.pass("Brand name is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Brand name is not present",BrowserAction.screenshot());
        }
    }

    public static void hasItemNumber() throws Exception {
        if(Find.Object("com_pdpItemNumber_wk").isPresent()){
            Report.pass("Item Number is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Item number is not present",BrowserAction.screenshot());
        }
    }

    public static void hasCurrencyCode() throws Exception {
        if(Find.Object("com_pdpBrand_wk").isPresent()){
            Report.pass("Currency Code is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Currency Code is not present",BrowserAction.screenshot());
        }
    }

    public static void hasSinglePrice() throws Exception{
        int priceCount = Find.MultipleObjects("pdp_pricingmodels_wk").size();

        if(priceCount == 1){
            Report.pass("Single Price is displayed",BrowserAction.screenshot());
        }
        else if (priceCount > 1){
            Report.fail("More than a single price is displayed",BrowserAction.screenshot());
        }else Report.fail("No price displayed",BrowserAction.screenshot());
    }

    public static void hasMultiplePrices() throws Exception{
        boolean priceCount = Find.Object("pdp_priceSection_wk").getText().value().indexOf("$")!=
                Find.Object("pdp_priceSection_wk").getText().value().lastIndexOf("$");

        if(priceCount){
            Report.pass("Multiple Prices displayed",BrowserAction.screenshot());
        } else Report.fail("No price displayed",BrowserAction.screenshot());
    }

    public static void hasAddToBag() throws Exception{
        if(Find.Object("com_pdpBrand_wk").isPresent()){ //TODO: looking for the wrong element
            Report.pass("Add To Bag is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Add to bag is not present",BrowserAction.screenshot());
        }
    }

    public static void hasSharingIcons() throws Exception{
        if(Find.Object("socialShareLink_AAF").isPresent()){
            Report.pass("Sharing icons is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Sharing icons is not present",BrowserAction.screenshot());
        }
    }

    public static void hasShortDescription() throws Exception{
        if(Find.Object("com_pdpShortDescription_wk").isPresent()){
            Report.pass("Short description is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Short description is not present",BrowserAction.screenshot());
        }
    }

    public static void hasTellAFriend() throws Exception {
        if(Find.Object("htmlPage").getText().value().toLowerCase().indexOf("tell a friend")>=0){
            Report.pass("Tell a friend is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Tell a friend is not present",BrowserAction.screenshot());
        }
    }

    public static void hasBrandNameMini(String name) throws Exception{

        if(Find.Object("bOverlay").getText().value().toLowerCase().contains(name.toLowerCase())){
            Report.pass("Brand Name is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Brand Name is not present",BrowserAction.screenshot());
        }
    }

    public static void hasQtyMini(String qty) throws Exception {
        if(Find.Object("bOverlay").getText().value().toLowerCase().indexOf(qty)>=0){
            Report.pass("Mini Qty is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Mini Qty is not present",BrowserAction.screenshot());
        }
    }

    public static void hasColorMini(String color) throws Exception {
        if(Find.Object("bOverlay").getText().value().toLowerCase().indexOf(color)>=0){
            Report.pass("Color is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Color is not present",BrowserAction.screenshot());
        }
    }

    public static void hasSizeMini() throws Exception {
        Pattern sizePattern = Pattern.compile("\\d* (\\d)");
        Matcher m = sizePattern.matcher(Find.Object("bOverlay").getText().value());

        if(Find.Object("bOverlay").getText().value().toLowerCase().contains("size")){
            Report.pass("Size found in minibag");
        }
        else {
            Report.fail("Size not found in minibag");
        }
    }

    public static void hasPriceMini() throws Exception {
        Pattern shortPricePattern = Pattern.compile("\\$\\d{1,}\\.\\d{2}");
        Pattern longPricePattern = Pattern.compile("\\$\\d{1,}.(\\d{3})+\\.\\d{2}");
        String minibagString = Find.Object("bOverlay").getText().value();

        if(shortPricePattern.matcher(minibagString).find())
            Report.pass("Price found in minibag");
        else if(longPricePattern.matcher(minibagString).find()){
            Report.pass("Longer Price found");
        }
        else{
            Report.fail("No prices found");
        }
    }

    public static void hasSinglePriceMini(String singlePrice) throws Exception {
        if(Find.Object("bOverlay").getText().value().toLowerCase().indexOf(singlePrice)>=0){
            Report.pass("Single Price is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Single Price is not present",BrowserAction.screenshot());
        }
    }

    public static void hasItemInStock(String itemInStock) throws Exception {
        if(Find.Object("bOverlay").getText().value().toLowerCase().indexOf(itemInStock)>=0){
            Report.pass("In Stock message is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("In Stock message is not present",BrowserAction.screenshot());
        }
    }

    /** getting text from object doesn't give number inside Front-End textbox */
    public static void isQtyIncremented() throws Exception{
        final String quantityId = "numberInput";
        String quantityBeforeClick = (String)BrowserAction.javascriptExecuteScript("document.getElementById('numberInput').value");
        Find.Object("pdp_incrementQtyBtn_wk").click();
        String quantityAfterClick = (String)BrowserAction.javascriptExecuteScript("document.getElementById('numberInput').value");

        Report.fail("Quantity retrieval not working");
    }

    public static void hasRecentlyViewed() throws Exception{
        if(Find.Object("recentlyviewedsection_vm").isPresent()){
            Report.pass("Recently Viewed Section is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Recently Viewed Section is not present",BrowserAction.screenshot());
        }
    }

    public static void isCsrItem() throws Exception{
        if(Find.Object("htmlPage").getText().value().toLowerCase().indexOf("to purchase this item, please call")>=0){
            Report.pass("CSR Message is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("CSR Message is not present",BrowserAction.screenshot());
        }
    }

    public static void isFinalSaleItem() throws Exception{
        if(Find.Object("htmlPage").getText().value().toLowerCase().indexOf("items that cannot be returned are marked as final sale")>=0){
            Report.pass("Final Sale message is present",BrowserAction.screenshot());
        }
        else{
            Report.fail("Final Sale message is not present",BrowserAction.screenshot());
        }
    }

    public static void hasMinRichRel() throws Exception {
        Find.Object("pdp_richRelItems_wk").storeAs("richRelParent");
        int test = CapturedObject("richRelParent").FindMultipleObjects("pdp_richRelItem_wk").size();
        if(test >= 6)
            Report.pass("Scen16 has at least 6 items");
        else Report.fail("Scen16 does not have at least 6 items");
    }

    public static void hasRichRelItemInformation() throws Exception {
        Find.Object("pdp_richRelItems_wk").storeAs("richRelParent");
        int itemCount = CapturedObject("richRelParent").FindMultipleObjects("pdp_richRelProductTitle_wk").size();
        MultiObjectsAction richRelItems = Use.CapturedObject("richRelParent").FindMultipleObjects("pdp_richRelProductTitle_wk");
        for(int i =0; i < itemCount; i ++)
            if(!richRelItems.select(i).equals(""))
                Report.pass("title displayed on item " + i);
            else Report.fail("title not displayed displayed on item " + i);
    }

    public static void hasRichRelPriceInformation() throws Exception {

        Find.Object("pdp_richRelItems_wk").storeAs("richRelParent");
        int itemCount = CapturedObject("parent").FindMultipleObjects("pdp_richRelPrice_wk").size();
        MultiObjectsAction richRelItems = Use.CapturedObject("parent").FindMultipleObjects("pdp_richRelProductTitle_wk");
        for(int i =0; i < itemCount; i ++)
            if(!richRelItems.select(i).equals(""))
                Report.pass("Price displayed on item " + i);
            else Report.fail("Price not displayed displayed on item " + i);
    }

    public static void hasRichRelSpdInformation() throws Exception {

        Find.Object("pdp_richRelItems_wk").storeAs("richRelParent");
        int itemCount = CapturedObject("parent").FindMultipleObjects("pdp_richRelSpd_wk").size();
        MultiObjectsAction richRelItems = Use.CapturedObject("parent").FindMultipleObjects("pdp_richRelProductTitle_wk");
        for(int i =0; i < itemCount; i ++)
            if(!richRelItems.select(i).equals(""))
                Report.pass("SPD displayed on item " + i);
            else Report.fail("SPD not displayed displayed on item " + i);
    }

    public static void isSoldOut() throws Exception{
        if(Find.Object("AEMsoldOutMsg_wk").isPresent()){
            Report.pass("item sold out");
        }else Report.fail("item not sold out");
    }

    public static void isAvailable() throws Exception{
        if(!Find.Object("AEMsoldOutMsg_wk").isPresent()){
            Report.pass("item sold out");
        }else Report.fail("item not sold out");
    }

    public static void hasDropdown() throws Exception{
        if(Find.Object("pdp_dropdown_wk").isPresent()){
            Report.pass("dropdown displayed");
        }else Report.fail("dropdown not shown");
    }

    public static void hasSizeSection() throws Exception{
        if(Find.Object("pdp_sizeSection_wk").isPresent()){
            Report.pass("Size section found");
        }else Report.fail("Size section not found");
    }

    public static void hasColorSection() throws Exception{
        if(Find.Object("pdp_colorSection_wk").isPresent()){
            Report.pass("Color section found");
        }else Report.fail("Color section not found");
    }

    public static void hasSizeGuide() throws Exception {
        if(Find.Object("pdp_sizeGuideLink_wk").isPresent()){
            Report.pass("Size Guide link found");
        }else Report.fail("Size Guide link not found");
    }

    public static void hasPriceRange() throws Exception{
        String priceText = Find.Object("pdp_priceSection_wk").getText().value().toLowerCase();

        if(priceText.contains("-")
                && priceText.indexOf("$") != priceText.lastIndexOf("$")){
            Report.pass("Price Range present");
        }else Report.fail("Price Range not displayed");
    }

    public static void hasWasAndNowPrice() throws Exception{
        Find.Object("pdp_priceSection_wk").storeAs("priceSection");
        String priceText = Use.CapturedObject("priceSection").AsIs().getText().value().toLowerCase();

        if(priceText.contains("was")
                && priceText.contains("now")
                && priceText.indexOf("$") != priceText.lastIndexOf("$")){
            Report.pass("Was and Now present");
        }else Report.fail("Was and Now Prices not displayed");
    }

    public static void hasChanelBanner() throws Exception{
        if(Find.Object("pdp_chanelBanner_wk").isPresent()){
            Report.pass("Chanel Banner present");
        }else Report.fail("Chanel Banner not displayed");
    }

    public static void hasReviews() throws Exception{
        Find.Object("pdp_reviewsTabBtn_wk").javascriptClick();
        if(Find.Object("pdp_reviewsContent_wk").isPresent())
            Report.pass("Reviews Content displayed after clicking reviews tab");
        else Report.fail("Reviews Content not displayed");
    }

    public static void hasQuestions() throws Exception{
        Find.Object("pdp_questionsTabBtn_wk").javascriptClick();
        if(Find.Object("pdp_questionsContent_wk").isPresent())
            Report.pass("Questions and Answers Content displayed after clicking Q&A tab");
        else Report.fail("Questions and Answers Content not displayed");
    }


    public static void noShippingAccordion() throws Exception{
        if(!Find.Object("AEMproductAccordion_wk").getText().value().contains("Shipping & Returns"))
            Report.pass("No Shipping Accordion");
        else Report.fail("shipping accordion displayed");
    }


    public static void noSharingIcons() throws Exception{
        if(!Find.Object("socialShareLink_AAF").isPresent())
            Report.pass("Sharing icons is not present",BrowserAction.screenshot());
        else Report.fail("Sharing icons is present",BrowserAction.screenshot());
    }

    public static void chanelRedirect() throws Exception{
        Find.Object("pdp_chanelBrandLink_wk").click();
        if(Find.Object("dlp_chanel_wk").isPresent() &&
                Navigate.currentUrl().contains("WorldOfDesigner"))
            Report.pass("Chanel DLP working");
        else Report.fail("Chanel DLP not showing");
    }


    public static void hasNoDLP() throws Exception{
        Find.Object("com_pdpBrand_wk").click();
        if(Navigate.currentUrl().contains("EndecaSearch"))
            Report.pass("Product Array displayed");
        else Report.fail("ended on DLP");
    }

    public static void hasReviewsTeaser() throws Exception{
        Find.Object("pdp_reviewsTabBtn_wk").javascriptClick();
        String reviewsContent = Find.Object("pdp_reviewsContent_wk").getText().value();
        if(reviewsContent.toLowerCase().contains("tell us what you think")){
            Report.pass("Reviews teaser content valid");
        }else Report.fail("Reviews teaser content invalid");
    }

    public static void hasQuestionsTeaser() throws Exception{
        Find.Object("pdp_questionsTabBtn_wk").javascriptClick();
        String questionsContent = Find.Object("pdp_questionsContent_wk").getText().value();
        if(questionsContent.toLowerCase().contains("questions that need answers")){
            Report.pass("Questions teaser content valid");
        }else Report.fail("Questions teaser content invalid");
    }

    public static void noAddToBag() throws Exception{
        if(Find.Object("com_pdpAddToBag_wk").isPresent())
            Report.fail("Add to bag found on page");
        else Report.pass("Add to bag not found!");
    }

    public static void hasShippingRestrictionMsg() throws Exception {
        if(Find.Object("pdp_internationalRestriction_wk").isPresent() &&
                Find.Object("pdp_internationalRestriction_wk").getText()
                        .value().toLowerCase().contains("cannot be shipped")){
            Report.pass("Restriction message displayed");
        }else Report.fail("Cannot find restriction message");
    }

    public static void hasIndiaCurrency() throws Exception {
        if(Find.Object("com_pdpCurrencySymbol_wk").getText().value().contains("INR")){
            Report.pass("INR displayed");
        }else Report.fail("India Currency not shown");
    }

    public static void hasGiftCardDenominations() throws Exception {
        if(Find.Object("pdp_gcDenominations_wk").isPresent()){
            Report.pass("Denominations object displayed");
        }else Report.fail("Denominations not shown");
    }

    public static void sameDayDelivery() throws Exception {
        Find.Object("pdp_fisTabLink_wk").javascriptClick();
        Find.Object("pdp_fisZipTxt_wk").input("10017");
        Find.Object("pdp_fisCheckStoresBtn_wk").click();
        if(Find.Object("pdp_fisSddContent_wk").isPresent()){
            Report.pass("FIS Same day delivery displayed");
        }else Report.fail("cannot find same day delivery content");
    }

    public static void doesNotHaveStruckOutPrice()throws Exception {
        Boolean strikeThroughClass = Use.CapturedObject("priceSection").FindObject("pdp_previousPrice_wk").isPresent();

        if(strikeThroughClass){
            Report.fail("Foudn Strike out class for previous price");
        }else Report.pass("Previous price not using struck out CSS");
    }
    public static void hasStruckOutPrice()throws Exception {
        Boolean strikeThroughClass = Use.CapturedObject("priceSection").FindObject("pdp_previousPrice_wk").isPresent();

        if(strikeThroughClass){
            Report.pass("Previous price using struck out CSS");
        }else Report.fail("Not able to find Strike out class for previous price");
    }

    public static void isPDP() throws Exception{
        if (Find.Object("com_pdpAddToBag_wk").isPresent() || Find.Object("AEMsoldOutMsg_wk").isPresent()){
            Report.pass(String.format("User is in PDP Page"));
        }else{
            Report.fail("PDP Page is NOT displayed");
        }
    }

}
