package com.example.foodjidelivery.models.DeliveryBoyLogIn;

import com.google.gson.annotations.SerializedName;

public class ResponseDeliveryBoyUser {
    @SerializedName("token")
    String token;
    @SerializedName("deliveryGuy")
    ResponseDeliveryBoy deliveryGuy;


    public ResponseDeliveryBoyUser(String token , ResponseDeliveryBoy deliveryGuy) {
        this.token = token;
        this.deliveryGuy = deliveryGuy;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResponseDeliveryBoy getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(ResponseDeliveryBoy deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }
}
