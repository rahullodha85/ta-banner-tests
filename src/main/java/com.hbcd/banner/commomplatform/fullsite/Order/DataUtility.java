package com.hbcd.banner.commomplatform.fullsite.Order;

import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.scripting.core.InputData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ephung on 9/26/16.
 */
public class DataUtility {


//    "Rush"),
//    STANDARD(0, "Standard"),
//    NEXTBUS(2, "Next Bus"),
//    SR2DAYFREE(4,"ShopRunner 2 Day FREE"),
//    SATURDAY(3,"Saturday");

    public static ShipMethod readShipMethod(String scenarioNumber)
    {
        ShipMethod sm = null;
        try {
            if (InputData.get(String.format("OMS_Scenario%s_Shipping_Method", scenarioNumber)).size() > 0)
            {
                String shippingMethod = InputData.get(String.format("OMS_Scenario%s_Shipping_Method", scenarioNumber)).value();
                switch (shippingMethod.toUpperCase())
                {
                    case "RUSH":
                        sm = ShipMethod.RUSH;
                        break;
                    case "STANDARD":
                        sm = ShipMethod.STANDARD;
                        break;
                    case "NEXT BUS":
                        sm = ShipMethod.NEXTBUS;
                        break;
                    case "SHOPRUNNER 2 DAY FREE":
                        sm = ShipMethod.SR2DAYFREE;
                        break;
                    case "SATURDAY":
                        sm = ShipMethod.SATURDAY;
                        break;
                }
                return sm;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sm;

    }

    public static Account readShopRunnerLogin(String scenarioNumber)
    {
        try {
            if ((InputData.get(String.format("OMS_Scenario%s_AccountShopRunner_Login", scenarioNumber)).size() > 0)
                && InputData.get(String.format("OMS_Scenario%s_AccountShopRunner_Password", scenarioNumber)).size() > 0) {
                return new Account()
                             .setLogin(InputData.get(String.format("OMS_Scenario%s_AccountShopRunner_Login", scenarioNumber)).value())
                             .setPassword(InputData.get(String.format("OMS_Scenario%s_AccountShopRunner_Password", scenarioNumber)).value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Account readAccountLogin(String scenarioNumber)
    {
        try {
            if ((InputData.get(String.format("OMS_Scenario%s_Account_Login", scenarioNumber)).size() > 0)
                    && InputData.get(String.format("OMS_Scenario%s_Account_Password", scenarioNumber)).size() > 0) {
                return new Account()
                        .setLogin(InputData.get(String.format("OMS_Scenario%s_Account_Login", scenarioNumber)).value())
                        .setPassword(InputData.get(String.format("OMS_Scenario%s_Account_Password", scenarioNumber)).value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Item> readItem(String scenarioNumber)
    {
        List<Item> li = new ArrayList<>();
        try {
            if ((InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size() ==
                    InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size())
                    &&
                    (InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size() ==
                            InputData.get(String.format("OMS_Scenario%s_Item_Color", scenarioNumber)).size())
                    &&
                    (InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size() ==
                            InputData.get(String.format("OMS_Scenario%s_Item_Size", scenarioNumber)).size())
                    &&
                    (InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size() ==
                            InputData.get(String.format("OMS_Scenario%s_Item_Quantity", scenarioNumber)).size())
                    )
            {
                for (int i=1; i <= InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size(); i++)
                {
                    li.add(new Item(InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).select(i))
                            .setColorSwatchIndex(Integer.parseInt(InputData.get(String.format("OMS_Scenario%s_Item_Color", scenarioNumber)).select(i)))
                            .setSizeOrDenominationSwatchIndex(Integer.parseInt(InputData.get(String.format("OMS_Scenario%s_Item_Size", scenarioNumber)).select(i)))
                            .setQuantity(Integer.parseInt(InputData.get(String.format("OMS_Scenario%s_Item_Quantity", scenarioNumber)).select(i)))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

    //Build Tender
    public static List<Tender> readTender(String scenarioNumber)
    {
        List<Tender> lt = new ArrayList<>();
        try {
            if ((InputData.get(String.format("OMS_Scenario%s_Tender_Type", scenarioNumber)).size() ==
                    InputData.get(String.format("OMS_Scenario%s_Item_UPC", scenarioNumber)).size())
                    &&
                    (InputData.get(String.format("OMS_Scenario%s_Tender_Type", scenarioNumber)).size() ==
                            InputData.get(String.format("OMS_Scenario%s_Tender_CardNumber", scenarioNumber)).size())
                    )

            {
                for (int i = 1; i <= InputData.get(String.format("OMS_Scenario%s_Tender_Type", scenarioNumber)).size(); i++) {
                    lt.add(new Tender(InputData.get(String.format("OMS_Scenario%s_Tender_HolderName", scenarioNumber)).select(i))
                            .setType(InputData.get(String.format("OMS_Scenario%s_Tender_Type", scenarioNumber)).select(i))
                            .setCardNumber(InputData.get(String.format("OMS_Scenario%s_Tender_CardNumber", scenarioNumber)).select(i))
                            .setCardSecurityCode(InputData.get(String.format("OMS_Scenario%s_Tender_SecurityCode", scenarioNumber)).select(i))
                            .setCardPinNumber(InputData.get(String.format("OMS_Scenario%s_Tender_Pin", scenarioNumber)).select(i))
                            .setExpireMonth(InputData.get(String.format("OMS_Scenario%s_Tender_Month", scenarioNumber)).select(i))
                            .setExpireDay(InputData.get(String.format("OMS_Scenario%s_Tender_Day", scenarioNumber)).select(i))
                            .setExpireYear(InputData.get(String.format("OMS_Scenario%s_Tender_Year", scenarioNumber)).select(i))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lt;
    }

    public static List<Address> readAddress(String scenarioNumber)
    {
        //Build Address
        List<Address> la =  new ArrayList<>();

        try {

            for (int i = 1; i <= InputData.get(String.format("OMS_Scenario%s_Address_Line1", scenarioNumber)).size(); i++) {
                la.add(new Address()
                        .setLine1(InputData.get(String.format("OMS_Scenario%s_Address_Line1", scenarioNumber)).select(i))
                        .setLine2(InputData.get(String.format("OMS_Scenario%s_Address_Line2", scenarioNumber)).select(i))
                        .setCity(InputData.get(String.format("OMS_Scenario%s_Address_City", scenarioNumber)).select(i))
                        .setState(InputData.get(String.format("OMS_Scenario%s_Address_State", scenarioNumber)).select(i))
                        .setZipCode(InputData.get(String.format("OMS_Scenario%s_Address_ZipCode", scenarioNumber)).select(i))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return la;
    }
}
