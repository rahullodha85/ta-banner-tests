package com.hbcd.testscript.pim;
import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Report;
import com.hbcd.utility.entity.ObjectProperties;

import java.util.List;

/**
 * Created by rashedulamin on 1/6/2017.
 */
public class Scen02 extends ScenarioBase {

    //Scen01 scen01;

    protected int findIndexContain(String name, List<String> l)
    {
        int indx = -1;
        for (String n : l)
        {
            indx++;
            if (n.contains(name))
            {
                break;
            }
        }
        return indx;
    }

    protected int searchAndClickOnTab(int currentIndex, String nameSearch, List<String> allTabName) throws Exception {
        int searchIndex = -1;
        ObjectProperties button = new ObjectProperties();

        searchIndex = findIndexContain(nameSearch, allTabName);
        if (searchIndex > currentIndex) //move forward
        {
            button.setCssSelector("button[class='v-tabsheet-scrollerNext']");
        }
        else {
            button.setCssSelector("button[class='v-tabsheet-scrollerPrev']");
        }

        ObjectProperties objVisibleOnly = new ObjectProperties();
        objVisibleOnly.setCssSelector("div[class^='v-tabsheet-tabitem']");

        for (int i=0; i < allTabName.size(); i++)
        {

            if (Find.Object(button).isPresentDisplayedEnabled()) {
                Find.Object(button).click();
                if (Find.MultipleObjects(objVisibleOnly).selectItemContainText(nameSearch).isPresentDisplayedEnabled())
                {
                    if (Find.Object(button).isPresentDisplayedEnabled()) {
                        Find.Object(button).click();
                    }
                    Find.MultipleObjects(objVisibleOnly).selectItemContainText(nameSearch).click();
                    searchIndex = i;
                    break;
                }
            } else {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    public void ValidateSaksWorkFlowComplete(String workFlowMsg, String workFlowDate,
                                                    String mahMsg, String tuneInMsg) throws Exception{
        if(Find.Object("saksWF_TypeValidation").getText().value().toLowerCase().contains(workFlowMsg)){
            Report.pass("WorkFlow Type:" + workFlowMsg + "Verified",
                    BrowserAction.screenshot());
        }else{
            Report.fail("WorkFlow Type is not Present",
                    BrowserAction.screenshot());
        }

        if(Find.Object("saks_proWF_EnterValidation").getText().value().toLowerCase().contains(workFlowDate)){
            Report.pass("Product Entered Workflow:" + workFlowDate + "Verified",
                    BrowserAction.screenshot());
        }else{
            Report.fail("Product Entered Workflow is not Present",
                    BrowserAction.screenshot());
        }

        if(Find.Object("saks_MAH_Task_Validation").getText().value().toLowerCase().contains(mahMsg)){
            Report.pass("MAH Task Completion Time & date:" + mahMsg + "Verified",
                    BrowserAction.screenshot());
        }else{
            Report.fail("MAH Task Completion Time & date is not Present",
                    BrowserAction.screenshot());
        }

        if(Find.MultipleObjects("saks_TuneIn_Validation").select(2).getText().value().toLowerCase().contains(tuneInMsg)){
            Report.pass("Saks TuneIn Complete :" + tuneInMsg + "Is Verified",
                    BrowserAction.screenshot());
        }else{
            Report.fail("Saks TuneIn Complete is not Present",
                    BrowserAction.screenshot());
        }

    }

    @Override
        public void executeScript() throws Exception {
        Navigate.go("http://stagepim.digital.hbc.com/pim/webaccess");
        Find.Object("pimEmail_WS").input("rashedulamin");
        Find.Object("pimPwd_WS").input("ramin01");
        Find.Object("pimSignInBtn_WS").click();
        Thread.sleep(10000);
        Find.Object("pimTaskButton").click();
        //Thread.sleep(20000);
        Find.Object("pimTaskInputBox").input("SAKS PC - Shoes");
        Find.MultipleObjects("saksShoesTextSelection").select(6).click();
        Find.Object("saksAssignProduct").doubleClick();
        Thread.sleep(10000);
        Find.Object("productSearchButton").click();
        Find.Object("productSearchInputBox").input("0402323769273");
        Find.Object("productFilterButton").click();
        Thread.sleep(5000);
        Find.MultipleObjects("saksProductNo").select(1).click();
        Thread.sleep(5000);

        ObjectProperties obj = new ObjectProperties();
        obj.setCssSelector("div[class^='v-tabsheet-tabitem']").setIsSelectedWithDisable(1).setIsSelectedWithNotVisible(1);
        Find.MultipleObjects(obj).select(6).click();

        List<String> listText = Find.MultipleObjects(obj).getAttributes("outerHTML");

        String nameSearch = "Quality status";
        int currentIndex = 0;
        currentIndex = searchAndClickOnTab(currentIndex, nameSearch, listText);

        Thread.sleep(10000);
        Find.Object("pimDropDown").click();
        Find.Object("pimDropDownButton").doubleClick();
        Find.Object("pimDropDownButton").click();
        Find.Object("pimDropDownButton").click();
        Find.MultipleObjects("pimDropBanner").select(7).click();

        nameSearch = "Saks Workflow";
        currentIndex = searchAndClickOnTab(currentIndex, nameSearch, listText);
        Thread.sleep(5000);
        ValidateSaksWorkFlowComplete("new product","5/24/2016 12:07 pm","5/24/2016 12:08 pm","yes");

    }
}
