package com.example.foodjidelivery.FragmentClass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodjidelivery.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notifications extends Fragment {

    public Notifications() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//
//        show only notification details
//                /notify routes
//
//

        return inflater.inflate(R.layout.fragment_notifications , container , false);
    }
}
