package com.example.parcialrepetido3eje2.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connect {
    public static Retrofit retrofit = null;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getConnection() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
