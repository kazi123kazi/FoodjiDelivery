package com.example.foodjidelivery.models.DeliveryBoyLogIn;

import com.google.gson.annotations.SerializedName;

public class DeliveryBoytUser {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public DeliveryBoytUser(String username , String password) {
        this.username = username;
        this.password = password;
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
}
