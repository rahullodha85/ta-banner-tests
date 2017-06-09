package com.hbcd.testscript.s5a.aem.author.createpage;

        import com.hbcd.banner.aem.utility.AuthorUtility;
        import com.hbcd.base.ScenarioAEMAuthor;
        import com.hbcd.scripting.core.BrowserAction;
        import com.hbcd.scripting.core.Find;
        import com.hbcd.scripting.core.Report;
        import com.hbcd.scripting.core.Storage;
        import com.hbcd.testscript.s5a.aem.author.SaksObjBean;

public class createPage extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {

        SaksObjBean sOB = new SaksObjBean();
        sOB.setEnv(Storage.get("environment"));
        String val = Storage.get("Test_Page_Name");
        System.out.println("got the value of Test Page Name : " + val);

        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        //
        Find.Object("cp_clickSites").click();
        Thread.sleep(1000);
        Find.Object("cp_clickGeometrixxDemo").click();

        AuthorUtility.createHBCBasePage(val);
        AuthorUtility.createHBCBasePage("test_delete_me");

    }
}
