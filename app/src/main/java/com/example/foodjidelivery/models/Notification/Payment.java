package com.example.foodjidelivery.models.Notification;

public class Payment {
    private String status;
    private String method;
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
