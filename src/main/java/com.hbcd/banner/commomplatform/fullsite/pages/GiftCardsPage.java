package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.GiftCardsPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 6/1/2016.
 */
public class GiftCardsPage extends GiftCardsPageBase {
    @Override
    public void VirtualGiftCardAddToBag(String SendersName, String RecipientsName, String RecipientEmail, String ConfirmRecipientsEmail, String Message, String DateOfDelivery) throws Exception {
        if(Find.Object("pdpVegcAddToBag").isPresent()) {
            Report.pass("User is on virtual gift card add to bag page");
            if (Find.Object("pdpVgcRecip").isPresent()) {
                Find.Object("pdpVgcRecip").clear();
                Find.Object("pdpVgcRecip").input(RecipientsName);
            }
            if (Find.Object("pdpVgcSender").isPresent()) {
                Find.Object("pdpVgcSender").clear();
                Find.Object("pdpVgcSender").input(SendersName);
            }
            if (Find.Object("pdpVgcNotifyEmail").isPresent()) {
                Find.Object("pdpVgcNotifyEmail").clear();
                Find.Object("pdpVgcNotifyEmail").input(RecipientEmail);
            }
            if (Find.Object("pdpVgcConfirmEmail").isPresent()) {
                Find.Object("pdpVgcConfirmEmail").clear();
                Find.Object("pdpVgcConfirmEmail").input(ConfirmRecipientsEmail);
            }
            if (Find.Object("pdpVgcDeliverDate").isPresent()) {
                Find.Object("pdpVgcDeliverDate").clear();
                Find.Object("pdpVgcDeliverDate").input(DateOfDelivery);
            }
            if (Find.Object("pdpVgcMsg").isPresent()) {
                Find.Object("pdpVgcMsg").clear();
                Find.Object("pdpVgcMsg").input(Message);
            }
            ClickAddToBag();
        }
    }

    @Override
    public void ClickAddToBag() throws Exception {
        if(Find.Object("pdpVegcAddToBag").isPresent()) {
            Find.Object("pdpVegcAddToBag").click();
        }
    }
}
