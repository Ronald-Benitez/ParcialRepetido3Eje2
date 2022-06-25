package com.example.parcialrepetido3eje2.api;

import com.example.parcialrepetido3eje2.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("/posts")
    public abstract Call<List<User>> listaUsuarios();
}
