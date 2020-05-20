package com.example.foodjidelivery;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodjidelivery.apifetch.FoodieClient;
import com.example.foodjidelivery.apifetch.ServiceGenerator;
import com.example.foodjidelivery.models.Notification.Food;
import com.example.foodjidelivery.models.Notification.NotifyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.CustomViewHolder> {
    private Context context;

    FoodListAdapter adapter;
    private List<NotifyResponse> items;
    //  private ArrayList<NEWS> subjects;
    public AlertDialog.Builder builder;




    public OrdersAdapter(Context context) {
        this.context = context;
        // this.items = items;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.orderview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {


        holder.total.setText(String.valueOf(getTotal(items.get(position).getFoods())));

        holder.restaurantName.setText(items.get(position).getRestaurant().getName());

    if (items.get(position).getFoods()!=null) {
        adapter = new FoodListAdapter(context);
        adapter.setFood(items.get(position).getFoods());

        holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
     holder.recyclerView.setAdapter(adapter);
    }

    holder.order.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            builder=new AlertDialog.Builder(new ContextThemeWrapper(context,R.style.AlertDialogCustom));

            builder.setTitle("Are You sure You Take this order?");

            builder.setMessage("Press Yes To Continue").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    assignOrder(MainActivity.token,items.get(position).get_id(),position);



                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alert=builder.create();
            alert.show();


        }});





        //set Elements here

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOrders(List<NotifyResponse> orders) {
        this.items = orders;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

            private TextView restaurantName;
            private TextView total;
            private RecyclerView recyclerView;
            private CardView order;


        public CustomViewHolder(View view) {
            super(view);
            order=view.findViewById(R.id.order);
            restaurantName=view.findViewById(R.id.restaurantName);
            total=view.findViewById(R.id.total);
            recyclerView=view.findViewById(R.id.foodList);



        }
    }




    public int getTotal(List<Food> foods){
        int sum=0;
        if(foods!=null)
        for(int i=0;i<foods.size();i++){
            sum+=foods.get(i).getCount()*foods.get(i).getPrice();
        }
        return sum;
    }



    public void assignOrder(String token,String id,int position){

        FoodieClient foodieClient= ServiceGenerator.createService(FoodieClient.class);


        Call<NotifyResponse> call= foodieClient.assignOrder(token,id);


        call.enqueue(new Callback<NotifyResponse>() {
            @Override
            public void onResponse(Call<NotifyResponse> call, Response<NotifyResponse> response) {
                if (response.isSuccessful()){

                    Toast.makeText(context,"ASSIGNED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    Log.i("Assigned", String.valueOf(response.code()));
                    items.remove(position);
                    notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<NotifyResponse> call, Throwable t) {

            }
        });




    }


}