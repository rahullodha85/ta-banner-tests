package com.hbcd.banner.commomplatform.fullsite.Order;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.WaitFor;
import org.apache.jackrabbit.commons.query.qom.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ephung on 9/21/16.
 */
public class OrderHappyPath {

    ScenarioRetailDomain _base = null;


    String _scenarioType = "UNREG";
    boolean _isRegister = false;
    List<Item> _listItem = new ArrayList<>();
    List<Tender> _listTender = new ArrayList<>();
    Account _account = null; //new Account();
    Account _shopRunnerAccount = null;
    List<Address> _listShippingAddress = new ArrayList<>(); //new Address();
    ShipMethod _shippingMethod = null;


    public OrderHappyPath(ScenarioRetailDomain sb) {
        _base = sb;
    }

    public OrderHappyPath(ScenarioRetailDomain sb, String scnType) {
        _base = sb;
        _scenarioType = scnType;
    }



    public OrderHappyPath setItem(Item i) {
        _listItem.add(i);
        return this;
    }

    public OrderHappyPath setItemList(List<Item> il) {
        for (Item i : il)
        {
            _listItem.add(i);
        }
        return this;
    }

    public OrderHappyPath setShippingAddress(Address a) {
        _listShippingAddress.add(a);
        return this;
    }

    public OrderHappyPath setAddressList(List<Address> al) {
        for (Address a : al)
        {
            _listShippingAddress.add(a);
        }
        return this;
    }


    public OrderHappyPath setTender(Tender t) {
        _listTender.add(t);
        return this;
    }

    public OrderHappyPath setTenderList(List<Tender> tl) {
        for (Tender t : tl) {
            _listTender.add(t);
        }
        return this;
    }

    public OrderHappyPath setShippingMethod(ShipMethod sm)
    {
        _shippingMethod = sm;
        return this;
    }

    public OrderHappyPath setShopRunnerAccount(Account a)
    {
        _shopRunnerAccount = a;
        return this;
    }

    public OrderHappyPath setRegisterUserAccount(Account a)
    {
        _account = a;
        return this;
    }

    public boolean CheckOut(String styp) throws Exception
    {
        _scenarioType = styp;
        return CheckOut();

    }

    public boolean CheckOut() throws Exception
    {
        return commonHappyPath();
    }

    private boolean RegisterCheckout() throws Exception {
        if (_account == null) {
            Log.Info("Please assigned account to Register Checkout");
        }
        return commonHappyPath();
    }

    private boolean UnRegisterCheckout() throws Exception {
        return commonHappyPath();
    }

    private boolean ShopRunnerCheckout() {
        return false;
    }

    private boolean passLoginShopRunner()
    {
        if (_shopRunnerAccount != null) {
            try {
                ValidatePdp.hasShoprunner();
                _base.pdp.ClickShopRunnerSignin();
                _base.shr.ShopRunnerLoginWith(_shopRunnerAccount.getLogin(), _shopRunnerAccount.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void passPayment()
    {
        try {
            Collections.sort(_listTender, (left, right) -> left.getPriority() - right.getPriority());
            for (Tender t : _listTender)
            {
                switch (t.getTenderType()) {
                    case "MC" :
                    case "SMC":
                    case "VISA":
                    case "AMEX":
                    case "DISC":
                    case "JCB":
                    case "CUP":
                    case "DINERS":
                        _base.pap.ApplyCreditCard(t.getTenderType(),
                                t.getCardHolderName(),
                                t.getCardNumber(),
                                t.getCardSecurityCode(),
                                t.getExpireMonth(),
                                t.getExpireYear());
                        break;
                    case "SAKS":
                        _base.pap.ApplyHouseCard(
                                t.getTenderType(),
                                t.getCardHolderName(),
                                t.getCardNumber());
                    case "GIFTCARD":
                            _base.pap.AddGiftcard(t.getCardNumber(),t.getCardPinNumber());
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void passAddingAddress()
    {
        try {
            ValidateShippingBilling.hasUserlandedOnShippingAndBilling("Shipping & Billing");
            for (Address a : _listShippingAddress) {
                    _base.shp.AddShippingAddress(false, a.getLine1(), a.getState(),
                            a.getCity(), a.getZipCode(), false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void passShippingAndBilling(boolean isRegisterUser) {
        try {
            if (isRegisterUser) {
                _base.bag.ClickCheckout().LoginWith(_account.getLogin(),
                        _account.getPassword());
            } else {
                _base.bag.ClickCheckout().ClickGuestCheckout();
                passAddingAddress();
                passPayment();
                _base.pap.ClickCheckout();
                selectShippingMethod();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectShippingMethod()
    {
        if (_shippingMethod != null)
        {
            try {
                _base.rsp.ClickEditShippingMethod(_shippingMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private boolean addItemToBag()
    {
        boolean firstTime = true;
        boolean returnStatus = false;
        try {
            for(Item item : _listItem)
            {
                _base.nav.SearchFor(item.getUPC());
                if (firstTime)
                {
                    passLoginShopRunner();
                    firstTime = false;
                }
                _base.pdp.AddToBag(
                        item.getQuantity(),
                        item.getColorSwatchIndex(),
                        item.getSizeOrDenominationSwatchIndex());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnStatus;
    }

    private boolean commonHappyPath() throws Exception
    {
        boolean returnStatus = false;
        try {
            addItemToBag();
            _base.pdp.EnterBag();
//            WaitFor.Object("bp_LineItemPrice_ep").untilContainTextChange("Item Total:");
            passShippingAndBilling(_account != null);
            _base.rsp.ClickPlaceOrder();
            ValidateConfirmation.isThankYouPage();
            returnStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return returnStatus;
    }
}
