package com.hbcd.banner.common.paypal;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class pBag {

    public void ClickPaypal() throws Exception {

        if (!Find.Object("bagPaypalBtn").isPresent()) {
            Report.systemFail("PayPal Button is not present on the Bag Page", BrowserAction.screenshot());
        }
        StepLogger.validate(Check.ObjectPresent, "bagPaypalBtn");
        Find.Object("bagPaypalBtn").click();
    }
}
