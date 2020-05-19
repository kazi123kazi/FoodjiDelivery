package com.example.foodjidelivery.models.Notification;

import java.util.List;

public class NotifyResponse {
       Restaurant restaurant;
       User user;
       DeliveryGuy deliveryGuy;
       String address;
       Payment payment;
       String status;
       String _id;
       List<Food> foods;  //each item is food object

    public NotifyResponse(Restaurant restaurant , User user , DeliveryGuy deliveryGuy , String address , Payment payment , String status , String _id , List<Food> foods) {
        this.restaurant = restaurant;
        this.user = user;
        this.deliveryGuy = deliveryGuy;
        this.address = address;
        this.payment = payment;
        this.status = status;
        this._id = _id;
        this.foods = foods;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DeliveryGuy getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(DeliveryGuy deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
//{
//        "restaurant": {
//        "_id": "string",
//        "name": "string"
//        },
//        "user": {
//        "_id": "string",
//        "name": "string"
//        },
//        "deliveryGuy": {
//        "_id": "string"
//        },
//        "address": "string",
//        "payment": {
//        "status": "string",
//        "total": 0,
//        "method": "string"
//        },
//        "status": "string",
//        "_id": "string",
//        "foods": [
//        {
//        "quantity": 0,
//        "_id": "string",
//        "price": 0,
//        "name": "string"
//        }
//        ]
//        }