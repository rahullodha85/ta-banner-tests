package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.commonbanner.base.pages.AccountPaymentPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Use;

/**
 * Created by 461967 on 3/31/2016.
 */
public class mAccountPaymentPage extends AccountPaymentPageBase {
    @Override
    public void IsAccountsPaymentPage() throws Exception {
        if (Find.Object("payMeth_Title").isPresent()) {
            Report.pass("User is on Accounts Payment Page");
        } else {
            Report.fail("User is not on Accounts Payment Page");
        }
    }

    @Override
    public void PaymentNamePresent(int index) throws Exception {
        if (Find.MultipleObjects("payMeth_PayCard").select(index).isPresent()) {
            Find.MultipleObjects("payMeth_PayCard").select(index).storeAs("temp");
            if (Use.CapturedObject("temp").FindObject("payMeth_Name").isPresent()) {
                Report.pass("Payment method name is present on Accounts Payment Page");
            } else {
                Report.fail("Payment method name is not present on Accounts Payment Page");
            }
        } else {
            Report.dataFail("Payment method is not present on Accounts Payment Page");
        }
    }

    @Override
    public void IsDefaultPayment(int index) throws Exception {
        if (Find.MultipleObjects("payMeth_PayCard").select(index).isPresent()) {
            Find.MultipleObjects("payMeth_PayCard").select(index).storeAs("temp");
            if (Use.CapturedObject("temp").FindObject("payMeth_Default").isPresent()) {
                Report.pass("Selected payment method is default payment method for this user");
            } else {
                Report.dataFail("Selected payment method is not default payment method for this user");
            }
        } else {
            Report.dataFail("Payment method is not present on Accounts Payment Page");
        }
    }

    @Override
    public void EditButtonPresent(int index) throws Exception {
        if (Find.MultipleObjects("payMeth_PayCard").select(index).isPresent()){
            Find.MultipleObjects("payMeth_PayCard").select(index).storeAs("temp");
            if(Use.CapturedObject("temp").FindObject("payMeth_Edit").isPresent()) {
                Report.pass("Edit button is present on Payment Method");
            } else {
                Report.fail("Payment method page does not have Edit button");
            }
        } else {
            Report.fail("Payment method is not present on Accounts Payment Page");
        }
    }

    @Override
    public void DeleteButtonPresent(int index) throws Exception {
        if (Find.MultipleObjects("payMeth_PayCard").select(index).isPresent()){
            Find.MultipleObjects("payMeth_PayCard").select(index).storeAs("temp");
            if(Use.CapturedObject("temp").FindObject("payMeth_Delete").isPresent()) {
                Report.pass("Delete button is present on Payment Method");
            } else {
                Report.fail("Payment method page does not have Delete button");
            }
        } else {
            Report.fail("Payment method is not present on Accounts Payment Page");
        }
    }

    @Override
    public void ClickEdit(int index) throws Exception {
        if (Find.MultipleObjects("payMeth_PayCard").select(index).isPresent()) {
            Find.MultipleObjects("payMeth_PayCard").select(index).storeAs("temp");
            if (Use.CapturedObject("temp").FindObject("payMeth_Edit").isPresent()) {
                Report.pass("Edit button found and clicked");
                Use.CapturedObject("temp").FindObject("payMeth_Edit").click();
            } else {
                Report.fail("Payment method page does not have Edit button");
            }
        } else {
            Report.fail("Payment method is not present on Accounts Payment Page");
        }
    }
}
