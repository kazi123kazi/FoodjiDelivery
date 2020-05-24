package com.example.foodjidelivery.FragmentClass;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodjidelivery.AllOrderAdapter;
import com.example.foodjidelivery.R;
import com.example.foodjidelivery.models.Notification.NotifyResponse;
import com.example.foodjidelivery.models.Order;
import com.example.foodjidelivery.viewmodels.OrdersViewModel;
import com.google.inject.internal.util.$Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Home extends Fragment {


    OrdersViewModel ordersViewModel;
   AllOrderAdapter adapter;
    List<NotifyResponse> orders;
    RecyclerView orderRecView;


    View rootview;
    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_home, container , false);

        orderRecView=rootview.findViewById(R.id.allOrders);



        ordersViewModel = ViewModelProviders.of(getActivity()).get(OrdersViewModel.class);

        ordersViewModel.init();


        ordersViewModel.getUserRepository().observe(getActivity(), new Observer<List<NotifyResponse>>() {
            @Override
            public void onChanged(List<NotifyResponse> notifyResponses) {

                if (notifyResponses!= null) {

                  //  Log.i("Ordersss:", String.valueOf(responseUser.getUser().getOrders().get(0).getFoodList().get(0).getFoodName()));
                    adapter = new AllOrderAdapter(getActivity());
                    orders=new ArrayList<>(notifyResponses.size());
                    orders=notifyResponses;
                    Collections.reverse(orders);
                    adapter.setOrders(orders);
                    orderRecView.setAdapter(adapter);

                }

                adapter.notifyDataSetChanged();
            }
        });

        orderRecView.setLayoutManager(new GridLayoutManager(
                getActivity(), 1));
        //SETTING up recyclerview
        setupRecyclerView();





        return rootview;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("ASSIGNED ORDERS");

    }

    public void setupRecyclerView() {

        if (adapter == null) {

            orderRecView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

            orderRecView.setAdapter(adapter);

        }
        else {
            adapter.notifyDataSetChanged();
        }

    }

}
