package com.everis.androidteste_bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DataActivity extends AppCompatActivity {

    private Button btn_logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        iniciarVariaveis();
        iniciarAcao();
    }


    private void iniciarVariaveis() {
        btn_logout = findViewById(R.id.btn_logout);
    }

    private void iniciarAcao() {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
