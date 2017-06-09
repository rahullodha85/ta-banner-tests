package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.AccountSummaryPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Use;

/**
 * Created by 461967 on 3/7/2016.
 */
public class AccountSummaryPage extends AccountSummaryPageBase {
    @Override
    public void ClickStartShopping() throws Exception {
        if (Find.Object("accSum_StartShopping").isPresent()) {
            Report.pass("Start shopping link found and clicked");
            Find.Object("accSum_StartShopping").click();
        } else {
            Report.fail("Start shopping link is not present on Account Summary page");
        }
    }

    @Override
    public void ClickExpandCollapse(int index) throws Exception {
        if (Find.MultipleObjects("accSum_OrderRow").select(index).isPresent()) {
            Find.MultipleObjects("accSum_OrderRow").select(index).click();
        }
    }

    @Override
    public void ClickViewAllOrders() throws Exception {
        if (Find.Object("accSum_ViewAllOrders").isPresent()) {
            Report.pass("View all orders found and clicked");
            Find.Object("accSum_ViewAllOrders").click();
        } else {
            Report.fail("View all orders button is not present on account summary page");
        }
    }

    @Override
    public void ClickAccountSettings() throws Exception {
        if (Find.Object("accSum_TopNav").changeContainsText("Account Settings").isPresent()) {
            Find.Object("accSum_TopNav").changeContainsText("Account Settings").click();
            Report.pass("Account Setting tab clicked");
        } else {
            Report.fail("Account settings tab is not present on Account Summary page");
        }
    }

    @Override
    public void ClickEditProfile() throws Exception {
        if (Find.Object("accSum_EditPro").isPresent()) {
            Find.Object("accSum_EditPro").click();
            Report.pass("Edit profile button found and clicked");
        } else {
            Report.fail("Edit profile button is not present on Account Summary Page");
        }
    }

    @Override
    public void ClickAccountNav(String text) throws Exception {
        if (Find.Object("accSum_TopNav").changeContainsText(text).isPresent()) {
            Find.Object("accSum_TopNav").changeContainsText(text).click();
            Report.pass(text + " tab clicked");
        } else {
            Report.fail(text + " tab is not present on Account Top Nav");
        }
    }

    @Override
    public void IsSummaryPage() throws Exception {
        if (Find.Object("accSum_YourProfile").isPresent()) {
            Report.pass("User is on account summary page after signing in");
        } else {
            Report.fail("User is not on account summary page after signing in");
        }
    }

    @Override
    public void IsYourRewardsPresent() throws Exception {
        if (Find.Object("accSum_YourRewards").isPresent()) {
            Report.pass("Your rewards section is present on account summary page");
        } else {
            Report.fail("Your rewards section is not present on account summary page");
        }
    }

    @Override
    public void IsMoreNumberPresent(String val) throws Exception {
        if (Find.Object("accSum_MoreNumber").getText().value().contains(val)) {
            Report.pass("More Number is present on Account Summary Page");
        } else {
            Report.fail("More Number is not present on Account Summary Page");
        }
    }

    @Override
    public void IsFirstOrderPresent() throws Exception {
        if (Find.MultipleObjects("accSum_OrderDetails").select(1).isPresent()) {
            if(Find.MultipleObjects("accSum_OrderDetails")
                    .select(1).getAttribute("aria-expanded").isEqual("true")) {
                Report.pass("First order displayed in expanded mode on Account Summary Page");
            } else {
                Report.fail("First order is not displayed in expanded mode");
            }
        } else {
            Report.dataFail("This account does not have any orders");
        }
    }

    @Override
    public void OrderRowPresent(int index) throws Exception {
        if (Find.MultipleObjects("accSum_OrderRow").select(index).isPresent()) {
            Report.pass("Order Row number: " + index + " is present on Account Summary Page");
        } else {
            HasMoreThanOneOrder();
        }
    }

    @Override
    public void OrderHasOrderDate(int index) throws Exception {
        HasMoreThanOneOrder();
        Find.MultipleObjects("accSum_OrderRow").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderRowDate").isPresent()) {
            Report.pass("Order Date is present on Order Row: " + index);
        } else {
            Report.fail("Order Date is not present on Order Row: " + index);
        }
    }

    @Override
    public void OrderHasOrderNumber(int index) throws Exception {
        HasMoreThanOneOrder();
        Find.MultipleObjects("accSum_OrderRow").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderRowOrderNumber").isPresent()) {
            Report.pass("Order Number is present on Order Row: " + index);
        } else {
            Report.fail("Order Number is not present on Order Row: " + index);
        }
    }

    @Override
    public void OrderHasOrderItemCount(int index) throws Exception {
        HasMoreThanOneOrder();
        Find.MultipleObjects("accSum_OrderRow").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderRowItemCount").isPresent()) {
            Report.pass("Order Item Count is present on Order Row: " + index);
        } else {
            Report.fail("Order Item Count is not present on Order Row: " + index);
        }
    }

    @Override
    public void OrderHasOrderTotal(int index) throws Exception {
        HasMoreThanOneOrder();
        Find.MultipleObjects("accSum_OrderRow").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderRowTotal").isPresent()) {
            Report.pass("Order Total is present on Order Row: " + index);
        } else {
            Report.fail("Order Total is not present on Order Row: " + index);
        }
    }

    @Override
    public void OrderHasOrderStatus(int index) throws Exception {
        HasMoreThanOneOrder();
        Find.MultipleObjects("accSum_OrderRow").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderRowOrderStatus").isPresent()) {
            Report.pass("Order Status is present on Order Row: " + index);
        } else {
            Report.fail("Order Status is not present on Order Row: " + index);
        }
    }

    @Override
    public void HasMoreThanOneOrder() throws Exception {
        if (Find.MultipleObjects("accSum_OrderRow").size() < 2) {
            Report.dataFail("User does not have more than one order " +
                    "so second order details cannot be tested/verified");
        }
    }

    @Override
    public void OrderDetailHasShippingSection(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderShipping").isPresent()) {
            Report.pass("Order: " + index + " Order Details has shipping section displayed");
        } else {
            Report.pass("Order: " + index + "Order Details does not have shipping section displayed");
        }
    }

    @Override
    public void OrderDetailHasPaymentMethod(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderPaymentMethod").isPresent()) {
            Report.pass("Paymment Method is displayed as a part of order: " + index +
                    " Order Details on Account Summary Page");
        } else {
            Report.fail("Paymment Method is not displayed as a part of order: " + index +
                    " Order Details on Account Summary Page");
        }
    }

    @Override
    public void OrderDetailHasBillingAddress(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_BillingAddress").isPresent()) {
            Report.pass("Billing Address is displayed as a part of order: " + index +
                    " Order Details on Account Summary Page");
        } else {
            Report.fail("Billing Address is not displayed as a part of order: " + index +
                    " Order Details on Account Summary Page");
        }
    }

    @Override
    public void OrderDetailHasSummary(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderSummary").isPresent()) {
            Report.pass("Order Summary is displayed as a part of order: " + index +
                    " Order Details on Account Summary Page");
        } else {
            Report.fail("Order Summary is not displayed as a part of order: " + index +
                    " Order Details on Account Summary Page");
        }
    }

    @Override
    public void OrderDetailHasShippingMethod(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderShippingMethod").isPresent()) {
            Report.pass("Shipping Method is displayed as a part of order no.: " + index +
                    " Order Details on Account Summary Page");
        } else {
            Report.fail("Shipping Method is not displayed as a part of order no.: " + index +
                    " Order Details on Account Summary Page");
        }
    }

    @Override
    public void OrderDetailHasShippingAddress(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderShippingAddress").isPresent()) {
            Report.pass("Shipping Address is displayed as a part of order no.: " + index +
                    " Order Details on Account Summary Page");
        } else {
            Report.fail("Shipping Address is not displayed as a part of order no.: " + index +
                    " Order Details on Account Summary Page");
        }
    }

    @Override
    public void IsFullNamePresent() throws Exception {
        if (Find.Object("accSum_FullName").isPresent()) {
            Report.pass("Full Name is present on Account Summary Page");
        } else {
            Report.fail("Full Name is not present on Account Summary Page");
        }
    }

    @Override
    public void IsEmailPresent() throws Exception {
        if (Find.Object("accSum_Email").isPresent()) {
            Report.pass("Email is present on Account Summary Page");
        } else {
            Report.fail("Email is not present on Account Summary Page");
        }
    }

    @Override
    public void IsEmptyOrderHistory() throws Exception {
        if (Find.Object("accSum_EmptyOrders").isPresent()) {
            if (Find.Object("accSum_EmptyOrders").getText().value().contains("You haven’t placed an order with us!")) {
                Report.pass("Empty order history verified");
            }
        } else {
            Report.dataFail("This user appears to have order history, " +
                    "please re-run this test with a user that does not have any order-hostory");
        }
    }

    @Override
    public void IsStartShoppingLinkPresent() throws Exception {
        if (Find.Object("accSum_StartShopping").isPresent()) {
            Report.pass("Start shopping link is present on Account Summary Page");
        } else {
            Report.fail("Start shopping link is not present on Account Summary page");
        }
    }

    @Override
    public void IsViewAllOrdersPresent() throws Exception {
        if (Find.MultipleObjects("accSum_OrderRow").size() >= 5) {
            if (Find.Object("accSum_ViewAllOrders").isPresent()) {
                Report.pass("View all orders button is present on account summary page");
            } else {
                Report.fail("View all orders button is not present on account summary page");
            }
        } else {
            Report.dataFail("This account does not have more than 5 orders, " +
                    "so view all orders button will not be displayed");
        }
    }

    @Override
    public void OrderDetailHasItemContent(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindMultipleObjects("accSum_OrderItemCol").select(1).isPresent()) {
            Report.pass("Order no.: " + index + " item details displayed as expected");
        } else {
            Report.fail("Order no.: " + index + " does not display item details");
        }
    }

    @Override
    public void OrderDetailHasItemImage(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindMultipleObjects("accSum_OrderItemImg").select(index).isPresent()) {
            Report.pass("Order no.: " + index + " item image displayed as expected");
        } else {
            Report.fail("Order no.: " + index + " does not display item image");
        }
    }

    @Override
    public void OrderDetailHasStatus(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindMultipleObjects("accSum_OrderStatus").select(1).isPresent()) {
            Report.pass("Order no.: " + index + " order status displayed as expected");
        } else {
            Report.fail("Order no.: " + index + " does not display order status");
        }
    }

    @Override
    public void OrderdetailHasCustomerServiceCopy(int index) throws Exception {
        Find.MultipleObjects("accSum_OrderDetails").select(index).storeAs("temp");
        if (Use.CapturedObject("temp").FindObject("accSum_OrderCSC").isPresent()) {
            Report.pass("Order no.: " + index + " displays customer service copy as expected");
        } else {
            Report.fail("Order no.: " + index + " does not display customer service copy");
        }
    }

    @Override
    public void IsSaksFirstSectionPresent(String text) throws Exception {
        if(Find.Object("accSumSaksFirstSec_RL").isPresent()) {
            if(Find.Object("accSumSaksFirstSec_RL").getText().value().contains(text)) {
                Report.pass("Saks First section is present with expected text");
            } else {
                Report.fail("Saks First section text does not match expected text");
            }
        } else {
            Report.fail("Saks First section is not present on Account Summary page");
        }
    }

    @Override
    public void IsLinkYourSaksFirstPresent(String text) throws Exception {
        IsLinkYourSaksFirstPresent();
        if (Find.Object("accSumLinkSaksFirst_RL").getText().value().contains(text)) {
            Report.pass("Link Your Saks First button is present with expected text");
        } else {
            Report.fail("Link Your Saks First button text does not match expected text");
        }
    }

    @Override
    public void IsPrgmDetailLinkPresent() throws Exception {
        if(Find.Object("accSumPrgmDetLink_RL").isPresent()) {
            Report.pass("Program Detail Link is present with expected text");
        } else {
            Report.fail("Program Detail Link is not present on Account Summary page");
        }
    }

    @Override
    public void ClickPrgmDetailLink() throws Exception {
        IsPrgmDetailLinkPresent();
        Find.Object("accSumPrgmDetLink_RL").click();
    }

    @Override
    public void IsLinkYourSaksFirstPresent() throws Exception {
        if(Find.Object("accSumLinkSaksFirst_RL").isPresent()) {
            Report.pass("Link Your Saks First button is present on Account Summary page");
        } else {
            Report.fail("Link Your Saks First button is not present on Account Summary page");
        }
    }

    @Override
    public void ClickLinkYourSaksFirst() throws Exception {
        IsLinkYourSaksFirstPresent();
        Find.Object("accSumLinkSaksFirst_RL").click();
    }
}
