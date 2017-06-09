package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.OrderHistoryPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;

/**
 * Created by 461967 on 3/24/2016.
 */
public class OrderHistoryPage extends OrderHistoryPageBase {
    @Override
    public void ClickExpandCollapse(int index) throws Exception {
        if (Find.MultipleObjects("ordHis_OrderRow").select(index).isPresent()) {
            Find.MultipleObjects("ordHis_OrderRow").select(index).click();
        }
    }

    @Override
    public void ClickViewMoreOrders() throws Exception {
        if (Find.Object("ordHis_ViewMoreOrders").isPresent()) {
            Find.Object("ordHis_ViewMoreOrders").click();
            Report.pass("View More Orders button found and clicked");
        } else {
            Report.fail("View More Orders button is not present on Order History Page");
        }
    }

    @Override
    public void ClickStartShopping() throws Exception {
        if (Find.Object("ordHis_StartShopping").isPresent()) {
            Find.Object("ordHis_StartShopping").click();
        }
    }

    @Override
    public void IsOrderHistoryPage() throws Exception {
        if (Find.Object("ordHis_Title").isPresent()) {
            Report.pass("User is on order history page");
        } else {
            Report.fail("User is not on order history page");
        }
    }

    @Override
    public void ViewMoreOrdersNotPresent() throws Exception {
        int orderCount = Find.MultipleObjects("ordHis_OrderRow").size();
        if (orderCount <= 10) {
            if (Find.Object("ordHis_ViewMoreOrders").isNotPresent()) {
                Report.pass("View More Orders button is not present for user with " + orderCount + " orders");
            } else {
                Report.fail("View More Orders button is present for user with " + orderCount + " orders");
            }
        } else {
            Report.dataFail("This user has more than 10 orders." +
                    " Please repeate test with a user that has 10 or less orders");
        }
    }

    @Override
    public void ViewMoreOrdersPresent() throws Exception {
        int orderCount = Find.MultipleObjects("ordHis_OrderRow").size();
        Storage.save("orderCount", orderCount);
        if (Find.Object("ordHis_ViewMoreOrders").isPresent()) {
            Report.pass("View More Orders button is not present for user with " + orderCount + " orders");
        } else if (orderCount < 10) {
            Report.dataFail("This user has less than or equal to 10 orders." +
                    " Please repeat test with a user that has more than 10 orders");
        } else {
            Report.fail("View More Orders button is present for user with " + orderCount + " orders");
        }
    }

    @Override
    public void IsOrderExpanded(int index) throws Exception {
        if (Find.MultipleObjects("ordHis_OrderDetails").select(index).isPresent()) {
            Report.pass("Order no. " + index + " is expanded as expected");
        } else {
            Report.fail("Order no. " + index + " is not expanded");
        }
    }

    @Override
    public void IsOrderCollapsed(int index) throws Exception {
        if (Find.MultipleObjects("ordHis_OrderDetails").select(index).isNotPresent()) {
            Report.pass("Order no. " + index + " is in collapsed as expected");
        } else {
            Report.fail("Order no. " + index + " is not in collapsed state");
        }
    }

    @Override
    public void VerifyMoreOrders() throws Exception {
        Thread.sleep(10000);
        int orderCount = Find.MultipleObjects("ordHis_OrderRow").size();
        if (orderCount > Integer.parseInt(Storage.get("orderCount").toString())) {
            Report.pass("More orders for this user are being displayed after View More Orders clicked");
        } else {
            Report.fail("View More Orders click action did not show More orders for this user");
        }
    }

    @Override
    public void StartShoppingPresent() throws Exception {
        if (Find.Object("ordHis_StartShopping").isPresent()) {
            Report.pass("Start shopping link is present on Order History Page");
        } else if (Find.MultipleObjects("ordHis_OrderRow").size() > 0) {
            Report.dataFail("This account has order history, " +
                    "repeat this test with an account with no order history");
        } else {
            Report.fail("Start shopping button is not present on Order History Page" +
                    " for an account with no order history");
        }
    }

    @Override
    public void CheckOrderCount(int count) throws Exception {
        int orderCount = Find.MultipleObjects("ordHis_OrderRow").size();
        if (orderCount != count) {
            Report.dataFail("This user's order history order count: " + orderCount +
                    " does not match required order count: " + count +
                    "for this test case. Please use another account that has order count = " + count);
        }
    }
}
