package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_QuickLookOverLay;
import com.hbcd.banner.commomplatform.fullsite.pages.ProductArrayPage;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/6/2016.
 */
public class LT_ProductArrayPage extends ProductArrayPage {
    @Override
    public void RefineBy(String refineType,String refineBy) throws Exception {
        String value=refineType+": All";
        String parentId=refineType.toLowerCase()+"-multiselect";
        New.Object("").setProperty(Type.PropertyType.ID, (refineType.toLowerCase()))
                .setChildProperty(Type.PropertyType.ATTRIBUTE_KEY1,"value")
                .setChildProperty(Type.PropertyType.VALUE, value)
                .javascriptClick();

        Find.Object("refineDropDown_wk").changeChildContainsText(refineBy).click();
        Find.Object("refineApplyBtn_wk").javascriptClick();
        Thread.sleep(2000L);
    }

    @Override
    public QuickLookOverLay ClickQuickView(String upc) throws Exception {
        super.ClickQuickView(upc);
        return new LT_QuickLookOverLay();
    }
}
