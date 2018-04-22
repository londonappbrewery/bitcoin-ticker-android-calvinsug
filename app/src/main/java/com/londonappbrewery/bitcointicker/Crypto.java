package com.londonappbrewery.bitcointicker;

import com.google.gson.annotations.SerializedName;

public class Crypto {

    private String type = "Bitcoin";

    @SerializedName("last")
    private float price = 0;

    public float getPrice() {
        return price;
    }
}
