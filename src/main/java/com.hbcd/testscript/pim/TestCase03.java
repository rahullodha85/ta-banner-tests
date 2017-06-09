package com.hbcd.testscript.pim;

import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.utility.entity.ObjectProperties;

import java.util.List;

/**
 * Created by rashedulamin on 2/6/2017.
 */
public class TestCase03 extends ScenarioBase {

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


    }
}
