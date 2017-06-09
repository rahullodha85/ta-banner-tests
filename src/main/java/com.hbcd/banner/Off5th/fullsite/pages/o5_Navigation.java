package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.Navigation;
import com.hbcd.banner.commomplatform.fullsite.pages.StoreLocatorPage;
import com.hbcd.banner.s5a.pages.s5a_StoreLocator;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;


/**
 * Created by 461967 on 6/1/2016.
 */
public class o5_Navigation extends Navigation {
    @Override
    public void SearchFor(String value) throws Exception {
        closeMiniBag();
        Find.Object("ofm_navSearchBox_wk").click();
        Find.Object("SearchItemFieldTxtBx").clear();
        Find.Object("SearchItemFieldTxtBx").input(value);
        //Find.Object("SearchItemFieldTxtBx").enter();
        Report.pass("Search For " + value, BrowserAction.screenshot());
        Find.Object("SearchItemFieldTxtBx").submit().getPerformance("SUBMIT on Search Button", "SearchFunction");
    }

    @Override
    public StoreLocatorPage ClickStoreLocator() throws Exception {
        super.ClickStoreLocator();
        return new s5a_StoreLocator();
    }

    @Override
    public void ClickTopNavLink(String link) throws Exception{

        switch (link){
            case "DESIGNERS":{
                if(Find.Object("o5Designers_AAF").isPresent()){
                    Report.pass("User Clicks " + link + " From TopNavigation from HomePage");
                    Find.Object("o5Designers_AAF").click();
                }else{
                    Report.fail("Top Nav is NOT available");
                }
            }
            break;

            case "WOMEN":{
                if(Find.Object("o5Women_AAF").isPresent()){
                    Report.pass("User Clicks " + link + " from Top Navigation from HomePage");
                    Find.Object("o5Women_AAF").hover();
                    ClickDresses();
                }else{
                    Report.fail("Top Nav is NOT available");
                }

            }
            break;
            case "SHOES & BAGS":{
                if (Find.Object("o5aShoesAndbags_AAF").isPresent()){
                    Report.pass("User Clicks " +link+ " from Topnavigation from HomePage");
                    Find.Object("o5aShoesAndbags_AAF").hover();
                    ClickShoes();
                }else{
                    Report.fail("Top Nav is NOT available");
                }
            }
            break;
            case "JEWELRY & ACCESSORIES":{
                if(Find.Object("o5aJwelAndAcces_AAF").isPresent()){
                    Report.pass("User Clicks " + link+" from TopNav from HomePage");
                    Find.Object("o5aJwelAndAcces_AAF").hover();
                    ClickFineFashionJewelry();
                }else{
                    Report.fail("Top Nav is not Available");
                }
            }
            break;
            case "MEN":{
                if (Find.Object("o5aMen_AAF").isPresent()){
                    Report.pass("User Clicks "+link+" from TopNav from HomePage");
                    Find.Object("o5aMen_AAF").hover();
                    ClickApparel();
                }else{
                    Report.fail("Top Nav is NOT available");
                }
            }
            break;
            default: {
                Report.dataFail("The Top Nav is NOT available");
            }
        }
    }

    @Override
    public void SelectCountry(String country) throws Exception{
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
    }

    private static void ClickDresses() throws Exception{
        if(Find.Object("clickNavFlyoutLinks_AAF").isPresent()){
            Report.pass("User Clicks on Section header of Nav flyout block");
            Find.Object("clickNavFlyoutLinks_AAF").click();
        }else{
            Report.fail("Header Nav Flyout is NOT available");
        }
    }

    private static void ClickShoes() throws Exception{
        if(Find.Object("o5aShoes_AAF").isPresent()){
            Report.pass("User Clicks on Shoes");
            Find.Object("o5aShoes_AAF").click();
        }else {
            Report.fail("Header Nav Flyout is NOT available");
        }
    }

    private static void ClickFineFashionJewelry()throws Exception{
        if (Find.Object("o5aFinefashionJwel_AAF").isPresent()){
            Report.pass("User Clicks on Fine Fashion Jwelery");
            Find.Object("o5aFinefashionJwel_AAF").click();
        }else{
            Report.fail("Fine Fashion jwelery is NOT available");
        }
    }

    private static void ClickApparel()throws Exception{
        if(Find.Object("o5aApparel_AAF").isPresent()){
            Report.pass("User Clicks on Apparel");
            Find.Object("o5aApparel_AAF").click();
        }else{
            Report.fail("Appreal is NOT available");
        }
    }
}
