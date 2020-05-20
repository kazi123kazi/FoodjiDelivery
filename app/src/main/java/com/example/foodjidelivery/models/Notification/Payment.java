package com.example.foodjidelivery.models.Notification;

import com.google.gson.annotations.SerializedName;

public class Payment {
    @SerializedName("status")
    private String status;
    @SerializedName("method")
    private String method;
    @SerializedName("total")
    private int total;

    public Payment(String status , String method , int total) {
        this.status = status;
        this.method = method;
        this.total = total;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
