package com.everis.androidteste_bankapp.model.retrofit;

import com.everis.androidteste_bankapp.model.statementlist.StatementList;
import com.everis.androidteste_bankapp.model.statementlist.StatementReceive;
import com.everis.androidteste_bankapp.model.user.UserAccount;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonHolder {

    @POST("login")
    Call<UserAccount> getUserAccount(
    @Field("user") String user,
    @Field("password") String password
    );


    @GET("statements/{mId}")
    Call<StatementReceive> getStatement(@Path("mId") String id);
}
