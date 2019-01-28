package com.everis.androidteste_bankapp.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.everis.androidteste_bankapp.R;
import com.everis.androidteste_bankapp.model.retrofit.ApiUtil;
import com.everis.androidteste_bankapp.model.retrofit.JsonHolder;
import com.everis.androidteste_bankapp.model.retrofit.RetrofitInitializer;
import com.everis.androidteste_bankapp.model.user.UserAccount;
import com.everis.androidteste_bankapp.model.user.UserReceive;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private TextInputEditText et_name;
    private TextInputEditText et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarVariaveis();

    }


    private void iniciarVariaveis() {

        btn_login = findViewById(R.id.btn_login);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), DataActivity.class);
                startActivity(intent);
               /* ApiUtil.getServiceClass().getUserAccount("user", "password").enqueue(new Callback<UserReceive>() {
                    @Override
                    public void onResponse(Call<UserReceive> call, Response<UserReceive> response) {

                        if (response.isSuccessful()) {
                            UserReceive userReceive = response.body();

                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<UserReceive> call, Throwable t) {

                    }
                });*/
            }
        });
    }


   /* private void userLogin () {
        String user = et_name.getText().toString().trim();
        String password = et_pass.getText().toString().trim();

        if (user.isEmpty()){
            et_name.setError("User is required");
            et_name.requestFocus();
            return;
        }

        if (password.isEmpty()){
            et_pass.setError("Password is required");
            et_name.requestFocus();
            return;
        }
    }*/
}