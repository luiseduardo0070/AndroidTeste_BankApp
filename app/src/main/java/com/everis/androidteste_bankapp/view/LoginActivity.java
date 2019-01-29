package com.everis.androidteste_bankapp.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.everis.androidteste_bankapp.R;
import com.everis.androidteste_bankapp.viewmodel.LoginViewModel;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private TextInputEditText et_name;
    private TextInputEditText et_pass;
    private LoginViewModel loginViewModel;
    private static final String USER_PREFS = "userPrefs";
    private static final String USER = "text";
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new LoginViewModel(getApplicationContext());

        startVars();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
                userLogin();
            }
        });

        loadUser();
        updateViews();

    }

    private void startVars() {

        btn_login = findViewById(R.id.btn_login);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);

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

            //loginViewModel.setSavedUser(user);
            //et_name.setText(user);

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
                //loginViewModel.saveUser(user);
            } else {
                Snackbar.make(getCurrentFocus(), "User or password incorrect", Toast.LENGTH_SHORT).show();
            }

        }

        private void saveUser(){
            SharedPreferences sharedPreferences = getSharedPreferences(USER_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(USER, et_name.getText().toString());
            editor.apply();
            Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_SHORT).show();
        }

        private void loadUser(){
            SharedPreferences sharedPreferences = getSharedPreferences(USER_PREFS, MODE_PRIVATE);
            user = sharedPreferences.getString(USER, "");
        }

        private void updateViews(){
            et_name.setText(user);
        }
}