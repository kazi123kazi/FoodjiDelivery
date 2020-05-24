package com.example.foodjidelivery.Respositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.foodjidelivery.WelcomeActvity;
import com.example.foodjidelivery.apifetch.FoodieClient;
import com.example.foodjidelivery.apifetch.ServiceGenerator;
import com.example.foodjidelivery.models.DeliveryGuyMe;
import com.example.foodjidelivery.models.Notification.DeliveryGuy;
import com.example.foodjidelivery.models.Notification.NotifyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository userRepository;
    private FoodieClient foodieClient;

    public UserRepository() {
        foodieClient = ServiceGenerator.createService(FoodieClient.class);
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }

        return userRepository;

    }

    public static UserRepository getRestaurantsRepository() {
        return userRepository;
    }

    public MutableLiveData<List<NotifyResponse>> getUser() {

        MutableLiveData<List<NotifyResponse>> userData = new MutableLiveData<>();

        Call<DeliveryGuyMe> call = foodieClient.getOrders(WelcomeActvity.token);

        call.enqueue(new Callback<DeliveryGuyMe>() {
            @Override
            public void onResponse(Call<DeliveryGuyMe> call, Response<DeliveryGuyMe> response) {


                Log.i("ResponseUSER", String.valueOf(response.code()));
                if (response.isSuccessful()) {
                    userData.setValue(response.body().getOrders());

                }

            }

            @Override
            public void onFailure(Call<DeliveryGuyMe> call, Throwable t) {

                userData.setValue(null);
            }
        });


        return userData;


    }

}