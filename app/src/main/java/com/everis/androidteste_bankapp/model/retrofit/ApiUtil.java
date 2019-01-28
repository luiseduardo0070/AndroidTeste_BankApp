package com.everis.androidteste_bankapp.model.retrofit;

public class ApiUtil {

    private static final String BASE_URL = "https://bank-app-test.herokuapp.com/api/";

    public static JsonHolder getServiceClass(){
        return RetrofitInitializer.getRetrofit(BASE_URL).create(JsonHolder.class);
    }
}
