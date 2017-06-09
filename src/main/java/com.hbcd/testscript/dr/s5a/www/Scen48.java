package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

import java.util.Date;

/**
 * Created by ephung on 1/6/2016.
 */
public class Scen48 extends ScenarioChkout {
    public void executeScript() throws Exception{
        String item1 = dataObject.getSkuListInfo().get(1); // itemData.get(ItemType.REGULAR);

        nav.SearchFor(item1);
        if (BrowserAction.ManualValidation("Is the Image Exist?"))
        {
            Report.pass("Image Exist");
        }
        else
        {
            Report.fail("Image Does not Exist");
        }
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        shp.AddShippingAddress(false, "12 E 49th Street", "New York", "New York", "10017", false);
        pap.AddNewCreditCard(3);//mastercard
//        pap.ClickCheckout();
//        shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(),false);
        pap.ClickCheckout();
        //rsp.ClickPlaceOrder();
        conf.CreateAccount();
        conf.GoToYourAccount();
        ValidateYourAcc.ShippingAddressContains(Storage.get("shippingAddress"));
        ValidateYourAcc.BillingAddressContains(Storage.get("shippingAddress"));
        ValidateYourAcc.CreditCardContains(Storage.get("ccNumber"));

//        String timeStamp = Long.toString(new Date().getTime());
//        String loginEmail = "saksqa_" + timeStamp + "@saks.com";
    }

}
