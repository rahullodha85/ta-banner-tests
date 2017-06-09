package com.hbcd.testscript.s5a.omsOrder;

import com.hbcd.banner.commomplatform.fullsite.Order.Account;
import com.hbcd.banner.commomplatform.fullsite.Order.OrderHappyPath;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.InputData;

import static com.hbcd.banner.commomplatform.fullsite.Order.DataUtility.readAddress;
import static com.hbcd.banner.commomplatform.fullsite.Order.DataUtility.readItem;
import static com.hbcd.banner.commomplatform.fullsite.Order.DataUtility.readTender;

/**
 * Created by ephung on 9/21/16.
 */
public class Scen01 extends ScenBase {

    protected String _scenarioNumber = "01";
    //Build List Item.

//    @Override
//    public void executeScript() throws Exception {
//        _scenarioNumber = InputData.get("OMS_Scenario_List").selectSequential();
//        new OrderHappyPath(this)
//                .setShopRunnerAccount(new Account()
//                        .setLogin("saks-test@shoprunner.com")
//                        .setPassword("test1234")
//                )
//                .setItemList(readItem(_scenarioNumber))
//                .setAddressList(readAddress(_scenarioNumber))
//                .setTenderList(readTender(_scenarioNumber))
//                .CheckOut();
//    }


//                .setItem(
//                    new Item("0499932227409")
//                        //.setUPC(InputData.get("OMS_Scenario1_Item_UPC").selectSequential())
//                        //.setUPC("0499932227409")
//                        .setQuantity(1)
//                        .setColorSwatchIndex(0)
//                        .setSizeOrDenominationSwatchIndex(3)  //Size or Denomination
//                )
//                .setShippingAddress(
//                    new Address()
//                        .setLine1("13 W 49th Street")
//                        .setCity("New York")
//                        .setState("New York")
//                        .setZipCode("10017")
//                )
//                .setTender(
//                        new Tender()
//                            .setType("MC")  //Master
//                            .setCardHolderName("Hello World")
//                            .setCardNumber("5444009999222205")
//                            .setExpireMonth("12")
//                            .setExpireYear("2020")
//                        .setCardSecurityCode("212")
//                )
//                .setTender( //Gift Card Tender
//                    new Tender().setType("GIFTCARD").setCardNumber("6022990000112519").setCardPinNumber("4630")
//                )

}
