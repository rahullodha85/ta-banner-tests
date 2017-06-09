package com.hbcd.testscript.s5a.aem.author.headercomponent;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.banner.aem.utility.AuthorUtility;

/**
 * Created by gbagga on 1/14/2016.
 * Create a base page
 */
public class createOverlayPage extends ScenarioAEMAuthor {

    @Override
    public void executeScript() throws Exception {

        AuthorUtility.login(Storage.get("username"), Storage.get("password"));

        if (false) {


            Find.Object("cp_clickSites").click();
            Thread.sleep(1000);
            Find.Object("ep_changeLayout").click();
            Thread.sleep(3000);
            Find.Object("cp_clickGeometrixxDemo").click();
            Thread.sleep(3000);
            AuthorUtility.navigateIntoComponent("cp_navigate_in_test_base_page");
            AuthorUtility.openComponent("ep_select_test_promo_overlay_page_1");
            AuthorUtility.addPromoHeader("Pre head", "Head", "Sub head", "Description");


        } else {
            AuthorUtility.createHBCBasePage("test_base_page");
            Find.Object("ep_changeLayout").click();
            Thread.sleep(5000);
            Find.Object("cp_navigate_in_test_base_page").click();
            Thread.sleep(5000);
            AuthorUtility.createHBCOverlayPage("1_test_promo_overlay_page");
            AuthorUtility.createHBCOverlayPage("2_test_promo_overlay_page");
            AuthorUtility.createHBCOverlayPage("3_test_promo_detail_overlay_page");
            AuthorUtility.createHBCOverlayPage("4_test_promo_detail_overlay_page");
            AuthorUtility.openComponent("ep_select_test_promo_overlay_page_1");
        }

        String ss = BrowserAction.screenshot();
        Report.pass("Created test page", ss);

    }
}
