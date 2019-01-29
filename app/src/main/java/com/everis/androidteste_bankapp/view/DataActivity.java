package com.everis.androidteste_bankapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.everis.androidteste_bankapp.R;
import com.everis.androidteste_bankapp.adapter.AdapterList;
import com.everis.androidteste_bankapp.model.retrofit.ApiUtil;
import com.everis.androidteste_bankapp.model.statementlist.StatementList;
import com.everis.androidteste_bankapp.model.statementlist.StatementReceive;
import com.everis.androidteste_bankapp.model.user.UserReceive;
import com.everis.androidteste_bankapp.util.Format;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity {

    private final String TAG = DataActivity.class.getSimpleName();

    private RecyclerView rv_list;

    private Button btn_logout;
    private TextView tv_name;
    private TextView tv_account;
    private TextView tv_balance;
    private Format format;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        iniciarVariaveis();
        iniciarAcao();
    }

    private void iniciarVariaveis() {
        btn_logout = findViewById(R.id.btn_logout);
        tv_name = findViewById(R.id.tv_name);
        tv_account = findViewById(R.id.tv_account);
        tv_balance = findViewById(R.id.tv_balance);

        rv_list = findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_list.setLayoutManager(linearLayoutManager);
        rv_list.setHasFixedSize(true);

        ApiUtil.getServiceClass().getStatement("1").enqueue(new Callback<StatementReceive>() {
            @Override
            public void onResponse(Call<StatementReceive> call, Response<StatementReceive> response) {
                if (response.isSuccessful()) {
                    StatementReceive statementReceive = response.body();
                    List<StatementList> statementLists = statementReceive.getStatementList();
                    Log.d(TAG, "Returned count" + statementLists.size());
                    AdapterList adapter = new AdapterList(getApplicationContext(), statementLists);
                    rv_list.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<StatementReceive> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something goes wrong", Toast.LENGTH_SHORT).show();
            }
        });


        ApiUtil.getServiceClass().getUserAccount("test_user", "Test@1").enqueue(new Callback<UserReceive>() {
            @Override
            public void onResponse(Call<UserReceive> call, Response<UserReceive> response) {
                UserReceive userReceive = response.body();

                tv_name.setText(userReceive.getUserAccount().getName());
                tv_account.setText(userReceive.getUserAccount().getBankAccount() + " / " + userReceive.getUserAccount().getAgency());
                String balance = userReceive.getUserAccount().getBalance().toString().replace(".", "");
                balance = format.SetCurrencyInstanceInt(Double.parseDouble(balance));
                tv_balance.setText(balance);
            }

            @Override
            public void onFailure(Call<UserReceive> call, Throwable t) {
            }
        });

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
