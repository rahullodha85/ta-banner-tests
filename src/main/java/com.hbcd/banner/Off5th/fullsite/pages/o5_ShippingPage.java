package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.Off5th.fullsite.overlays.o5_AddressOverlay_OLD;
import com.hbcd.banner.Off5th.fullsite.overlays.o5_QASOverlay;
import com.hbcd.banner.commomplatform.fullsite.pages.ShippingPage;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.overlays.QASOverlay;

/**
 * Created by 461967 on 6/7/2016.
 */
public class o5_ShippingPage extends ShippingPage {
    @Override
    public QASOverlay ClickCheckoutOptionalAddressConfirmation() throws Exception {
        super.ClickCheckoutOptionalAddressConfirmation();
        return new o5_QASOverlay();
    }

    @Override
    public AddressOverlay ClickEditShippingAddress() throws Exception {
        super.ClickEditShippingAddress();
        return new o5_AddressOverlay_OLD();
    }
}
