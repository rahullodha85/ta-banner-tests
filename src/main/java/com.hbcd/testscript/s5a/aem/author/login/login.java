package com.hbcd.testscript.s5a.aem.author.login;


import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.scripting.core.*;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.utility.entity.ObjectProperties;


@SuppressWarnings("serial")
public class login extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        ;
            Find.Object("lgn_Userid").input(Storage.get("username"));
            Find.Object("lgn_Passwd").input(Storage.get("password"));
            Find.Object("lgn_Submit").click();

            Find.Object("login_user").click();
            Thread.sleep(2000);
            String ss = BrowserAction.screenshot();
            Report.pass("Login Success - ADMIN", ss);
            BrowserAction.deleteAllCookies();
    }
}
