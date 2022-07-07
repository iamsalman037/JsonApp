package com.thenewboston.jsonapp;

/**
 * Created by SAM on 3/18/2018.
 */

public class JSonModel {
    private String offer_names;
    private String offer_types;
    private String offers_btns;
    private String gender;

    public JSonModel(String offer_name, String offer_type, String addr, String gend) {
        offer_names=offer_name;
        offer_types=offer_type;
        offers_btns=addr;
        gender=gend;

    }
    public String getOffer_names()
    {
        return offer_names;
    }
    public String getOffer_types()
    {
        return offer_types;
    }
    public String getOffers_btns()
    {
        return offers_btns;
    }
    public String getGender()
    {
        return gender;
    }
}






