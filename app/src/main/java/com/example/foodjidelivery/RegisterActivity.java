package com.example.foodjidelivery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.foodjidelivery.apifetch.FoodieClient;
import com.example.foodjidelivery.apifetch.ServiceGenerator;
import com.example.foodjidelivery.models.ResponseUser;
import com.example.foodjidelivery.models.DelhiveryBoyCreate.DeliveryBoyCreate;
import com.example.foodjidelivery.models.DelhiveryBoyCreate.DeliveryBoyUser;
import com.example.foodjidelivery.models.DelhiveryBoyCreate.SuperAdminUser;
import com.example.foodjidelivery.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    public static User user = new User("", "");
    public Button CreateAccountButton;
    private ProgressBar progressBar;
    public EditText InputName, InputPhoneNumber, InputPassword,DelhiveryIdInput;
    final static String username="admin";
    final static  String password="password";
    SuperAdminUser superAdminUser;
    DeliveryBoyUser deliveryBoyUser;
    DeliveryBoyCreate deliveryBoyCreate;
    List<String> contactNos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progressBar3);
        progressBar.setVisibility(View.GONE);
        initWidgets();
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                     CreateDeliveryUser();
            }
        });
        if (user.getToken() != null) {
            Log.i("ok", user.getToken());
            WelcomeActvity.getInstance().finish();
        }


    }
    public void initWidgets() {

        CreateAccountButton = (Button) findViewById(R.id.register_btn);
        InputName = (EditText) findViewById(R.id.register_name_input);
        InputPhoneNumber = (EditText) findViewById(R.id.register_phone_input);
        InputPassword = (EditText) findViewById(R.id.register_password_input);
        DelhiveryIdInput=(EditText)findViewById(R.id.register_Id_input);
    }
    public void CreateUser(String name, String email, String password, String address, String phone) {
        user = new User(name, email, password, address, phone);
    }

   public  void CreateDeliveryUser()
   {

       FoodieClient foodieClient = ServiceGenerator.createService(FoodieClient.class);
       superAdminUser=new SuperAdminUser(username,password);
       deliveryBoyUser =new DeliveryBoyUser(InputName.getText().toString(),
               DelhiveryIdInput.getText().toString(),
               InputPassword.getText().toString(),
               InputPhoneNumber.getText().toString());
       DeliveryBoyCreate deliveryBoyCreate =new DeliveryBoyCreate(superAdminUser, deliveryBoyUser);
       Call<ResponseUser> call2=foodieClient.createDeliveryBoy(deliveryBoyCreate);//just post::Response class for this should be made;
       progressBar.setVisibility(View.VISIBLE);
       call2.enqueue(new Callback<ResponseUser>() {
           @Override
           public void onResponse(Call<ResponseUser> call , Response<ResponseUser> response) {
               if (response.code() == 201) {
                   Toast.makeText(getApplicationContext() , "Success!" , Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(RegisterActivity.this, MainActivity.class);

                   intent.putExtra("token", response.body().getToken());//for further functionality need this token id
                   intent.putExtra("name",InputName.getText().toString());

                   startActivity(intent);
                   progressBar.setVisibility(View.GONE);
                   WelcomeActvity.getInstance().finish();
                   finish();
               } else {
                   Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<ResponseUser> call , Throwable t) {
               Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });

   }
}
