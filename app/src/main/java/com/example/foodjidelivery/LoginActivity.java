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
import com.example.foodjidelivery.models.DeliveryBoyLogIn.ResponseDeliveryBoy;
import com.example.foodjidelivery.models.DeliveryBoyLogIn.ResponseDeliveryBoyUser;
import com.example.foodjidelivery.models.DeliveryBoyLogIn.DeliveryBoytUser;
import com.example.foodjidelivery.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static User user = new User("", "");
    private Button LoginButton;
    private EditText InputUsername, InputPassword;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spinner = (ProgressBar) findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
        initWidgets();
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   DeliveryLogin();
            }
        });
        if (user.getToken() != null) {
            Log.i("ok", user.getToken());
            WelcomeActvity.getInstance().finish();
        }

    }

    private void DeliveryLogin() {
        FoodieClient foodieClient = ServiceGenerator.createService(FoodieClient.class);
        DeliveryBoytUser deliveryBoytUser=new DeliveryBoytUser(InputUsername.getText().toString(),InputPassword.getText().toString());
        Call<ResponseDeliveryBoyUser> call1= foodieClient.logInDelivery(deliveryBoytUser);
        spinner.setVisibility(View.VISIBLE);
        call1.enqueue(new Callback<ResponseDeliveryBoyUser>() {
            @Override
            public void onResponse(Call<ResponseDeliveryBoyUser> call , Response<ResponseDeliveryBoyUser> response) {
                if (response.code()==200) {
                    Toast.makeText(getApplicationContext() , "Success!" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),MainActivity.class);

//
                    ResponseDeliveryBoy responseDeliveryBoy=response.body().getDeliveryGuy();

                    intent.putExtra("token", response.body().getToken());
                    intent.putExtra("name",responseDeliveryBoy.getName());
                    startActivity(intent);
//                    intent.putExtra("restId",restaurantObj.getRest_id());
//                    intent.putExtra("address",restaurantObj.getAddress());
//                    startActivity(intent);
                    spinner.setVisibility(View.GONE);
                    WelcomeActvity.getInstance().finish();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseDeliveryBoyUser> call , Throwable t) {

                spinner.setVisibility(View.GONE);
                Log.d("errorMessage",t.getMessage());
            }
        });

    }

    //function to initialise all the widgets
    public void initWidgets() {
        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputUsername= (EditText) findViewById(R.id.login_username);

    }

}
