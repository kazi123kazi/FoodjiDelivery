package com.example.foodjidelivery;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodjidelivery.FragmentClass.Notifications;
import com.example.foodjidelivery.apifetch.FoodieClient;
import com.example.foodjidelivery.apifetch.ServiceGenerator;
import com.example.foodjidelivery.models.Notification.Food;
import com.example.foodjidelivery.models.Notification.NotifyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AllOrderAdapter extends RecyclerView.Adapter<AllOrderAdapter.CustomViewHolder> {
    private Context context;

    FoodListAdapter adapter;
    private List<NotifyResponse> items;
    //  private ArrayList<NEWS> subjects;
    public AlertDialog.Builder builder;




    public AllOrderAdapter(Context context) {
        this.context = context;
        // this.items = items;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.assigned_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {


        holder.total.setText(String.valueOf(getTotal(items.get(position).getFoods())));

//        holder.restaurantName.setText(items.get(position).getRestaurant().getName());

        holder.orderId.setText(items.get(position).get_id());
        holder.customerAddress.setText(items.get(position).getAddress());
        holder.customerName.setText(items.get(position).getUser().getName());
        holder.status.setText(items.get(position).getStatus());
        holder.mode.setText(items.get(position).getPayment().getMethod());
        holder.restaurantName.setText(items.get(position).getRestaurant().getName());


        if (items.get(position).getFoods()!=null) {
            adapter = new FoodListAdapter(context);
            adapter.setFood(items.get(position).getFoods());

            holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
            holder.recyclerView.setAdapter(adapter);
        }






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

        private TextView total;
        private RecyclerView recyclerView;
        private ProgressBar loader;
        private TextView customerName;
        private TextView customerAddress;
        private TextView orderId;
        private TextView status;
        private TextView mode;
        private TextView restaurantName;

        public CustomViewHolder(View view) {
            super(view);
            total=view.findViewById(R.id.total);
            recyclerView=view.findViewById(R.id.foodList);
            loader=view.findViewById(R.id.progressBar1);
            customerName=view.findViewById(R.id.customerName);
            customerAddress=view.findViewById(R.id.customerAddress);
            orderId=view.findViewById(R.id.orderId);
            status=view.findViewById(R.id.orderStatus);
            mode=view.findViewById(R.id.mode);
            restaurantName=view.findViewById(R.id.restaurantName);
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






    }


