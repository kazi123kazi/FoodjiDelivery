package com.example.foodjidelivery.apifetch;

import com.example.foodjidelivery.models.Notification.NotifyResponse;
import com.example.foodjidelivery.models.ResponseUser;
import com.example.foodjidelivery.models.DelhiveryBoyCreate.DeliveryBoyCreate;
import com.example.foodjidelivery.models.DeliveryBoyLogIn.ResponseDeliveryBoyUser;
import com.example.foodjidelivery.models.DeliveryBoyLogIn.DeliveryBoytUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    //Notify delivery boy
    @GET("deliveryguy/notify")
    Call<List<NotifyResponse>> getNotified(@Header("Authorization") String token);
    @POST("deliveryguy/assign/{id}")
    Call<NotifyResponse> assignOrder(@Header("Authorization") String token, @Path("id") String id);




}
