package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.SectionPageBase;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/1/2016.
 */
public class SectionPage extends SectionPageBase {
    @Override
    public void ClickDresses() throws Exception {
        if(Find.Object("lnvDressesBtn").isPresent()) {
            Report.pass("Left navigation menu Dress Link found and clicked" );
            Find.Object("lnvDressesBtn").click();
        } else {
            Report.fail("Left navigation menu does not contain dress link");
        }
    }
    @Override
    public void ClickWatches()throws Exception{
        if(Find.Object("lnvWatchesBtn_wk").isPresent()){
            Report.pass("Watches Link Present", BrowserAction.screenshot());
            Find.Object("lnvWatchesBtn_wk").click();
            Report.pass("Watches Landing Page", BrowserAction.screenshot());
        }else Report.fail("Watches Link Not Found", BrowserAction.screenshot());
    }
    @Override
    public void ClickWomenHandbags() throws Exception{
        Find.Object("landingPageWomenHandBagsBtn_wk").click();
    }
    @Override
    public void ClickWomenShoes() throws Exception{
        Find.Object("landingPageWomenShoesBtn_wk").click();
    }
    @Override
    public void ClickSandals() throws Exception{
        if (Find.Object("lnvSandalsBtn_wk").isDisplayed()){
            Find.Object("lnvSandalsBtn_wk").click();
            Report.pass("User Clicks on Sandals", BrowserAction.screenshot());
        }else{
            Report.fail("Object Not Present", BrowserAction.screenshot());
        }
    }
    @Override
    public void ClickDay() throws Exception {
        if(Find.Object("lnvDayBtn").isPresent()) {
            Report.pass("Left navigation menu Day link found and clicked");
            Find.Object("lnvDayBtn").click();
        } else {
            Report.fail("Left naviation menu does not contain Day link");
        }
        if(Find.Object("productArrayCrumb_wk").isPresent()) {
            if(Find.Object("productArrayCrumb_wk").getText().value().contains("Day")) {
                Report.pass("Product array bread crum contains Day link");
            } else {
                Report.fail("Product array bread crum does not contain Day link");
            }
        } else {
            Report.systemFail("Product array bread crum is not present on product array page",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public void ClickJustKids() throws Exception {
        if (Find.Object("lnvJustKidsBtn").isDisplayed()){
            Report.pass("Click on Just Kids", BrowserAction.screenshot());
            Thread.sleep(1000);
            Find.Object("lnvJustKidsBtn").click();
        }else{
            Report.fail("Object Not Present", BrowserAction.screenshot());
        }
    }


    @Override
    public void ClickDesignerKids() throws Exception {
        Find.Object("secDesignerLeftNavLink").changeChildContainsText("KIDS").click();
        Report.pass("Kids Clicked", BrowserAction.screenshot());
    }

    @Override
    public void ClickDesignerLink() throws Exception{
        if(Find.Object("secDesignerColumn").isPresent()) {
            Find.Object("secDesignerColumn").storeAs("temp");
            String temp =Use.CapturedObject("temp")
                    .FindMultipleObjects("secDesignerRightLink")
                    .select(1).getText().value();
            Use.CapturedObject("temp")
                    .FindMultipleObjects("secDesignerRightLink").select(1).click();
            Report.pass(temp + " Link Clicked");
        } else {
            Report.fail("Designer subcategory links not found");
        }
    }
    @Override
    public void ClickSplendid() throws Exception {
        Find.Object("InvSplendidBtn").click();
        StepLogger.validate(Check.TextPresent, "LeftNavSelectBoxValidation_wk", "Splended");
    }

    @Override
    public void ClickFragnance() throws Exception {
        Find.Object("sectionLeftNavButton_wk").changeContainsText("Fragrance").click();
        Report.pass("Fragrance link from left navigation menu clicked");
    }
    @Override
    public void ClickForHer() throws Exception {
        Find.Object("PradLnvForHerBtn_wk").click();
        if(Find.Object("subLeftNavValidation_wk").isPresent()) {
            Report.pass("Left navigation links are present");
        } else {
            Report.fail("Left navigation links are not present");
        }
    }
    @Override
    public void ClickTops() throws Exception {
        Find.Object("lnvTopsBtn").click();
        Report.pass("Tops Clicked", BrowserAction.screenshot());
    }
    @Override
    public void ClickBlouses() throws Exception {
        Find.Object("lnvBlousesBtn").click();
        Report.pass("Blouses Clicked", BrowserAction.screenshot());
    }
    @Override
    public void ClickJacketsAndVests() throws Exception {
        Find.Object("lnvJacketsVestsBtn").click();
        if(Find.Object("productArrayCrumb_wk").isPresent()) {
            if(Find.Object("productArrayCrumb_wk").getText().value().contains("Jackets & Vests")) {
                Report.pass("Product array bread crum contains Jackets & Vests link");
            } else {
                Report.fail("Product array bread crum does not contain Jackets & Vests link");
            }
        } else {
            Report.systemFail("Product array bread crum is not present on product array page",
                    BrowserAction.screenshot());
        }
    }
    @Override
    public void ClickJackets() throws Exception {
        Find.Object("lnvJacketsBtn").click();
        if(Find.Object("productArrayCrumb_wk").isPresent()) {
            if(Find.Object("productArrayCrumb_wk").getText().value().contains("Day")) {
                Report.pass("Product array bread crum contains Jackets link");
            } else {
                Report.fail("Product array bread crum does not contain Jackets link");
            }
        } else {
            Report.systemFail("Product array bread crum is not present on product array page",
                    BrowserAction.screenshot());
        }
    }
    @Override
    public void ClickBlazers() throws Exception {
        Find.Object("lnvBlazersBtn").click();
        if(Find.Object("productArrayCrumb_wk").isPresent()) {
            if(Find.Object("productArrayCrumb_wk").getText().value().contains("Day")) {
                Report.pass("Product array bread crum contains Blazers link");
            } else {
                Report.fail("Product array bread crum does not contain Blazers link");
            }
        } else {
            Report.systemFail("Product array bread crum is not present on product array page",
                    BrowserAction.screenshot());
        }
    }
    @Override
    public void RefineByColor(String color) throws Exception{
        New.Object("").setProperty(Type.PropertyType.ID, ("color"))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, "Color"+": All")
                .click();
        Find.Object("refineColorSelect_wk").changeContainsText(color).click();
        Find.Object("refineApplyBtn_wk").changeId("color-multiselect").click();
        Thread.sleep(2000L);
    }
    @Override
    public void RefineBySize(String size) throws Exception{
        New.Object("").setProperty(Type.PropertyType.ID, ("size"))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, "Size"+": All")
                .click();
        Find.Object("refineSizeSelect_wk").changeChildContainsText(size).click();
        Find.Object("refineApplyBtn_wk").changeId("size-multiselect").click();
        Thread.sleep(2000L);
    }
    @Override
    public void RefineBy(String refineType,String refineBy) throws Exception {
        String value=refineType+": All";
        String parentId=refineType.toLowerCase()+"-multiselect";
        New.Object("").setProperty(Type.PropertyType.ID, (refineType.toLowerCase()))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, value)
                .click();
        Find.Object("refineDropDown_wk").changeChildContainsText(refineBy).click();
        Find.Object("refineApplyBtn_wk").click();
        Thread.sleep(2000L);
    }

    @Override
    public void SortByNewArrivals(String sortCriteria) throws Exception {
        String cssSel="li[id='"+sortCriteria+"']";
        New.Object("").setProperty(Type.PropertyType.CSS_SELECTOR, cssSel)
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.TAG_NAME, "a")
                .setChildProperty(Type.PropertyType.CONTAINS_TEXT, "APPLY")
                .click();
        Thread.sleep(2000L);
    }

    @Override
    public void ClickVests() throws Exception {
        Find.Object("lnvEventBtn_wk").changeContainsText("   Vests").click();
    }
    @Override
    public void ClickEvent(String event) throws Exception {
        Find.Object("lnvEventBtn_wk").changeChildContainsText(event).click();

    }
    @Override
    public void ClickFallCollection() throws Exception {
        Find.Object("lnvGucciFallShopCollectionBtn").click();
    }
    @Override
    public void ClickEventTitle() throws Exception{
        Find.Object("InvEventTitleLink_wk").click();
    }
    @Override
    public void ClickContemporary() throws Exception {
        Find.Object("lnvContemporaryBtn_wk").click();
        Find.Object("refineNavLifestyleBtn_wk").click();
        StepLogger.validate(Check.TextPresent, "refineLifeStyleValidation_wk", "Contemporary");
        Find.Object("refineNavLifestyleBtn_wk").click();
    }
    @Override
    public void ClickModern() throws Exception {
        Find.Object("lnvModernBtn_wk").click();
        Find.Object("refineNavLifestyleBtn_wk").click();
        StepLogger.validate(Check.TextPresent, "refineLifeStyleValidation_wk", "Modern");
    }
    @Override
    public void ClickPremierDesigner() throws Exception {
        Find.Object("lnvPremierDesignerBtn_wk").click();
        Find.Object("refineNavLifestyleBtn_wk").click();
        StepLogger.validate(Check.TextPresent, "refineLifeStyleValidation_wk", "Premier Designer");
        Find.Object("refineNavLifestyleBtn_wk").click();
    }

    /** Not implemented */public void SelectShopByDesigner(String designer) {

    }

}
