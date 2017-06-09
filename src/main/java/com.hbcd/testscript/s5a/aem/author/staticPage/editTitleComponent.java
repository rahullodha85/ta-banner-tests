package com.hbcd.testscript.s5a.aem.author.staticPage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.core.Use;
import com.hbcd.utility.entity.ObjectProperties;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editTitleComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

        //cq-element-flexi_95hero_95par_47title
        Find.Object("ep_titleComponentStaticPage").doubleClick();
        ObjectProperties or = new ObjectProperties("test");
        or.setName("./jcr:title");
        Find.Object(or).input("test");

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();
    }
}
