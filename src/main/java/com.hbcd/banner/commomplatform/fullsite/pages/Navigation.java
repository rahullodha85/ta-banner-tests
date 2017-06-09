package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.banner.s5a.drawers.*;
import com.hbcd.commonbanner.base.overlays.SignInOverlayBase;
import com.hbcd.commonbanner.base.pages.NavigationPageBase;
import com.hbcd.commonbanner.drawer.Drawer;
import com.hbcd.commonbanner.enums.BotNavLinks;
import com.hbcd.commonbanner.enums.NavLinks;
import com.hbcd.commonbanner.enums.TopNavLinks;
import com.hbcd.commonbanner.overlays.SignInOverlay;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/1/2016.
 */
public class Navigation extends NavigationPageBase {
    @Override
    public void ClickNavigationLinks(TopNavLinks linkName) throws Exception {
        clickNavLink(linkName.toString());
//		clickLinkByClassAndText("menu-item", linkName.toString());
//		StepLogger.validate(Check.ObjectPresent, linkName.getObjectToValidate());
    }
    @Override
    public void ClickLeftNavLink(String link) throws Exception {
        clickLinkByClassAndChildText("sfa-left-nav-content-container", link);
    }
    /*@Override
    public void isPresentLeftNavLink(LeftNavLinks link) throws Exception {
        if(Find.LinkWithText(false, "", link.toString()).isPresent())
        New.Object("").setProperty(PropertyType.CLASS, "left-nav-groups")
        .setChildProperty(PropertyType.CONTAINS_TEXT, link.toString()).click();
        StepLogger.validate(Check.ObjectPresent, link. );
    }*/
    @Override
    public void ClickBottomNavLink(BotNavLinks link) throws Exception {
        Find.Object("sfBottomNavLinkTxt_wk").changeChildContainsText(link.toString()).click();
        StepLogger.validate(Check.TextPresent, link.getObjectName());
        Thread.sleep(5000);
    }
    @Override
    public Drawer HoverNavLinks(TopNavLinks linkText) throws Exception {
        hoverLinkByCssAndText("a[class='menu-item-link']", linkText.toString());
        StepLogger.validate(Check.ObjectPresent, linkText.getObjectToValidate());
        switch(linkText){
            case BEAUTY: return new s5a_BeautyDrawer();
            case DESIGNERS: return new s5a_DesignerDrawer();
            case HOME: return new s5a_HomeDrawer();
            case JEWELRYACCESSORIES:return new s5a_JewelryDrawer();
            case KIDS: return new s5a_KidsDrawer();
            case MEN: return new s5a_MensDrawer();
            case SALE: return new s5a_SaleDrawer();
            case SHOES: return new s5a_ShoesHandDrawer();
            case WOMENSAPPAREL: return new s5a_WomAppDrawer();
            default : return null;}
    }
    @Override
    public void EnterBag() throws Exception {
        Find.Object("pdpBagLink").click();
        Find.Object("bOverlayViewBagBtn").click();
    }
    @Override
    public void SelectCountry(String country) throws Exception{
        //Thread.sleep(3000);
        Find.Object("navChangeCountryBtn").click();

        Find.Object("changeCountryDrpDwn").select(country);
    }
    @Override
    public void ChangeCountry(String country) throws Exception {
        SelectCountry(country);
        Find.Object("changeCountrySaveBtn").click();
        if(Find.Object("shippingCountry_vm").getAttribute("outerHTML").value().toString().toLowerCase().indexOf("US.gif")<0){
            Report.pass("Country Changed", BrowserAction.screenshot());
        }
        else {
            Report.fail("Country not Changed",BrowserAction.screenshot());
        }
        Thread.sleep(7000);
        if(Find.Object("htmlPage").getText().value().toLowerCase().indexOf("continue shopping")>0)
        {
            StepLogger.validate(Check.TextPresent, "htmlPage", "NOW SHIPPING TO");
            Find.Object("changeCountryContinueShopping").click();
        }

    }
    @Override
    public void ClickSaksYourAccount() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "navYourAccount_wk");
        Find.Object("navYourAccount_wk").click();
        StepLogger.validate(Check.TextPresent, "htmlPage", "Save your information to take advantage of a faster checkout process");
    }
    @Override
    public void ClickShipTo() throws Exception {
        Find.Object("navShpTo_ve").click();
    }
    @Override
    public void SelectDesigner(String designer) throws Exception {
        Find.Object("navDesignerDrpdwn_wk").select(designer);
        if(Find.Object("navSelectedTab_wk").isPresent());
        //StepLogger.validate(Check.TextPresent, "prpFirstItem", designer, BrowserAction.screenshot());
        //else StepLogger.validate(Check.TextPresent, "LeftNavSelectBoxValidation_wk", designer, BrowserAction.screenshot());
    }

    @Override
    public void SelectFirstDesigner() throws Exception {
        if(Find.Object("navDesignerDrpdwn_wk").isPresent()) {
            Report.pass("Designer dropdown is present on left navigation");
            Find.Object("navDesignerDrpdwn_wk").select(1);
        } else {
            Report.systemFail("Designer selection Dropdown is not present", BrowserAction.screenshot());
        }
    }

    @Override
    public void isPresentLink(NavLinks link) throws Exception{
        Find.LinkWithText(false, "", link.toString()).isPresent();

    }
    @Override
    public void ClickShopAll() throws Exception {
        Find.Object("prpShopAllLhnBtn_wk").click();
    }

    public void goToPage(String linkText) throws Exception{

        Find.Object("accountbtn").hover();
        New.Object("").setProperty(Type.PropertyType.LINK_TEXT, linkText).click();

    }
    private void clickNavLink(String linkText) throws Exception{
        New.Object("").setProperty(Type.PropertyType.CSS_SELECTOR, "div[class='nav']")
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.CLASS, "menu-item-link")
                .setChildProperty(Type.PropertyType.CONTAINS_TEXT, linkText)
                .setChildProperty(Type.PropertyIntType.iTH, 1)
                .click();
    }

    /** Creates/Clicks on new Action Object with specified Class and LinkText */
    private void clickLinkByClassAndText(String className, String linkText) throws Exception {
        New.Object("").setProperty(Type.PropertyType.CLASS, className)
                .setProperty(Type.PropertyType.PARTIAL_LINK_TEXT, linkText)
                .setProperty(Type.PropertyType.CONTAINS_TEXT, linkText)
                .click();
    }
    private void clickLinkByClassAndChildText(String className, String linkText) throws Exception {
        New.Object("").setProperty(Type.PropertyType.CLASS, className)
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.TAG_NAME, "a")
                .setChildProperty(Type.PropertyType.CONTAINS_TEXT, linkText)
                .setChildProperty(Type.PropertyIntType.iTH, 1)
                .click();
    }
    /** Hovers on new Action Object with specified Class and LinkText */
    private void hoverLinkByClassAndText(String className, String linkText) throws Exception {
        New.Object("").setProperty(Type.PropertyType.CLASS, className)
                .setProperty(Type.PropertyType.CONTAINS_TEXT, linkText).hover();
    }
    /** Hovers on new Action Object with specified Class and LinkText */
    private void hoverLinkByCssAndText(String cssSelector, String linkText) throws Exception {
        New.Object("").setProperty(Type.PropertyType.CSS_SELECTOR, cssSelector)
                .setProperty(Type.PropertyType.CONTAINS_TEXT, linkText).hover();
    }
    @Override
    public void ClickLeftNavLink(NavLinks link) throws Exception {
        if (Find.Object("leftNavLink_AAF").isDisplayed()){
            Report.pass("Object Present");
        }else{
            Report.fail("Object Not Present");
        }
        Find.Object("leftNavLink_AAF").click();
    }
    @Override
    public void ClickBackToUSSite() throws Exception{
        Find.Object("backtoussite_vm").click();

    }

    @Override
    public Drawer HoverOverSignIn() throws Exception{
        if(Find.Object("conMyAccountBtn").isPresent()){
            Find.Object("conMyAccountBtn").hover();
            Report.pass("Welcome/SignIn link displayed and mouse hover over action performed to open signIn drawer menu",
                    BrowserAction.screenshot());
            return new s5a_SignInDrawer();
        }else{
            Report.fail("Welcome/SignIn link in top menu not found",
                    BrowserAction.screenshot());
            return null;
        }
    }
    @Override
    public void ClickTopNavLink(String link) throws Exception {
        Find.Object("shopRunnertopNav_AAF").changeChildContainsText(link).click();

    }

    @Override
    public void HoverTopNav(String link) throws Exception {
        Find.Object("shopRunnertopNav_AAF").hover();
        Find.Object("shopAllShoprunner_AAF").changeContainsText(link).click();
    }

    @Override
    public void ClickSubNavLeft(String link) throws Exception {
        if (Find.Object("leftNavLink_AAF").isDisplayed()){
            Report.pass("Object Present");
        }else{
            Report.fail("Object Not Present");
        }
        Find.Object("leftNavLink_AAF").click();
    }

    @Override
    public void CloseHomePagePopup() throws Exception {
        if(Find.Object("home_iframe").isPresent()) {
            Switch.toFrameObject("home_iframe");
            if (Find.Object("CloseButton").isPresent()) {
                Find.Object("CloseButton").click();
            }
            Switch.toDefaultContent();
        }
    }

    @Override
    public void ClickSignUpBtn() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "SignUpNowBtn");
        if (Find.Object("SignUpNowBtn").isPresentDisplayedEnabled()) {
            Report.pass("SignUp button displayed on footer",
                    BrowserAction.screenshot());
            Find.Object("SignUpNowBtn").click();
        } else {
            Report.fail("SignUp button not displayed on footer",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public StoreLocatorPage ClickStoreLocator() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "StoreLocatorLink");
        if (Find.Object("StoreLocatorLink").isPresentDisplayedEnabled()) {

            Find.Object("StoreLocatorLink").click();
            Report.pass("STORE LOCATOR link is found on Header",
                    BrowserAction.screenshot());

        } else {
            Report.fail("STORE LOCATOR link is not found on Header",
                    BrowserAction.screenshot());
        }
        return new StoreLocatorPage();
    }

    @Override
    public SignInOverlay ClickSignIn() throws Exception {
        Find.Object("o5m_navSignInBtn_wk").click();
        return new SignInOverlayBase();
    }

    @Override
    public void ClickSignInLink() throws Exception {
        if(Find.Object("signInLink_RL").isPresent()) {
            Report.pass("Sign-in Link found and clicked");
            Find.Object("signInLink_RL").click();
        } else {
            Report.fail("Sign-in Link is not present on Top Navigation Menu");
        }
    }

    @Override
    public void SearchFor(String value) throws Exception {
        if (Find.Object("SearchItemFieldTxtBx").isPresent()){
            Report.pass("Searched TextBox is Displayed");
        }
        else{
            Report.fail("Search TextBox is NOT displayed");
        }
        Find.Object("SearchItemFieldTxtBx").clear();
        Find.Object("SearchItemFieldTxtBx").input(value);
        //Find.Object("SearchItemFieldTxtBx").enter();
        Report.pass("Search For " + value, BrowserAction.screenshot());
        Find.Object("SearchItemFieldTxtBx").submit().getPerformance("SUBMIT on Search Button", "SearchFunction");
    }

    @Override
    public void ClickSearchCategories() throws Exception{
        Find.Object("SearchItemFieldTxtBx").input(" ");
        if (Find.Object("searchCategories_AAF").isPresent()){
            Report.pass("User Clicks on Search Categories");
            Find.Object("searchCategories_AAF").click();
            Find.Object("selectOptionDropDown_AAF").click();
            Find.Object("SearchItemFieldTxtBx").submit().getPerformance("SUBMIT on Search Button", "SearchFunction");
        }else{
            Report.fail("Search Categories are NOT available");
        }

    }

    @Override
    public void ClickBrandsDrawer() throws Exception{
        String _PAObjects = Find.MultipleObjects("saksHomePageAnyPALinks_AAF").getText().toString();
        System.out.println(_PAObjects);
        if (_PAObjects.contains("WOMEN'S APPAREL")){
            clickTopNavPALinks("WOMEN'S APPAREL");
        }else if (_PAObjects.contains("SHOES")){
            clickTopNavPALinks("SHOES");
        }else if (_PAObjects.contains("HANDBAGS")){
            clickTopNavPALinks("HANDBAGS");
        }else if (_PAObjects.contains("HANDBAGS")){
            clickTopNavPALinks("HANDBAGS");
        }else if (_PAObjects.contains("JEWELRY & ACCESSORIES")){
            clickTopNavPALinks("JEWELRY & ACCESSORIES");
        }else if (_PAObjects.contains("MEN")){
            clickNavLink("MEN");
        }else if (_PAObjects.contains("HOME")){
            clickNavLink("HOME");
        }else{
            Report.dataFail("PA links from HomePage are NOT available");
        }
    }

    private static void clickTopNavPALinks(String links) throws Exception{
        switch(links){
            case "WOMEN'S APPAREL":
                if (Find.Object("navWomAppDrawerValidation").isPresent()){
                    Report.pass("User Clicks the Women's Apparel Links from Top Nav");
                    Find.Object("navWomAppDrawerValidation").click();
                }else{
                    Report.fail("Women's Apparel link is NOT available");
                }
                break;

            case "SHOES":
                if (Find.Object("navShoesDrawerValidation").isPresent()){
                    Report.pass("User Clicks the Shoes from TopNav Links");
                    Find.Object("navShoesDrawerValidation").click();
                }else{
                    Report.fail("Shoes link is NOT available");
                }
                break;

            case "HANDBAGS":
                if (Find.Object("navHandbagDrawerValidation").isPresent()){
                    Report.pass("User Clicks the Handbags from TopNav Links");
                    Find.Object("navHandbagDrawerValidation").click();
                }else{
                    Report.fail("HandBag Links are NOT available");
                }
                break;

            case "JEWELRY & ACCESSORIES":
                if (Find.Object("navJewelryDrawerValidation").isPresent()){
                    Find.Object("navJewelryDrawerValidation").click();
                    Report.pass("User Clicks on the Jewelry and Accessories from Top Nav Links");
                    Find.Object("navJewelryDrawerValidation").click();
                }else{
                    Report.fail("Jewelry and Accessories is NOT avaolable");
                }
                break;
            case "MEN":
                if (Find.Object("navMensDrawerValidation").isPresent()){
                    Find.Object("navMensDrawerValidation").click();
                    Report.pass("User clicks on the Men links from TopNav of PA");
                }else{
                    Report.fail("Men is not Available in the TOPNAV menu in PA");
                }
                break;
            case"HOME":
                if (Find.Object("navHomedrawerValidation").isPresent()){
                    Report.pass("User Clicks on the HOME field at the TopNav from PA");
                    Find.Object("navHomedrawerValidation").click();
                }else{
                    Report.fail("HOME from TopNav of the HomePage is NOT available");
                }

            default:
                Report.dataFail("TopNav Links from HomePage is not available");
        }

    }

//    @Override
//    public void clickMiniBag() throws Exception {
//        if (Find.Object("miniBag_YA_topNavSign").isPresent()) {
//            Report.pass("Minibag was found");
//            Find.Object("miniBag_YA_topNavSign").click();
//        } else {
//            Report.fail("Minibag was not found");
//        }
//    }

    @Override
    public void clickMinibag() throws Exception {

    }

    @Override
    public void closeMiniBag() throws Exception {
        Find.Object("pageTop").mouseClick();
    }
}
