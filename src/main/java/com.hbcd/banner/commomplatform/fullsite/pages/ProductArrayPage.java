package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.ProductArrayPageBase;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/6/2016.
 */
public class ProductArrayPage extends ProductArrayPageBase {
    @Override
    public void hoverFirstItem() throws Exception {
        Find.Object("prpFirstItem_wk").hover();
        //StepLogger.validate(Check., args);//
    }
    @Override
    public void ClickFirstItem() throws Exception {
        if(Find.Object("prpSelectFirstItem_AAF").isPresent()){
            Report.pass("User Clicks on First Items");
        }else{
            Report.fail("First Item in Product Array is NOT Clicked");
        }
        Find.Object("prpSelectFirstItem_AAF").click();

//	 String test;
//	 test=Find.Object("prpFirstItemClick").getText().value();
        //StepLogger.validate(Check.ObjectPresent, "pdpMainProductValidation_wk");
    }
    @Override
    public void RefineByDesigner(String designer) throws Exception {
        StepLogger.validate(Check.ObjectPresent, "prpRefineByDesigner_wk");
        Find.Object("prpRefineByDesigner_wk").click();
        Find.Object("prpRefineByDesigner_WS").changeChildContainsText(designer).click();
        StepLogger.validate(Check.ObjectPresent, "prpRefineByDesignerApply_WS");
        Find.Object("prpRefineByDesignerApply_WS").click();
        Thread.sleep(4000);
    }

    @Override
    public void RefineByLifeStyle(String lifeStyle) throws Exception {
        Find.Object("prpRefineByLifestyle_wk").javascriptClick();
        Report.pass("Click on " + lifeStyle, BrowserAction.screenshot());
        Thread.sleep(2000);
        Find.Object("prpLifeStyleCheckbox_wk").click();
        Report.pass("User Clicks on " + lifeStyle);
        Thread.sleep(2000);
        Find.Object("refineApplyBtn_wk").click();
        Thread.sleep(3000);
        Find.Object("refineNavLifestyleBtn_wk").javascriptClick();
    }

    @Override
    public void RefineBy(String refineType,String refineBy) throws Exception {
        String value=refineType+": All";
        String parentId=refineType.toLowerCase()+"-multiselect";
        New.Object("").setProperty(Type.PropertyType.ID, (refineType.toLowerCase()))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, value)
                .javascriptClick();
        Find.Object("refineDropDown_wk").changeChildContainsText(refineBy).javascriptClick();
        Find.Object("refineApplyBtn_wk").javascriptClick();
        Thread.sleep(2000L);
    }

    @Override
    public void RefineBySize(String size) throws Exception{
        New.Object("").setProperty(Type.PropertyType.ID, ("size"))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, "Size" + ": All")
                .javascriptClick();
        Find.Object("refineSizeSelect_wk").changeChildContainsText(size).click();
        Find.Object("refineApplyBtn_wk").changeId("size-multiselect").click();

        Thread.sleep(2000L);
    }


    @Override
    public void RefineByColor(String color) throws Exception{
        New.Object("").setProperty(Type.PropertyType.ID, ("color"))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, "Color"+": All")
                .setChildProperty(Type.PropertyIntType.USER_DEFINED_EXPLICIT_WAIT_TIME,20)
                .javascriptClick();

        Find.Object("refineColorSelect_wk").changeContainsText(color).click();
        Find.Object("refineApplyBtn_wk").changeId("color-multiselect").click();
        Thread.sleep(2000L);
    }

    @Override
    public void RefineByPrice(String price) throws Exception {
        Find.Object("prpRefineByPrice_wk").javascriptClick();
        Find.Object("prpRefinePriceCheckbox_wk").changeContainsText(price).click();
        Report.pass("User Clicks on the price range between " + price, BrowserAction.screenshot());
        Find.Object("refineApplyBtn_wk").click();
    }

    @Override
    public void SortBy(SortOptions option) throws Exception {
        Find.Object("prpNewSortByTempBtn_wk").selectByValue(option.toString());
        String selectedValue = Find.Object("prpNewSortByTempBtn_wk").getText().value();
        if(selectedValue.contains(option.toString()))
            Report.pass("Selection: "+selectedValue , BrowserAction.screenshot());
        else Report.fail("Selection: "+selectedValue , BrowserAction.screenshot());
    }

    @Override
    public void RemoveAllFilters() throws Exception {
        Find.Object("prpClearAllRefines_wk").click();
    }

    @Override
    public QuickLookOverLay ClickQuickView(String upc) throws Exception {
        Find.Object("prpSelectedQuickLook").changeId("product-" + upc).click();
        return new com.hbcd.banner.commomplatform.fullsite.overlays.QuickLookOverLay();
    }
    @Override
    public void ClickFirstQuickLook() throws Exception {
        Find.Object("pdpQuickLook_vm").javascriptClick();

    }
    @Override
    public void CloseQuickLook() throws Exception {
        Find.Object("pdpCloseOverlay_vm").click();

    }

    @Override
    public void clickVegc() throws Exception{
        Find.Object("prpClickVirtualGiftCard_WS").click();
    }
    @Override
    public void ClickQLIconOnImage() throws Exception{
        if(Find.Object("prpQLBtn_WS").isPresent()){
            Report.pass("Quick Look Icon is present");
            Find.Object("prpQLBtn_WS").click();
        }else {
            Report.systemFail("Quick look icon is NOT present",BrowserAction.screenshot());
        }
    }

    @Override
    public void ClickFirstFromTrendsEvents() throws Exception {
        if(Find.Object("paLeftNavLastGroupFirstItem_RL").isPresent()){
            Report.pass("First item from Trends And Events Found and Clicked",
                    BrowserAction.screenshot());
            Find.Object("paLeftNavLastGroupFirstItem_RL").click();
        }else {
            Report.fail("Trends and Events list do not have any items",
                    BrowserAction.screenshot());
        }
    }
}
