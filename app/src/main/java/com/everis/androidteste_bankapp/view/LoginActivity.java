package com.everis.androidteste_bankapp.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.everis.androidteste_bankapp.R;

import java.util.regex.Pattern;

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
                userLogin();
            }
        });
    }

        private boolean isValidUser(){
            boolean status =!et_name.getText().toString().equalsIgnoreCase("");
            return status;
        }

        private boolean isValidPassword(){
        boolean status = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
                .matcher(et_pass.getText().toString()).matches();
        return status;
        }

        private void userLogin(){
            String user = et_name.getText().toString().trim();
            String password = et_pass.getText().toString().trim();

            if (user.isEmpty()) {
                et_name.setError("User is required");
                et_name.requestFocus();
                return;
            } else if (password.isEmpty()) {
                et_pass.setError("Password is required");
                et_name.requestFocus();
                return;
            } else if (isValidUser() && isValidPassword()){
                Intent intent = new Intent(getApplicationContext(), DataActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "User or password incorrect", Toast.LENGTH_SHORT).show();
            }

        }


}