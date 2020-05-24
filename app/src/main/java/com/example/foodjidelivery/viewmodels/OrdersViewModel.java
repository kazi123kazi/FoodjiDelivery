package com.example.foodjidelivery.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodjidelivery.Respositories.UserRepository;
import com.example.foodjidelivery.models.Notification.NotifyResponse;


import java.util.List;

public class OrdersViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<List<NotifyResponse>> mutableLiveData;
    private UserRepository userRepository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        userRepository = new UserRepository().getInstance();
        mutableLiveData = userRepository.getUser();
    }

    public LiveData<List<NotifyResponse>> getUserRepository() {
        return mutableLiveData;
    }

}
