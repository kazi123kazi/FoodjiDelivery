package com.example.foodjidelivery.models.DeliveryBoyLogIn;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseDeliveryBoy {

    @SerializedName("_id")
    private String _id;

    @SerializedName("name")
    private String name;

    @SerializedName("orders")
    private List<String> orders;

    private String  phone;
    private String  username;

    public ResponseDeliveryBoy(String _id , String name , List<String> orders , String phone , String username) {
        this._id = _id;
        this.name = name;
        this.orders = orders;
        this.phone = phone;
        this.username = username;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
