package com.hbcd.testscript.s5a.aem.author.staticPage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editSimpleImageComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        //AuthorUtility.openComponent("ep_selectPage");

        Thread.sleep(1000);
        Find.Object("ep_selectPage").click();
        Thread.sleep(3000);

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot before opening page", ss);

        Find.Object("ep_openPage").click();

        Thread.sleep(15000);
        Switch.toNewWindow("AEM Content Finder");
        Frame[] test = Frame.getFrames();

        Thread.sleep(15000);

        Switch.toFrame("cq-cf-frame");
        Thread.sleep(15000);

        Switch.toDefaultContent();
        Switch.toFrame("cq-cf-frame");
        //Switch.toFrame();
        //Find.Object("ext_temp_id").click();

        Switch.toDefaultContent();
        ObjectProperties or = new ObjectProperties("test");
        or.setID("cq-cf-west");
        Find.Object(or).storeAs("test1");
        String html = Use.CapturedObject("test1").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        ObjectProperties or1 = new ObjectProperties("test2");
        or1.setClassName("thumb-wrap");
        Use.CapturedObject("test1").FindMultipleObjects(or1).select(2).click();
        Use.CapturedObject("test1").FindMultipleObjects(or1).select(2).storeAs("test3");
        //Use.CapturedObject("test1").FindMultipleObjects(or1).select(2).dragToTargetFrame("cq-cf-frame").releaseOn("ext_temp_id");
        Switch.toFrame("cq-cf-frame");
        Thread.sleep(3000);
        Use.CapturedObject("test3").AsIs().dragDrop("ext_temp_id");


        ObjectProperties or3 = new ObjectProperties("test3");
        or3.setID("ext-comp-1306");

        or = new ObjectProperties("test");
        //or.setClassName(" cq-cft-dataview");
        Switch.toFrame(1);
        or = new ObjectProperties("test");
        or.setID("cq-cf-wrapper");
        //or.setID("cfTab-Images-QueryBox");
        Find.Object(or);
        //click();

        or.setID("cq-cf-west");
        //or.setID("cq-cf-wrapper");
        Find.MultipleObjects(or).select(1).storeAs("My_Container");
         html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
         or1 = new ObjectProperties("test");
        or1.setClassName("thumb-wrap");
        Use.CapturedObject("My_Container").FindMultipleObjects(or1).select(1).click();

        //ObjectProperties or2 = new ObjectProperties("test");
        //or2.setID("ext-comp-1245");

        Find.Object("ep_simpleImage_edit_toolbar").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_simpleImage_edit_button").click();

        Use.CapturedObject("My_Container").FindMultipleObjects(or1).select(1).dragDrop("ep_simpleImage_dragWindow");



    }
}
