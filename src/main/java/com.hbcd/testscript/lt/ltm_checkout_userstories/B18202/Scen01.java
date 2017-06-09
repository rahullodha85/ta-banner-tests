package com.hbcd.testscript.lt.ltm_checkout_userstories.B18202;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by aalfaruk on 9/26/2016.
 * Item B-18202
 * L&TM: Display INT'L Order Details for Guest User
 * S1: As a guest customer, I can see details for my order
 GIVEN There is no dependency on site context
 AND I am a guest customer
 AND I have placed at least one order
 WHEN I enter my order number and zipcode or postal code
 THEN I can view my order details
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("Canada");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().ClickGuestCheckout();
        shp.AddInternationalShippingAddress(dataObject.getAddress1(),dataObject.getProvince(),
                dataObject.getCity(), dataObject.getZipCode(),false);
        pap.AddNewCreditCard(3);// mastercard
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
    }

}
