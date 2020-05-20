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
public class ContactUs extends Fragment {
    View rootview;
    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_help , container , false);
        return  rootview;
    }
}
