package com.hbcd.testscript.pim;


import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.entity.ObjectProperties;

/**
 * Created by rashedulamin on 2/10/2017.
 */
public class SampleTest extends ScenarioBase {

    @Override
    public void executeScript() throws Exception {
        Navigate.go("http://stagepim.digital.hbc.com/pim/webaccess");
        Find.Object("pimEmail_WS").input("rashedulamin");
        Find.Object("pimPwd_WS").input("ramin01");
        Find.Object("pimSignInBtn_WS").click();

        Thread.sleep(25000);

        Find.Object("pimTaskButton").click();
        //Thread.sleep(20000);
        Find.Object("pimTaskInputBox").input("SAKS PC");
        Find.MultipleObjects("saksShoesTextSelection").select(8).click();
        Find.Object("saksAssignProduct").doubleClick();
        Thread.sleep(10000);
        Find.Object("productSearchButton").click();
        Find.Object("productSearchInputBox").input("0400090469805");
        Find.Object("productFilterButton").click();
        Thread.sleep(5000);
        Find.MultipleObjects("saksProductNo").select(1).click();
        Thread.sleep(5000);

        ObjectProperties obj = new ObjectProperties();
        obj.setCssSelector("div[class^='v-tabsheet-tabitem']").setIsSelectedWithDisable(1).setIsSelectedWithNotVisible(1);
        Find.MultipleObjects(obj).select(2).click();

        Find.Object("PIMF3S7_TuneIn_Task2_Assignment").click();
        Find.MultipleObjects("PIMCOM_DropDownButton").select(2).click();
        Thread.sleep(10000);
        Find.Object("PIMF3S7_SelectTuneIN").click();

    }
}
