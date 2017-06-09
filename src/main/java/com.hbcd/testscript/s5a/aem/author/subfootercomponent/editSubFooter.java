package com.hbcd.testscript.s5a.aem.author.subfootercomponent;

import java.awt.Frame;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

public class editSubFooter extends ScenarioAEMAuthor {
	@Override
	public void executeScript() throws Exception {
		BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

        // Sub Footer edit toolbar refactor

        Find.Object("ep_subfooter_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        Use.CapturedObject("My_Container").FindObject("ep_subfooter_edit_button").click();

        Thread.sleep(3000);
        Find.Object("ep_headingText").input("Heading Text");
        Find.Object("ep_textfieldText").input("Text Field Text");
        Find.Object("ep_linkText").input("/content/saks/en_us");
        Find.Object("ep_linklabelText").input("Link Label Text");
        Find.Object("ep_imagePath0").input("/content/dam/saks/Saks_rewards_card.png");
        Find.Object("ep_imageAltText0").input("Image ALT text");
        Find.Object("ep_checkEnableTab").click();

        // SRE Tag optional field
        // Image overflow checkbox - name="./imageOverflow1"
        // Link Behavior combo box - "Open link in New Window" and "Open link in Same window"

        Thread.sleep(2000);

        //Find.Object("ep_imageAndtextTab2").click();
        //Find.Object("ep_imageAndtextTab2_new").click();
       // ObjectProperties or = new ObjectProperties("test");
        //or.setClassName("x-tab-panel-header-plain");

        Find.Object("ep_subFooterWindowTabParent").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        //or.setClassName("x-tab-right");

        Use.CapturedObject("My_Container").FindMultipleObjects("ep_subFooterWindowTabGenericTab");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        Use.CapturedObject("My_Container").FindMultipleObjects("ep_subFooterWindowTabGenericTab").select(2).click();

        Thread.sleep(2000);

        Find.Object("ep_headingText1").input("Heading Text");
        Find.Object("ep_textfieldText1").input("Text Field Text");
        Find.Object("ep_linkText1").input("/content/saks/en_us");
        Find.Object("ep_linklabelText1").input("Link Label Text");
        Find.Object("ep_imagePath1").input("/content/dam/saks/020915_COLLECTION_VINCE_02.jpg");
        Find.Object("ep_imageAltText1").input("Image ALT text");

        String ss = BrowserAction.screenshot();
        Report.pass("Screen shot", ss);
        Thread.sleep(2000);

        Find.Object("ep_subFooterWindowTabParent").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_subFooterWindowTabGenericTab").select(3).click();

        //Find.Object("ep_emailsignupTab").hover();
        //Find.Object("ep_emailsignupTab").click();

        Find.Object("ep_labelText").input("Heading Text");
        Find.Object("ep_defaultlabelText").input("Default Label Text");
        // Gurpreet - this might be removed
        // Find.Object("ep_submissionlabelText").input("Submission Text");
        //  Gurpreet - TargetLabelText got removed
        //Find.Object("ep_targetLabelText").input("Target Label");
        Find.Object("ep_InputLabelText").input("Input Label Text");

        Find.Object("ep_emailsignupSucessMessage").input("Email signup Sucessful");
        Find.Object("ep_emailsignupErrorMessage").input("Email Signup failed");
        Find.Object("ep_invalidEmailErrorMessage").input("Invalid Email");

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot", ss);

        Thread.sleep(2000);

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();

        Thread.sleep(3000);
        ss = BrowserAction.screenshot();
        Report.pass("Updated Subfooter component", ss);

        // add code here to add header various components

		Thread.sleep(3000);
	}
}
