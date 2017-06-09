package com.hbcd.testscript.s5a.aem.author.headercomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

/**
 * Created by gbagga on 1/27/2016.
 */
public class editGlobalPromotionMessageNodeSelector extends ScenarioAEMAuthor {

    @Override
    public void executeScript() throws Exception {

        BrowserAction.start();
        BrowserAction.deleteAllCookies();

        // login
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));

        //go to edit page
        Find.Object("cp_clickSites").click();
        Thread.sleep(2000);

        Find.Object("cp_clickGeometrixxDemo").click();

        Thread.sleep(2000);
        Find.Object("ep_changeLayout").click();

        Thread.sleep(15000);
        //Find.MultipleObjects("ep_selectPage").select(1).click();

        // Open test_delete_me component
        AuthorUtility.openComponent("ep_select_test_delete_me");

        Thread.sleep(5000);

        // Test - Edit Global Promotion Header

        // Find global promotion message tool bar and click on edit button


        Find.Object("ep_globalPromotionMessage_Edit_toolbar").storeAs("container");
        String html = Use.CapturedObject("container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        try {
            Use.CapturedObject("container").FindObject("ep_globalPromotionMessage_Edit_button").click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Default content population is inheritance

        Find.Object("ep_globalPromotionContentPopulationArrow").click();
        Find.Object("ep_globalPromotionContentPopulationComboList").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_globalPromotionContentPopulationNodeSelector").click();

        try {
            Find.MultipleObjects("ep_menuNavigationPlusButton").select(1).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Find.Object("ep_globalPromotionNodeSeletorUrl").clear();
        Find.Object("ep_globalPromotionNodeSeletorUrl").input("/content/sof/en_us/Promotions/promo-win$250/jcr:content/flexi_hero_par/promodetail");


        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();

        //or = new ObjectProperties("test");
        //or.setClassName("cq-btn-ok");


//        try {
//            Find.Object("ep_globalPromoOkButton").click();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String ss = BrowserAction.screenshot();
        Report.pass("Edited Global Promotion Header component", ss);
    }
}
