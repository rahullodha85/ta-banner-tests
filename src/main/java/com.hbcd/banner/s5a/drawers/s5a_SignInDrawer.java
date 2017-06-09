package com.hbcd.banner.s5a.drawers;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 12/10/2015.
 */
public class s5a_SignInDrawer extends s5a_ComDrawer {
    @Override
    public void ClickFirstLink() throws Exception {
        Thread.sleep(1000);
        if(Find.Object("navSignInDrawer_RL").changeChildithElement(1).isPresent()) {
            Report.pass("Welcome/SignIn link not found and clicked",
                        BrowserAction.screenshot());
            Find.Object("navSignInDrawer_RL").changeChildithElement(1).click();
        }else{
            Report.fail("Welcome/SignIn link not found",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public void ClickLinkFromDrawer(String linkText) throws Exception {
        Thread.sleep(1000);
        if(linkText.toLowerCase().contains("sign")){
            if(Find.Object("navSignInOut_RL").changeChildithElement(1).isPresent()){
                Report.pass(linkText + " link found and clicked");
                Find.Object("navSignInOut_RL").changeChildithElement(1).click();
            }else{
                Report.fail(linkText + " link not found",
                        BrowserAction.screenshot());
            }
        }else {
            Thread.sleep(1000);
            clickFromLinkInsideDrawer("navSignInDrawer_RL", linkText);
        }
    }
}
