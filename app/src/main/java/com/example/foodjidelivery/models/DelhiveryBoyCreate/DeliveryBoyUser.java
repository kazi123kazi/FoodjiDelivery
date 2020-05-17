package com.example.foodjidelivery.models.DelhiveryBoyCreate;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryBoyUser {

    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("phone")
    private String phone;
    @SerializedName("_id")
    private String _id;
    @SerializedName("orders")
    private List<String> orders;

    public DeliveryBoyUser(String name , String username , String phone , String _id , List<String> orders) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this._id = _id;
        this.orders = orders;
    }

    public DeliveryBoyUser() {
    }

    public DeliveryBoyUser(String name , String username , String password , String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
