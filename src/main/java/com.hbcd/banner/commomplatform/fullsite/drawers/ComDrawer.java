package com.hbcd.banner.commomplatform.fullsite.drawers;

import com.hbcd.commonbanner.base.drawers.DrawerBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import org.apache.poi.util.SystemOutLogger;

/**
 * Created by 461967 on 6/8/2016.
 */
public class ComDrawer extends DrawerBase {
    protected void clickFromLinkInsideDrawer(String objectName, String linkText) throws Exception{
        Thread.sleep(1000);
        int i=0;
        while(!Find.Object("yapAccountDrpDwn").isPresent())
        {
            Find.Object("conMyAccountBtn").hover();
            if(Find.Object(objectName).changeChildPartialLinkText(linkText).isPresent()) {
                Report.pass(linkText + " link found ", BrowserAction.screenshot());
                Find.Object(objectName).changeChildPartialLinkText(linkText).click();
                break;
            }
            else
            i=i+1;

            if(i>10) {
                Report.fail(linkText + " link NOT found ", BrowserAction.screenshot());
                break;
            }
            }
        Find.Object(objectName).changeChildPartialLinkText(linkText).click();


    }

}
