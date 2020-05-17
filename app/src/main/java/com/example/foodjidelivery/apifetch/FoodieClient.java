package com.example.foodjidelivery.apifetch;

import com.example.foodjidelivery.models.ResponseUser;
import com.example.foodjidelivery.models.DelhiveryBoyCreate.DeliveryBoyCreate;
import com.example.foodjidelivery.models.DeliveryBoyLogIn.ResponseDeliveryBoyUser;
import com.example.foodjidelivery.models.DeliveryBoyLogIn.DeliveryBoytUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface FoodieClient {
    //create
    @POST("deliveryguy")
    Call<ResponseUser> createDeliveryBoy(@Body DeliveryBoyCreate deliveryBoyCreate);
    //log in user
    @POST("deliveryguy/login")
    Call<ResponseDeliveryBoyUser> logInDelivery(@Body DeliveryBoytUser deliveryBoytUser);
    //Logout restaurant
    @POST("restaurant/logout")
    Call<Void> Logout(@Header("Authorization") String token);


}
