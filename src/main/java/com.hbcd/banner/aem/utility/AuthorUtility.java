package com.hbcd.banner.aem.utility;

import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;
import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;
import java.awt.*;

/**
 * Created by gbagga on 1/14/2016.
 */
public class AuthorUtility  {

    /**
     * Creating new base page at current location
     * @param pageName
     * @throws Exception
     */
     public static void createHBCBasePage(String pageName) throws Exception {
         System.out.println("\n creating HBCBasePage");

         Thread.sleep(1000);
         Find.Object("cp_createNewPage").click();
         Thread.sleep(1000);

         String ss = BrowserAction.screenshot();
         Report.pass("Screen shot", ss);

         Find.Object("cp_selectCreatePage").click();
         Thread.sleep(1000);

         ss = BrowserAction.screenshot();
         Report.pass("Screen shot", ss);

         Find.Object("cp_selectTemplate").click();
         Thread.sleep(3000);

         ss = BrowserAction.screenshot();
         Report.pass("Screen shot", ss);

         Find.Object("cp_clickNext").click();
         Thread.sleep(1000);

         ss = BrowserAction.screenshot();
         Report.pass("Screen shot", ss);

         Find.Object("cp_enterName").input(pageName);
         Thread.sleep(1000);


         Find.Object("cp_enterTitle").input(pageName);
         Thread.sleep(1000);

         ss = BrowserAction.screenshot();
         Report.pass("Screen shot", ss);

         Find.Object("cp_clickCreate").click();
         Thread.sleep(1000);
         Find.Object("cp_clickDone").click();
         Thread.sleep(2000);

         ss = BrowserAction.screenshot();
         Report.pass("Screen shot page", ss);

     }

    public static void createHBCHomePage(String pageName) throws Exception {
        System.out.println("\n creating HBCBasePage");

        Thread.sleep(1000);
        Find.Object("cp_createNewPage").click();
        Thread.sleep(1000);

        String ss = BrowserAction.screenshot();
        Report.pass("Screen shot", ss);

        Find.Object("cp_selectCreatePage").click();
        Thread.sleep(1000);

        ss = BrowserAction.screenshot();
        Report.pass("Screen shot", ss);

        Find.Object("cp_homePageTemplate").click();

        Thread.sleep(3000);

        ss = BrowserAction.screenshot();
        Report.pass("Screen shot", ss);

        Find.Object("cp_clickNext").click();
        Thread.sleep(1000);

        ss = BrowserAction.screenshot();
        Report.pass("Screen shot", ss);

        Find.Object("cp_enterName").input(pageName);
        Thread.sleep(1000);


        Find.Object("cp_enterTitle").input(pageName);
        Thread.sleep(1000);

        ss = BrowserAction.screenshot();
        Report.pass("Screen shot", ss);

        Find.Object("cp_clickCreate").click();
        Thread.sleep(1000);
        Find.Object("cp_clickDone").click();
        Thread.sleep(2000);

        ss = BrowserAction.screenshot();
        Report.pass("Screen shot page", ss);

    }

    public static void createHBCOverlayPage(String pageName) throws Exception {
         // enter level logic at this page
        System.out.println("\n creating HBCOverlayPage");

        Find.Object("cp_createNewPage").click();
        Thread.sleep(1000);
        Find.Object("cp_selectCreatePage").click();
        Thread.sleep(1000);
        Find.Object("cp_selectTemplate_Overlay").click();
        Thread.sleep(3000);
        Find.Object("cp_clickNext").click();
        Thread.sleep(1000);
        Find.Object("cp_enterName").input(pageName);
        Thread.sleep(1000);
        Find.Object("cp_enterTitle").input(pageName);
        Thread.sleep(1000);
        Find.Object("cp_clickCreate").click();
        Thread.sleep(1000);
        Find.Object("cp_clickDone").click();
        Thread.sleep(2000);
    }

    /**
     *
     * @param username
     * @param password
     * @throws Exception
     */
    public static void login(String username, String password) throws Exception {
        Thread.sleep(1000);
        Find.Object("lgn_Userid").input(username);
        Thread.sleep(1000);
        Find.Object("lgn_Passwd").input(password);
        Thread.sleep(1000);
        Find.Object("lgn_Submit").click();
        Thread.sleep(1000);
        String ss = BrowserAction.screenshot();
        Report.log("login", "Login Successful", "pass", ss);
        Thread.sleep(3000);
    }

    public static void deletePage(String pageName) throws Exception {
        javax.jcr.Session session = null;
        Node x = null;
        //String pagename = "none";

        try {

            // Create a connection to the CQ repository running on local host
            String Url = Storage.get("url");
            String user = Storage.get("username");
            String pass = Storage.get("password");
            //pagename = Storage.get("Sanity_Test_Author");

            System.out.println("Vars : " + user + " " + pass + " " + Url);
            String repo = Url.concat("/crx/server");
            //Repository repository =
            Repository repository = JcrUtils.getRepository(repo);

            // Create a Session
            session = repository.login(new SimpleCredentials(user, pass.toCharArray()));

            // Create a node that represents the root node
            Node root = session.getRootNode();
            String pageparent = "/content/sof/";

            pageparent = pageparent.concat(pageName);

            x = session.getNode(pageparent);

            System.out.println("Nodename : " +x.getName());

            x.remove();
            session.save();

            Report.pass("Deleted page - " + pageName);

        } catch (Exception e1) {
            e1.printStackTrace();
            Report.log("Error while executing Script", "Failed",
                    "NO screenshots", "");
            Report.fail("Script failed - Could not delete" + pageName, "");

        }
    }

    /**
     *  Click checkbox of component and click on Open button
     * @param componentName - OR name of component
     * @throws Exception
     */
    public static void openComponent(String componentName) throws Exception {
        Thread.sleep(1000);
        Find.Object(componentName).click();
        Thread.sleep(3000);

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot before opening page", ss);

        Find.Object("ep_openPage").click();

        Thread.sleep(50000);
        Switch.toNewWindow("AEM Content Finder");
        Frame[] test = Frame.getFrames();

        Thread.sleep(10000);
        Switch.toFrame("cq-cf-frame");
        Thread.sleep(35000);
    }

    /**
     *
     */
    public static void addPromoHeader(String prehead, String heading, String subheading, String desc) throws Exception {
        Thread.sleep(5000);
        Switch.toNewWindow("AEM Content Finder");
        Frame[] test = Frame.getFrames();
        Thread.sleep(5000);

        Switch.toFrame("cq-cf-frame");
        Thread.sleep(5000);

        // Open side kick by double clicking
        Find.Object("ep_promo_overlay_page_content_box").click();
        Thread.sleep(3000);

        Find.Object("ep_promo_overlay_page_content_box").doubleClick();
        Thread.sleep(3000);

       // Add Promo Header
        Find.Object("ep_sidekick_PromoHeader").click();
        Thread.sleep(3000);
        Find.Object("ep_sidekickOKNew").click();

        // Edit Promo Header
        //ObjectProperties container = new ObjectProperties("container");
        //container.setID("ep_promo_overlay_edit_button");
        Find.Object("ep_promo_overlay_header_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        System.out.println(html);
        Log.Info(html);
        Thread.sleep(3000);
        //ObjectProperties buttonEdit = new ObjectProperties("EditButton");
        //buttonEdit.setTagName("button");
        //buttonEdit.setContainsText("Edit");
        Use.CapturedObject("My_Container").FindObject("ep_promo_overlay_edit_button").storeAs("editContainer");
        Use.CapturedObject("My_Container").FindObject("ep_promo_overlay_edit_button").click();
        String html1 = Use.CapturedObject("editContainer").AsIs().getAttribute("innerHTML").value();
        System.out.println(html1);

        ObjectProperties container = new ObjectProperties("container");
        container.setClassName("x-window x-window-plain x-resizable-pinned");
        Find.Object(container).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        //System.out.println(html);
        Log.Info(html);

        Frame[] test1 = Frame.getFrames();
        Thread.sleep(5000);

        Switch.toFrame("cq-gen235");

        Find.Object("ep_promo_overlay_edit_head").storeAs("container");
        String html2 = Use.CapturedObject("container").AsIs().getAttribute("innerHTML").value();
        System.out.println(html2);
        Log.Info(html2);

        Find.Object("ep_promo_overlay_edit_head").input("Description");
        Thread.sleep(5000);

        // Add Promo Body
        // Edit Promo Body
        // Add Promo Footer
        // Edit Promo Footer

    }

    public static void addPromoBody(String componentName) throws Exception {
        Thread.sleep(1000);
        Find.Object(componentName).click();
        Thread.sleep(1000);
    }

    public static void addPromoFooter(String componentName) throws Exception {
        Thread.sleep(1000);
        Find.Object(componentName).click();
        Thread.sleep(1000);
    }

    /*
        Adding and populating the promoMessageText in Promo Detail box
     */
    public static void addEdit_promoMessageText_In_PromoDetail(String componentName) throws Exception {
        Thread.sleep(1000);
        AuthorUtility.openComponent(componentName);

        // Open Side kick
        Thread.sleep(3000);
        Find.Object("ep_promo_overlay_page_content_box").click();

        Thread.sleep(3000);
        Find.Object("ep_promo_overlay_page_content_box").doubleClick();

        Thread.sleep(3000);

        // Add Promo Message Text component from side kick
        Find.Object("ep_sidekick_PromoMessageText").click();
        Thread.sleep(3000);
        Find.Object("ep_sidekickOKNew").click();
        Thread.sleep(3000);
        // Click on Edit button of added component
        Find.Object("ep_promo_detail_header_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        System.out.println(html);
        Log.Info(html);
        Thread.sleep(3000);
        //ObjectProperties buttonEdit = new ObjectProperties("EditButton");
        //buttonEdit.setTagName("button");
        //buttonEdit.setContainsText("Edit");
        Use.CapturedObject("My_Container").FindObject("ep_promo_overlay_edit_button").storeAs("editContainer");
        Use.CapturedObject("My_Container").FindObject("ep_promo_overlay_edit_button").click();
        String html1 = Use.CapturedObject("editContainer").AsIs().getAttribute("innerHTML").value();
        System.out.println(html1);

        Thread.sleep(4000);

        Find.Object("ep_promoDetailComponent_PromoMessageStart").input("Promo Message Start");

        Thread.sleep(1000);
        Find.Object("ep_promoDetailComponent_PromoMessageStart").input("Promo Message Start");

        Thread.sleep(1000);

        Find.Object("ep_promoDetailComponent_PromoMessageMiddle").input("Promo Message Middle");

        Thread.sleep(1000);

        Find.Object("ep_promoDetailComponent_PromoMessageEnd").input("Promo Message End");

        Thread.sleep(1000);

        //Find.Object("ep_promoDetailComponent_Tab_Link_Type").click();

        ObjectProperties buttonEdit = new ObjectProperties("EditButton");
        buttonEdit.setID("ext-comp-1078__ext-comp-1092");
        //buttonEdit.setContainsText("Edit");
        Find.Object(buttonEdit).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        System.out.println(html);
        Find.Object(buttonEdit).click();
        Log.Info(html);
        Thread.sleep(10000);

        //Find.Object("ep_promoDetailComponent_OverlayURL").javascriptInput("/content/sof/test_base_page/1_test_promo_overlay_page");
        Find.Object("ep_promoDetailComponent_OverlayURL").input("/content/sof/test_base_page/1_test_promo_overlay_page");


        Find.Object("ep_promoDetailComponent_LinkLabel").input("Link Label 1");

        //Find.Object("ep_promoDetailComponent_Ok_button").click();

        ObjectProperties inner = new ObjectProperties("EditButton");
        inner.setClassName("x-btn-text");
        inner.setTagName("button");
        Use.CapturedObject("My_Container").FindObject(inner).storeAs("editContainer");
//      Use.CapturedObject("My_Container").FindObject("ep_promo_overlay_edit_button").click();
        html1 = Use.CapturedObject("editContainer").AsIs().getAttribute("innerHTML").value();
        System.out.println(html1);

        Thread.sleep(10000);

        // Edit Promo Message

    }

    /**
     *  Click checkbox of component and click on Open button
     * @param componentName - OR name of component
     * @throws Exception
     */
    public static void navigateIntoComponent(String componentName) throws Exception {
        Thread.sleep(1000);
        Find.Object(componentName).click();
        Thread.sleep(1000);
    }

    public static void sitesSwitchToCardView() throws Exception {
        Thread.sleep(2000);
        Find.Object("cp_clickSites").click();
        Find.Object("cp_clickGeometrixxDemo").click();
        Thread.sleep(3000);
        Find.Object("ep_changeLayout").click();
        Thread.sleep(3000);
    }


    public static void selectAddComponentFromSideKick(String componentProperty) throws Exception {
        String ss;
        Thread.sleep(4000);
        Find.Object(componentProperty).click();
        ss = BrowserAction.screenshot();
        Report.pass("Screenshot before" + componentProperty + "added ", ss);
        Find.Object("ep_sidekickOKNew").click();
        Thread.sleep(4000);
        ss = BrowserAction.screenshot();
        Report.pass("Screenshot after" + componentProperty +  "component added ", ss);
    }
}