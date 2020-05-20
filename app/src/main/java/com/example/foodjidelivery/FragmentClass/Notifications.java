package com.example.foodjidelivery.FragmentClass;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodjidelivery.OrdersAdapter;
import com.example.foodjidelivery.R;
import com.example.foodjidelivery.models.Notification.NotifyResponse;
import com.example.foodjidelivery.models.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notifications extends Fragment {

    public Notifications() {
        // Required empty public constructor
    }

    View rootView;
    Toolbar toolbar;
    OrdersAdapter adapter;
    RecyclerView orderRecView;
    List<NotifyResponse> viewList= new ArrayList<>();
    public static Gson gson = new Gson();
    SharedPreferences preferences;
    public  String json;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_notifications , container , false);
        preferences = getActivity().getSharedPreferences("org.example.foodie" , MODE_PRIVATE);
        orderRecView = rootView.findViewById(R.id.allOrders);


/*
            toolbar=findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Orders");
*/

        getPrefernce(preferences);

        if (viewList != null) {

            orderRecView = rootView.findViewById(R.id.allOrders);

            adapter = new OrdersAdapter(getActivity());
            //      orderRecView.setLayoutManager(new GridLayoutManager(
            //            OrdersActivity.this, 1));
            //SETTING up recyclerview
            Collections.reverse(viewList);
            adapter.setOrders(viewList);
            orderRecView.setLayoutManager(new GridLayoutManager(getActivity() , 1));
            orderRecView.setAdapter(adapter);
            setupRecyclerView();

        }

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("FOODJI ADMIN");
    }




    public  void getPrefernce(SharedPreferences sharedPreferences) {


        if (viewList.isEmpty()) {

            json = sharedPreferences.getString("orderItems", null);
            String id = sharedPreferences.getString("rest_id", null);
            if (json != null) {
                Type type = new TypeToken<List<NotifyResponse>>() {
                }.getType();
                viewList = gson.fromJson(json, type);
            }


        }


    }




    public  void saveData(SharedPreferences sharedPreferences) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        json = gson.toJson(viewList);
        editor.putString("orderItems", json);
        //editor.putString("rest_id", .rest_id);
        editor.commit();
    }


    public void setupRecyclerView() {

        if (adapter == null) {


        } else {
            adapter.notifyDataSetChanged();
        }

    }
}
