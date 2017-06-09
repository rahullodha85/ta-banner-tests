package com.hbcd.banner.s5a.pages;


import com.hbcd.banner.commomplatform.fullsite.pages.ShippingPage;
import com.hbcd.banner.s5a.overlays.s5a_AddressOverlay;
import com.hbcd.banner.s5a.overlays.s5a_QASOverlay;
import com.hbcd.commonbanner.overlays.AddressOverlay;
import com.hbcd.commonbanner.overlays.QASOverlay;

public class s5a_ShippingPage extends ShippingPage {
    @Override
    public QASOverlay ClickCheckoutOptionalAddressConfirmation() throws Exception {
        super.ClickCheckoutOptionalAddressConfirmation();
        return new s5a_QASOverlay();
    }

    @Override
    public AddressOverlay ClickEditShippingAddress() throws Exception {
        super.ClickEditShippingAddress();
        return new s5a_AddressOverlay();
    }
}
