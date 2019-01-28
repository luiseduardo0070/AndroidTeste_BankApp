package com.everis.androidteste_bankapp.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.everis.androidteste_bankapp.R;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private TextInputLayout et_name;
    private TextInputLayout et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarVariaveis();
        iniciarAcao();
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
            }
        });
/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bank-app-test.herokuapp.com/api/login")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonHolder jsonHolder = retrofit.create(JsonHolder.class);
        final Call<UserAccount> call = jsonHolder.getUserAccount("user", "password");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.enqueue(new Callback<UserAccount>() {
                    @Override
                    public void onResponse(Call<UserAccount> call, Response<UserAccount> response) {
                        if (response.isSuccessful()){
                            String user = response.body().toString();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserAccount> call, Throwable t) {

                    }
                });
            }
        });*/
    }

    private void iniciarAcao() {

    }
}
