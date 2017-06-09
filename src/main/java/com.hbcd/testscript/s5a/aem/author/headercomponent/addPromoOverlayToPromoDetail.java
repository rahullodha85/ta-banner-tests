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
public class addPromoOverlayToPromoDetail extends ScenarioAEMAuthor {

    @Override
    public void executeScript() throws Exception {
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));

        if (true) {
            Find.Object("cp_clickSites").click();
            Thread.sleep(1000);
            Find.Object("ep_changeLayout").click();
            Thread.sleep(3000);
            Find.Object("cp_clickGeometrixxDemo").click();
            Thread.sleep(3000);
            AuthorUtility.navigateIntoComponent("cp_navigate_in_test_base_page");
            // Open Promo Details Page 1 and add the promo overlay page 1 in it
            //AuthorUtility.openComponent("ep_select_test_promo_details_page_1");
            AuthorUtility.addEdit_promoMessageText_In_PromoDetail("ep_select_test_promo_details_page_1");
            // Open Promo Details Page 1 and add the promo overlay page 1 in it
            //AuthorUtility.openComponent("ep_select_test_promo_details_page_1");
            //AuthorUtility.addPromoHeader("Pre head", "Head", "Sub head", "Description");

        } else
        // Create Overlay details page
        {
            AuthorUtility.createHBCBasePage("test_base_page");
            Find.Object("ep_changeLayout").click();
            Thread.sleep(5000);
            Find.Object("cp_navigate_in_test_base_page").click();
            Thread.sleep(5000);
            AuthorUtility.createHBCOverlayPage("test_promo_detail_overlay_page_1");
            AuthorUtility.createHBCOverlayPage("test_promo_detail_overlay_page_2");
        }

        String ss = BrowserAction.screenshot();
        Report.pass("Created test page", ss);
    }
}
