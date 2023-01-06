package com.example.itsmarts.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//mandamos a llamar los servicios web
public class service {

    public static Retrofit createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://practicaits2022-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
