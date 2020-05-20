package com.example.foodjidelivery.FragmentClass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodjidelivery.R;
import com.google.inject.internal.util.$Objects;

public class Home extends Fragment {


    View rootview;
    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_home, container , false);

//
//        Here Show all oder assigned to this delivery boy in a recycler view
//                cardview in reccycler view shoul be such that it reveals all necessary info for a delivery
//                delivery boy should deliver to that address
//                expandable recycler view is more prefarable like whenevr tap on any item it expand and show all details
//        for now assigned system is not there
//        assign by postman and then try
//        info can be found by user/me where you get all oder assigned to that delivery boy and show it


        return rootview;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("FOODJI ADMIN");
    }

}
