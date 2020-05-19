package com.example.foodjidelivery.models.Notification;

import com.google.gson.annotations.SerializedName;

public class Food {
    @SerializedName("name")
    public String name;

    @SerializedName("price")
    public String price;

    @SerializedName("_id")
    String _id;

    @SerializedName("quantity")
    int count;

    public Food(String name , String price , String _id , int count) {
        this.name = name;
        this.price = price;
        this._id = _id;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
