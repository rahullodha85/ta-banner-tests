package com.hbcd.testscript.pim;

import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Report;
import com.hbcd.utility.entity.ObjectProperties;

import java.util.List;

/**
 * Created by rashedulamin on 2/2/2017.
 */
public class TestCase01 extends ScenarioBase {

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

    public void ValidateProductMahWorkFlowComplete(
                                             String mahMsg) throws Exception{
        if(Find.Object("PIMCOM_MAHTaskValidation").getText().value().toLowerCase().contains(mahMsg)){
            Report.fail("MAH Task Completion Time & date:" + mahMsg + "Not Verified",
                    BrowserAction.screenshot());
        }else{
            Report.pass("MAH Task Completion Time & date is Present",
                    BrowserAction.screenshot());
        }
    }

    @Override
    public void executeScript() throws Exception {
        Navigate.go("http://stagepim.digital.hbc.com/pim/webaccess");
        Find.Object("pimEmail_WS").input("rashedulamin");
        Find.Object("pimPwd_WS").input("ramin01");
        Find.Object("pimSignInBtn_WS").click();

        Thread.sleep(25000);

        Find.Object("pimTaskButton").click();
        /*Thread.sleep(20000);
        Find.Object("pimTaskInputBox").input("SAKS PC");
        Find.MultipleObjects("saksShoesTextSelection").select(8).click();
        Find.Object("saksAssignProduct").doubleClick();*/

        Find.Object("pimTaskInputBox").input("PIM Admin");
        Find.Object("pimAdminTextSelection").click();
        Thread.sleep(5000);
        Find.MultipleObjects("pimAssignProduct").select(2).doubleClick();
        Thread.sleep(10000);

        Find.Object("productSearchButton").click();
        //Find.Object("productSearchInputBox").input("0400090469805");
        Find.Object("productSearchInputBox").input("0419368240247");
        Find.Object("productFilterButton").click();

        Thread.sleep(5000);

        Find.MultipleObjects("saksProductNo").select(1).click();

        Thread.sleep(5000);

        Find.Object("saksProductNo").click();

        Thread.sleep(5000);

        ObjectProperties obj = new ObjectProperties();
        obj.setCssSelector("div[class^='v-tabsheet-tabitem']").setIsSelectedWithDisable(1).setIsSelectedWithNotVisible(1);
        Find.MultipleObjects(obj).select(6).click();

        List<String> listText = Find.MultipleObjects(obj).getAttributes("outerHTML");

        String nameSearch = "Quality status";
        int currentIndex = 0;
        currentIndex = searchAndClickOnTab(currentIndex, nameSearch, listText);

        Thread.sleep(10000L);

        Find.Object("pimDropDown").click();

        Find.Object("pimDropDownButton").doubleClick();
        Find.Object("pimDropDownButton").click();
        Find.MultipleObjects("pimDropBanner").select(1).click();

        Thread.sleep(5000);

        if(Find.MultipleObjects("PIMF2S7_BannerMAHStatus").select(2).getText().value().contains("OK")){
            Report.pass("MAH Status is GREEN. Move Forward with Next test");

        }else{
            Find.MultipleObjects("PIMCOM_ClassifyButton").select(4).click();
            Thread.sleep(5000);
            Find.Object("PIMCOM_ClassifyDropDownButton").click();
            Thread.sleep(5000);
            Find.Object("PIMCOM_MAHDropdownSelection").click();
            Find.Object("PIMCOM_MasterAttributeHierchiSelection").click();
            Find.Object("PIMCOM_MasterAttributionHierarchySelection").click();
            Find.Object("PIMCOM_MAHProductsArray").click();
            Find.Object("PIMCOM_MAHProdFroup35_Baby&Kids").click();
            Find.Object("PIMCOM_MAHProdGroup35_Girls").click();

        }

        nameSearch = "Saks Workflow";
        currentIndex = searchAndClickOnTab(currentIndex, nameSearch, listText);
        Thread.sleep(5000);
        ValidateProductMahWorkFlowComplete("No content");
    }

































}
