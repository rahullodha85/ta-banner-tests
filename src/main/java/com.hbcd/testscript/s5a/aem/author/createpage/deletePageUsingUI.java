package com.hbcd.testscript.s5a.aem.author.createpage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.testscript.s5a.aem.author.SaksObjBean;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

/**
 * Created by gbagga on 1/27/2016.
 */
public class deletePageUsingUI extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {

        SaksObjBean sOB = new SaksObjBean();
        sOB.setEnv(Storage.get("environment"));

        AuthorUtility.login(Storage.get("username"),Storage.get("password") );

        String ss = BrowserAction.screenshot();
        Report.pass("sucessfully login", ss);

        Find.Object("cp_clickSites").click();

        //System.out.println("Environment = " + sOB.getEnv());

        // Clicked on SOF
        Find.Object("cp_clickGeometrixxDemo").click();

        Thread.sleep(5000);

        Find.Object("ep_changeLayout").click();
        Thread.sleep(3000);
        //Find.MultipleObjects("ep_selectPage").select(1).click();
        Find.Object("ep_selectPage").click();

        Thread.sleep(3000);

//        container.setClassName("coral-Icon--more");

        Find.Object("cp_more_icon").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Find.Object("cp_more_icon").click();

//        or.setClassName("coral-Icon--delete");

        //Find.Object("ep_delete_icon").click();

        ObjectProperties or = new ObjectProperties("test");
        or.setClassName("endor-ActionBar-graniteMorePopup");
        Find.Object(or).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        or = new ObjectProperties("test");
        or.setClassName("cq-siteadmin-admin-actions-delete-activator");
        Use.CapturedObject("My_Container").FindObject(or).click();
        //Use.CapturedObject("My_Container").FindObject(or).click();

        //Find.Object("ep_delete_icon").click();

//        or.setClassName("coral-Button--warning");

        Find.Object("ep_coral_warning_button").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Find.Object("ep_coral_warning_button").click();
        Thread.sleep(3000);

        ss = BrowserAction.screenshot();
        Report.pass("Deleted test page", ss);

        Find.Object("ep_select_test_delete_me").click();

        Thread.sleep(3000);

//        container.setClassName("coral-Icon--more");

        Find.Object("cp_more_icon").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Find.Object("cp_more_icon").click();

//        or.setClassName("coral-Icon--delete");

//        Find.Object("ep_delete_icon").storeAs("My_Container");
//        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
//        Log.Info(html);
//        Find.Object("ep_delete_icon").click();

//        or.setClassName("coral-Button--warning");

         or = new ObjectProperties("test");
        or.setClassName("endor-ActionBar-graniteMorePopup");
        Find.Object(or).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        or = new ObjectProperties("test");
        or.setClassName("cq-siteadmin-admin-actions-delete-activator");
        Use.CapturedObject("My_Container").FindObject(or).click();

        Find.Object("ep_coral_warning_button").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Find.Object("ep_coral_warning_button").click();
        Thread.sleep(3000);

        ss = BrowserAction.screenshot();
        Report.pass("Deleted test page", ss);

    }
}
