package com.hbcd.testscript.s5a.aem.author.login;


import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;


@SuppressWarnings("serial")
public class loginDataDriven extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {

//        for (int i=1; i <= 2; i++) {
//            System.out.println("Login : " + InputData.get("login").select(i));
//            System.out.println("Password :" + InputData.get("password").select(i));
//            Find.Object("lgn_Userid").input(InputData.get("login").select(i));
//            Find.Object("lgn_Passwd").input(InputData.get("password").select(i));
//            Find.Object("lgn_Submit").click();
//
//            Find.Object("login_user").click();
//            Thread.sleep(2000);
//            String ss = BrowserAction.screenshot();
//            Report.pass("Login Success - ADMIN", ss);
//            BrowserAction.deleteAllCookies();
//
//            ObjectProperties or = new ObjectProperties("test");
//            or.setLinkText("Sign Out");
//            Find.Object(or).click();
//
//        }
//
//        for (int i=3; i <= InputData.get("login").size(); i++) {
//            System.out.println("Login : " + InputData.get("login").select(i));
//            System.out.println("Password :" + InputData.get("password").select(i));
//            Find.Object("lgn_Userid").input(InputData.get("login").select(i));
//            Find.Object("lgn_Passwd").input(InputData.get("password").select(i));
//            Find.Object("lgn_Submit").click();
//
//            Find.Object("login_user").click();
//            Thread.sleep(2000);
//            String ss = BrowserAction.screenshot();
//            Report.pass("Login Failed with wrong credentials", ss);
//
//            BrowserAction.deleteAllCookies();
//        }

    }
}
