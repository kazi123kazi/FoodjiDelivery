package com.example.foodjidelivery.models;

import com.example.foodjidelivery.models.Notification.NotifyResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryGuyMe {
    @SerializedName("orders")
    List<NotifyResponse> orders;

    public List<NotifyResponse> getOrders() {
        return orders;
    }
}
