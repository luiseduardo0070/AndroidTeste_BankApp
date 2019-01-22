package com.everis.androidteste_bankapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        iniciarVariaveis();
        iniciarAcao();
    }


    private void iniciarVariaveis() {
        btn_login = findViewById(R.id.btn_login);
    }

    private void iniciarAcao() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataActivity.class);
                startActivity(intent);
            }
        });

    }
}
