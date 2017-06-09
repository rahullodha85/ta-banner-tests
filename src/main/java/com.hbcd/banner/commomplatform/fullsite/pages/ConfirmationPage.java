package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.ConfirmationPageBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by 461967 on 6/6/2016.
 */
public class ConfirmationPage extends ConfirmationPageBase {
    @Override
    public void CancelOrder() throws Exception {

    }

    @Override
    public void CreateAccount() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "confPasswordTxt_wk");
        Find.Object("confPasswordTxt_wk").input("test123");
        Find.Object("confVerifyPasswordTxt_wk").input("test123");
        StepLogger.validate(Check.ObjectPresent, "confCreateAccountBtn_wk");
        Find.Object("confCreateAccountBtn_wk").click();
        if(Find.Object("confAccountBoxMsg_wk").getText().value().contains("unable to create your account")){
            Report.systemFail("unable to create your account", BrowserAction.screenshot());
        }

    }

    @Override
    public void GoToYourAccount() throws Exception{
        StepLogger.validate(Check.ObjectPresent, "confGoToYourAccountBtn_WS");
        Find.Object("confGoToYourAccountBtn_WS").click();
    }

    @Override
    public void EnterPassword(String createPwd, String verifyPwd) throws Exception {
        StepLogger.validate(Check.ObjectPresent, "confPasswordTxt_wk");
        Find.Object("confPasswordTxt_wk").clear();
        Find.Object("confPasswordTxt_wk").input(createPwd);
        Find.Object("confVerifyPasswordTxt_wk").clear();
        Find.Object("confVerifyPasswordTxt_wk").input(verifyPwd);
        StepLogger.validate(Check.ObjectPresent, "confCreateAccountBtn_wk");
        Find.Object("confCreateAccountBtn_wk").click();
    }

    @Override
    public void CheckConfirmation() throws Exception {

    }

    @Override
    public void ClickPrintReceipt() throws Exception {
        StepLogger.validate(Check.ObjectPresent, "cofPrintReceipt_zk");
        Find.Object("cofPrintReceipt_zk").click();

    }
}
