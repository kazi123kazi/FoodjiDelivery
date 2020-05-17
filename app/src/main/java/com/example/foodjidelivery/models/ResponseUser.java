package com.example.foodjidelivery.models;

import com.example.foodjidelivery.models.DelhiveryBoyCreate.DeliveryBoyUser;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseUser {


     @SerializedName("token")
     String token;

     @SerializedName("deliveryGuy")
     DeliveryBoyUser deliveryGuy;

    public ResponseUser(String token , DeliveryBoyUser deliveryGuy) {
        this.token = token;
        this.deliveryGuy = deliveryGuy;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeliveryBoyUser getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(DeliveryBoyUser deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }
}
