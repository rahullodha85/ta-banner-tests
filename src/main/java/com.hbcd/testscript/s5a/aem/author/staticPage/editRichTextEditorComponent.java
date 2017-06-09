package com.hbcd.testscript.s5a.aem.author.staticPage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editRichTextEditorComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

        //cq-element-flexi_95hero_95par_47richtext
        Find.Object("ep_RichText_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_RichText_edit_button").click();

        ObjectProperties or = new ObjectProperties("test");
        or.setClassName("x-resizable-pinned");
        Find.Object(or).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        ObjectProperties or1 = new ObjectProperties("test");
        or1.setClassName("x-btn-text");
        int size = Use.CapturedObject("My_Container").FindMultipleObjects(or1).size();
        Log.Info("Number of buttons = " + size);

        if (size == 25) {
            String ss = BrowserAction.screenshot();
            Report.pass("Number of buttons on Rich Text Editor is 23", ss);
        } else {
            String ss = BrowserAction.screenshot();
            Report.fail("Number of buttons on Rich Text Editor is not 23", ss);
        }


        //Find.Object(or).input("test");


    }
}
