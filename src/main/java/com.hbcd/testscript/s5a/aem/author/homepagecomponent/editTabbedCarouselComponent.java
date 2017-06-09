package com.hbcd.testscript.s5a.aem.author.homepagecomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editTabbedCarouselComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectHomePage");

        Find.Object("ep_tabbedHeroCarousel_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_tabbedHeroCarousel_edit_button").click();

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot", ss);

        Find.Object("ep_tabbedHeroCarousel_slideURL1").clear();
        Find.Object("ep_tabbedHeroCarousel_slideURL1").input("/content/saksoff5th/en_us/tabbedcarouselslides/slide1");

        Find.Object("ep_tabbedHeroCarousel_slideURL2").clear();
        Find.Object("ep_tabbedHeroCarousel_slideURL2").input("/content/saksoff5th/en_us/tabbedcarouselslides/slide2");

        Find.Object("ep_tabbedHeroCarousel_slideURL3").clear();
        Find.Object("ep_tabbedHeroCarousel_slideURL3").input("/content/saksoff5th/en_us/tabbedcarouselslides/slide3");

        Find.Object("ep_tabbedHeroCarousel_slideURL4").clear();
        Find.Object("ep_tabbedHeroCarousel_slideURL4").input("/content/saksoff5th/en_us/tabbedcarouselslides/slide4");

        ss = BrowserAction.screenshot();
        Report.pass("Edited content container", ss);

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();
    }
}
