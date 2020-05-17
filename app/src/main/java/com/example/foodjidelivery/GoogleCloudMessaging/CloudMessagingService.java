package com.example.foodjidelivery.GoogleCloudMessaging;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CloudMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d("newToken", token);
        //Add your token in your sharepreferences.
        getSharedPreferences("registrationToken", MODE_PRIVATE).edit().putString("fcm_token", token).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d("View1", "From: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            Log.d("view2", "Notification Title: " +
                    remoteMessage.getNotification().getTitle());

            Log.d("view3", "Notification Message: " +
                    remoteMessage.getNotification().getBody());
        }

        if (remoteMessage.getData().size() > 0) {
            Log.d("view4", "Message data payload: " +
                    remoteMessage.getData().get("MyKey1"));
        }
    }
    //Whenewer you need FCM token, just call this static method to get it.
    public static String getToken(Context context) {
        return context.getSharedPreferences("registrationToken", MODE_PRIVATE).getString("fcm_token", "empty");
    }

}
